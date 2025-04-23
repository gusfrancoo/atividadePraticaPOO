package com.example.projetopraticopoo.DAO;

import com.example.projetopraticopoo.DTO.SolicitacaoEquipamentoDTO;

import java.sql.*;

public class SolicitacaoEquipamentoDAO {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "7004";

    public SolicitacaoEquipamentoDAO() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS solicitacoes (
                id INT PRIMARY KEY,
                nome_colaborador VARCHAR(100) NOT NULL,
                equipamento VARCHAR(100) NOT NULL,
                data_solicitacao DATE NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'solicitacoes': " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void inserir(SolicitacaoEquipamentoDTO dto) throws SQLException {
        String sql = "INSERT INTO solicitacoes (id, nome_colaborador, equipamento, data_solicitacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getNomeColaborador());
            stmt.setString(3, dto.getEquipamento());
            stmt.setDate(4, new java.sql.Date(dto.getDataSolicitacao().getTime()));

            stmt.executeUpdate();
        }
    }
}
