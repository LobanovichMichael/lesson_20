package org.example.lesson_20;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private VBox box;

    private boolean isCross = true;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Node hBox: box.getChildren()) {
            HBox currentBox = (HBox) hBox;
            for (Node button: currentBox.getChildren()) {
                Button b = (Button) button;
                b.setOnAction(e -> {
                    if (!b.getText().isEmpty()) {
                        return;
                    }
                    if (isCross) {
                        b.setText("X");
                    } else {
                        b.setText("O");
                    }
                    isCross = !isCross;

                });
            }
        }
    }
}