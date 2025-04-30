package com.example.projetopraticopoo.DAO;

import com.example.projetopraticopoo.DTO.DoadorDTO;

import java.sql.*;

public class DoadorDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "7004";

    public DoadorDAO() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS doadores (
                id INT PRIMARY KEY,
                nome_doador VARCHAR(100) NOT NULL,
                telefone INT NOT NULL,
                email VARCHAR(100) NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'doadores': " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void inserir(DoadorDTO dto) throws SQLException {
        criarTabelaSeNaoExistir();
        String sql = "INSERT INTO doadores (id, nome_doador, telefone, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getNomeDoador());
            stmt.setLong(3, dto.getTelefone());
            stmt.setString(4, dto.getEmail());

            stmt.executeUpdate();
        }
    }
}
