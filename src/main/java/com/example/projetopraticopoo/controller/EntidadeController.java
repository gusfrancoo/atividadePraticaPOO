package com.example.projetopraticopoo.controller;

import com.example.projetopraticopoo.DAO.EntidadeAssistencialDAO;
import com.example.projetopraticopoo.DTO.EntidadeAssistencialDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EntidadeController {

    @FXML
    private TextField campoId, campoNome, campoCnpj, campoTipo;

    @FXML
    private Label successText, erroText;

    private final EntidadeAssistencialDAO entidadeDAO = new EntidadeAssistencialDAO();

    @FXML
    protected void onCadastrarEntidadeClick() {
        try {
            successText.setText("");
            erroText.setText("");

            int id = Integer.parseInt(campoId.getText());
            String nome = campoNome.getText();
            String cnpj = campoCnpj.getText();
            String tipo = campoTipo.getText();

            EntidadeAssistencialDTO entidade = new EntidadeAssistencialDTO(id, nome, cnpj, tipo);

            entidadeDAO.inserir(entidade);

            successText.setText("Entidade cadastrada com sucesso!");

            campoId.clear();
            campoNome.clear();
            campoCnpj.clear();
            campoTipo.clear();
        } catch (Exception e) {
            erroText.setText("Erro: " + e.getMessage());
        }
    }
}
