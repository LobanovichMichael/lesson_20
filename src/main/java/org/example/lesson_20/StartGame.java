package org.example.lesson_20;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartGame implements Initializable {

    @FXML
    private TextField firstPlayerName;

    @FXML
    private TextField secondPlayerName;

    private int firstScore = 0;
    private int secondScore = 0;


    @FXML
    private void startGameClick() throws IOException {
        if (firstPlayerName.getText().isEmpty() || secondPlayerName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Укажите оба имени");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            NamesData.compareNames(firstPlayerName.getText(), secondPlayerName.getText());
            NamesData.firstName = firstPlayerName.getText();
            NamesData.secondName = secondPlayerName.getText();
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 600, 400);
            Stage stage = (Stage) firstPlayerName.getScene().getWindow();
            stage.setScene(scene);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (NamesData.firstName != null && NamesData.secondName != null) {
            firstPlayerName.setText(NamesData.firstName);
            secondPlayerName.setText(NamesData.secondName);
        }
    }
}
