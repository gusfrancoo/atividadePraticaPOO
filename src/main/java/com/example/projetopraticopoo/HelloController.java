package com.example.projetopraticopoo;

import com.example.projetopraticopoo.DAO.SolicitacaoEquipamentoDAO;
import com.example.projetopraticopoo.DTO.SolicitacaoEquipamentoDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class HelloController {

    @FXML
    private TextField campoId;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEquipamento;

    @FXML
    private DatePicker campoData;

    @FXML
    private Label successText;

    @FXML
    private Label erroText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            int id = Integer.parseInt(campoId.getText());
            String nome = campoNome.getText();
            String equipamento = campoEquipamento.getText();
            LocalDate localDate = campoData.getValue();

            if (localDate == null) {
                successText.setText("Por favor, selecione uma data.");
                return;
            }

            Date data = java.sql.Date.valueOf(localDate);

            SolicitacaoEquipamentoDTO dto = new SolicitacaoEquipamentoDTO(id, nome, equipamento, data);
            SolicitacaoEquipamentoDAO dao = new SolicitacaoEquipamentoDAO();
            dao.inserir(dto);

            successText.setText("Solicitação enviada com sucesso!");

        } catch (NumberFormatException e) {
            erroText.setText("ID deve ser um número inteiro.");
        } catch (SQLException e) {
            erroText.setText("Erro ao inserir no banco: " + e.getMessage());
        } catch (Exception e) {
            erroText.setText("Erro: " + e.getMessage());
        }
    }
}
