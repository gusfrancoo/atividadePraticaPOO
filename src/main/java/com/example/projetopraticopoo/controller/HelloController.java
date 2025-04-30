package com.example.projetopraticopoo.controller;

import com.example.projetopraticopoo.DAO.DoadorDAO;
import com.example.projetopraticopoo.DTO.DoadorDTO;
import com.example.projetopraticopoo.model.Doador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField campoId;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoEmail;

    @FXML
    private Label successText;

    @FXML
    private Label erroText;

    private final DoadorDAO doadorDAO = new DoadorDAO(); // instância do DAO

    @FXML
    protected void onCadastrarDoadorClick() {
        try {
            // Limpa mensagens anteriores
            successText.setText("");
            erroText.setText("");

            // Coleta os dados dos campos
            int id = Integer.parseInt(campoId.getText());
            String nomeDoador = campoNome.getText();
            int telefone = Integer.parseInt(campoTelefone.getText());
            String email = campoEmail.getText();

            // Cria o objeto DTO
            DoadorDTO novoDoadorDTO = new DoadorDTO(id, nomeDoador, telefone, email);

            // Insere no banco de dados
            doadorDAO.inserir(novoDoadorDTO);

            successText.setText("Doador cadastrado com sucesso!");

            // Limpa os campos após o cadastro
            campoId.clear();
            campoNome.clear();
            campoTelefone.clear();
            campoEmail.clear();

        } catch (NumberFormatException e) {
            erroText.setText("ID e Telefone devem ser números inteiros.");
        } catch (Exception e) {
            erroText.setText("Erro: " + e.getMessage());
        }
    }
}
