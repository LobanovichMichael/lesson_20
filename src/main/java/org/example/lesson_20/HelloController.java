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
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private VBox box;
    @FXML
    private Label messageLabel;
    @FXML
    private Button playAgainButton;

    private boolean isCross = true;

    int fieldLength = 3;

    private ArrayList<ArrayList<Integer>> field = new ArrayList<>(fieldLength);
    private String firstPlayerName, secondPlayerName;

    public HelloController(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public void setNames(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < fieldLength; i++) {
            field.add(new ArrayList<>(fieldLength));
            for (int j = 0; j < fieldLength; j++) {
                field.get(i).add(null);
            }
        }
        System.out.println(firstPlayerName + " " + secondPlayerName);
        for (Node hBox: box.getChildren()) {
            HBox currentBox = (HBox) hBox;
            for (Node button: currentBox.getChildren()) {
                Button b = (Button) button;
                b.setOnAction(e -> {
                    if (!b.getText().isEmpty()) {
                        return;
                    }
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
                    if (checkWin() != null){
                        finishGame("Выиграли " + checkWin());
                    } else if (isDraw()) {
                        finishGame("Ничья");
                    }
                });
            }
        }
    }

    private void finishGame(String endMessage) {
        messageLabel.setText(endMessage);
        changeButtonsDisableState(true);
        playAgainButton.setVisible(true);
    }


    private boolean isDraw() {
        for (int i = 0; i < fieldLength; i++) {
            for (int j = 0; j < fieldLength; j++) {
                if (field.get(i).get(j) == null) {
                    return false;
                }
            }
        }
        return true;
    }


    private String checkWin() {
        final int size = fieldLength;

        for (int i = 0; i < size; i++) {
            if (field.get(i).get(0) != null &&
                    field.get(i).get(0) == field.get(i).get(1) &&
                    field.get(i).get(1) == field.get(i).get(2)) {
                return field.get(i).get(0) == 1 ? "X" : "O";
            }
        }

        for (int j = 0; j < size; j++) {
            if (field.get(0).get(j) != null &&
                    field.get(0).get(j) == field.get(1).get(j) &&
                    field.get(1).get(j) == field.get(2).get(j)) {
                return field.get(0).get(j) == 1 ? "X" : "O";
            }
        }

        if (field.get(0).get(0) != null &&
                field.get(0).get(0) == field.get(1).get(1) &&
                field.get(1).get(1) == field.get(2).get(2)) {
            return field.get(0).get(0) == 1 ? "X" : "O";
        }

        if (field.get(0).get(2) != null &&
                field.get(0).get(2) == field.get(1).get(1) &&
                field.get(1).get(1) == field.get(2).get(0)) {
            return field.get(0).get(2) == 1 ? "X" : "O";
        }
        return null;
    }

    @FXML
    private void playAgainClick(){
        changeButtonsDisableState(false);
        for (int i = 0; i < fieldLength; i++) {
            for (int j = 0; j < fieldLength; j++) {
                field.get(i).set(j, null);
            }
        }
        isCross = true;
        messageLabel.setText("");
        playAgainButton.setVisible(false);
        for (Node hBox: box.getChildren()) {
            HBox currentBox = (HBox) hBox;
            for (Node button: currentBox.getChildren()) {
                Button b = (Button) button;
                b.setText("");
            }
        }
    }


    private void changeButtonsDisableState(boolean disable) {
        for (Node hBox: box.getChildren()) {
            HBox currentBox = (HBox) hBox;
            for (Node button: currentBox.getChildren()) {
                Button b = (Button) button;
                b.setDisable(disable);
            }
        }
    }


}