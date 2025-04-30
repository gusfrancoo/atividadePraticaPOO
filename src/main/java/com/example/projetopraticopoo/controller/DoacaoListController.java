package com.example.projetopraticopoo.controller;

import com.example.projetopraticopoo.DAO.DoacaoDAO;
import com.example.projetopraticopoo.DTO.DoacaoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoacaoListController {

    @FXML
    private TableView<DoacaoDTO> tabelaDoacoes;

    @FXML
    private TableColumn<DoacaoDTO, Integer> colId;

    @FXML
    private TableColumn<DoacaoDTO, String> colDoador;

    @FXML
    private TableColumn<DoacaoDTO, String> colEntidade;

    @FXML
    private TableColumn<DoacaoDTO, String> colItemDoador;

    @FXML
    private TableColumn<DoacaoDTO, Integer> colQuantidade;

    @FXML
    private TableColumn<DoacaoDTO, Date> colDataDoacao;

    @FXML
    private TextField campoFiltro;

    @FXML
    private Label erroText;

    private final DoacaoDAO doacaoDAO = new DoacaoDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colDoador.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDoador()));
        colEntidade.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEntidade()));
        colItemDoador.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getItemDoador()));
        colQuantidade.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getQuantidade()).asObject());
        colDataDoacao.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getDataDoacao()));

        carregarDoacoes();
    }

    private void carregarDoacoes() {
        try {
            List<DoacaoDTO> doacoes = doacaoDAO.listarTodas();
            tabelaDoacoes.setItems(FXCollections.observableArrayList(doacoes));
            erroText.setText("");
        } catch (SQLException e) {
            erroText.setText("Erro ao carregar doações: " + e.getMessage());
        }
    }

    @FXML
    private void onBuscarClick() {
        try {
            String filtro = campoFiltro.getText().toLowerCase();
            List<DoacaoDTO> doacoes = doacaoDAO.listarTodas();
            List<DoacaoDTO> filtradas = new ArrayList<>();

            for (DoacaoDTO d : doacoes) {
                if (d.getDoador().toLowerCase().contains(filtro) || d.getEntidade().toLowerCase().contains(filtro)) {
                    filtradas.add(d);
                }
            }
            tabelaDoacoes.setItems(FXCollections.observableArrayList(filtradas));
            erroText.setText("");
        } catch (SQLException e) {
            erroText.setText("Erro ao buscar doações: " + e.getMessage());
        }
    }

    @FXML
    private void onAtualizarClick() {
        carregarDoacoes();
        campoFiltro.clear();
    }
}
