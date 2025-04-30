package com.example.projetopraticopoo.DAO;

import com.example.projetopraticopoo.DTO.DoacaoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "7004";

    public DoacaoDAO() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS doacoes (
                id INT PRIMARY KEY,
                doador VARCHAR(100) NOT NULL,
                entidade VARCHAR(100) NOT NULL,
                item_doador VARCHAR(100) NOT NULL,
                quantidade INT NOT NULL,
                data_doacao DATE NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'doacoes': " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void inserir(DoacaoDTO dto) throws SQLException {
        String sql = "INSERT INTO doacoes (id, doador, entidade, item_doador, quantidade, data_doacao) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getDoador());
            stmt.setString(3, dto.getEntidade());
            stmt.setString(4, dto.getItemDoador());
            stmt.setInt(5, dto.getQuantidade());
            stmt.setDate(6, new java.sql.Date(dto.getDataDoacao().getTime()));

            stmt.executeUpdate();
        }
    }

    public List<DoacaoDTO> listarTodas() throws SQLException {
        List<DoacaoDTO> doacoes = new ArrayList<>();
        String sql = "SELECT * FROM doacoes";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DoacaoDTO doacao = new DoacaoDTO(
                        rs.getInt("id"),
                        rs.getString("doador"),
                        rs.getString("entidade"),
                        rs.getString("item_doador"),
                        rs.getInt("quantidade"),
                        rs.getDate("data_doacao")
                );
                doacoes.add(doacao);
            }
        }
        return doacoes;
    }

}
