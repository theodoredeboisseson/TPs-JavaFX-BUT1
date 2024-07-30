package fr.umontpellier.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    int counter = 0;

    @FXML
    Button incrementButton;
    @FXML
    Button decrementButton;
    @FXML
    Label counterLabel = new Label("0");

    public void increment() {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    public void decrement() {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
        incrementButton.setOnAction(e -> {increment();});
        decrementButton.setOnAction(e -> {decrement();});
   }
}
