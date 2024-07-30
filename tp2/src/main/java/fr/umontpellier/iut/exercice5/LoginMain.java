package fr.umontpellier.iut.exercice5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("exercice5/LoginView.fxml"));


        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("FXML Custom Control");
        stage.show();
    }
}
