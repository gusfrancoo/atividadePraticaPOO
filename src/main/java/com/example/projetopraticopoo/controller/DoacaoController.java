package com.example.projetopraticopoo.controller;

import com.example.projetopraticopoo.DAO.DoacaoDAO;
import com.example.projetopraticopoo.DTO.DoacaoDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DoacaoController {

    @FXML
    private TextField campoId, campoDoador, campoEntidade, campoItem, campoQuantidade;

    @FXML
    private DatePicker campoData;

    @FXML
    private Label successText, erroText;

    private final DoacaoDAO doacaoDAO = new DoacaoDAO();

    @FXML
    protected void onCadastrarDoacaoClick() {
        try {
            successText.setText("");
            erroText.setText("");

            int id = Integer.parseInt(campoId.getText());
            String doador = campoDoador.getText();
            String entidade = campoEntidade.getText();
            String item = campoItem.getText();
            int quantidade = Integer.parseInt(campoQuantidade.getText());
            LocalDate localDate = campoData.getValue();
            Date dataDoacao = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            DoacaoDTO doacao = new DoacaoDTO(id, doador, entidade, item, quantidade, dataDoacao);

            doacaoDAO.inserir(doacao);

            successText.setText("Doação cadastrada com sucesso!");

            campoId.clear();
            campoDoador.clear();
            campoEntidade.clear();
            campoItem.clear();
            campoQuantidade.clear();
            campoData.setValue(null);
        } catch (NumberFormatException e) {
            erroText.setText("ID e Quantidade devem ser números inteiros.");
        } catch (SQLException e) {
            erroText.setText("Erro no banco: " + e.getMessage());
        } catch (Exception e) {
            erroText.setText("Erro: " + e.getMessage());
        }
    }
}
