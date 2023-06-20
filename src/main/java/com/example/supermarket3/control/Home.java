package com.example.supermarket3.control;
import com.example.supermarket3.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Home {

    @FXML
    private Button close;

    @FXML
    private Button employee;

    @FXML
    private Button product;

    @FXML
    private Button services;

    @FXML
    private Button staties;

    @FXML
    void close(ActionEvent event) {

            Stage stage=(Stage) close.getScene().getWindow();
            stage.close();

    }


    @FXML
    void employee(ActionEvent event) {

    }

    @FXML
    void product(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("product.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void services(ActionEvent event) {

    }

    @FXML
    void staties(ActionEvent event) {

    }

}
