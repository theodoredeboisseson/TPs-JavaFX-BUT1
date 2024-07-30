package fr.umontpellier.iut.exercice5;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;

    @FXML
    public void initialize(){
        createBindings();
    }

    private void createBindings() {
        //Champ password
        BooleanBinding bindPasswordAvailability = Bindings.createBooleanBinding(
                () -> userId.getText().length() < 6,
                        userId.textProperty()
        );

        pwd.disableProperty().bind(bindPasswordAvailability);

        //Bouton cancel
        BooleanBinding bindCancelButtonAvailability = Bindings.createBooleanBinding(
                () -> userId.getText().isEmpty() && pwd.getText().isEmpty(),
            userId.textProperty(),
                pwd.textProperty()
        );

        cancelBtn.disableProperty().bind(bindCancelButtonAvailability);

        //Bouton ok
        BooleanBinding bindOkButtonAvailability = Bindings.createBooleanBinding(
                () -> pwd.getText().length() < 8
                        || !pwd.getText().matches(".*[A-Z].*")
                        || !pwd.getText().matches(".*[0-9].*"),
                userId.textProperty(),
                pwd.textProperty()
        );

        okBtn.disableProperty().bind(bindOkButtonAvailability);
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}