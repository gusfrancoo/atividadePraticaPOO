module com.example.projetopraticopoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projetopraticopoo to javafx.fxml;
    exports com.example.projetopraticopoo;
    exports com.example.projetopraticopoo.controller;
    opens com.example.projetopraticopoo.controller to javafx.fxml;
}