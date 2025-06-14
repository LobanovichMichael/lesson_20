package org.example.lesson_20;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartGame {

    @FXML
    private TextField firstPlayerName;

    @FXML
    private TextField secondPlayerName;

    @FXML
    private void startGameClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        HelloController controller = new HelloController(firstPlayerName.getText(), secondPlayerName.getText());
        fxmlLoader.setController(controller);
//        ((HelloController)fxmlLoader.getController()).setNames(firstPlayerName.getText(), secondPlayerName.getText());
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) firstPlayerName.getScene().getWindow();
        stage.setScene(scene);
    }
}
