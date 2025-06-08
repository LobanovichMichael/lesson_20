package org.example.lesson_20;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private VBox box;

    private boolean isCross = true;

    int fieldLength = 3;

    private ArrayList<ArrayList<Integer>> field = new ArrayList<>(fieldLength);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < fieldLength; i++) {
            field.add(new ArrayList<>(fieldLength));
            for (int j = 0; j < fieldLength; j++) {
                field.get(i).add(null);
            }
        }
        for (Node hBox: box.getChildren()) {
            HBox currentBox = (HBox) hBox;
            for (Node button: currentBox.getChildren()) {
                Button b = (Button) button;
                b.setOnAction(e -> {
                    if (!b.getText().isEmpty()) {
                        return;
                    }
                    System.out.println(field.toString());
                    int row = Integer.parseInt(b.getId().split("_")[1]);
                    int column = Integer.parseInt(b.getId().split("_")[2]);
                    if (isCross) {
                        b.setText("X");
                        field.get(row).set(column, 1);
                    } else {
                        b.setText("O");
                        field.get(row).set(column,0);
                    }
                    isCross = !isCross;

                });
            }
        }
    }

    private void checkWin(){

    }
}