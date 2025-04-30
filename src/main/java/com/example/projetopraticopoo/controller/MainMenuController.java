package com.example.projetopraticopoo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private void abrirNovaTela(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projetopraticopoo/" + fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirCadastroDoador(ActionEvent event) {
        abrirNovaTela("hello-view.fxml");
    }

    public void abrirCadastroEntidade(ActionEvent event) {
        abrirNovaTela("entidade-view.fxml");
    }

    public void abrirCadastroDoacao(ActionEvent event) {
        abrirNovaTela("doacao-view.fxml");
    }

    public void abrirListagemDoacoes(ActionEvent event) {
        abrirNovaTela("doacoes-list-view.fxml");
    }
}
