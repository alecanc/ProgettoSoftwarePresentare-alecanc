package com.example.progettosoftware.GestioneProfilo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SchermataVisualizzaProfilo {
    @FXML
    private Label nomeLabel;
    @FXML
    private Label cognomeLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void showDati(ActionEvent event, ArrayList<String> dati) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/progettosoftware/Profilo/VisualizzaProfilo.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
       nomeLabel.setText(dati.get(0));
        cognomeLabel.setText(dati.get(1));

            stage.show();
    }

}
