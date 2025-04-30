package com.example.projetopraticopoo.DAO;

import com.example.projetopraticopoo.DTO.EntidadeAssistencialDTO;

import java.sql.*;

public class EntidadeAssistencialDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "7004";

    public EntidadeAssistencialDAO() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS entidades (
                id INT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                cnpj VARCHAR(20) NOT NULL,
                tipo VARCHAR(50) NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'entidades': " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void inserir(EntidadeAssistencialDTO dto) throws SQLException {
        criarTabelaSeNaoExistir();
        String sql = "INSERT INTO entidades (id, nome, cnpj, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getNome());
            stmt.setString(3, dto.getCnpj());
            stmt.setString(4, dto.getTipo());

            stmt.executeUpdate();
        }
    }
}
