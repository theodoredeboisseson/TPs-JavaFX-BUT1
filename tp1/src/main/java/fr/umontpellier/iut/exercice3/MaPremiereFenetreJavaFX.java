package fr.umontpellier.iut.exercice3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Label hello = new Label("Hola que tal?");

        TextField textField = new TextField();
        textField.setMaxWidth(150);

        Button bonjour = new Button();
        bonjour.setGraphic(new ImageView("https://gitlabinfo.iutmontp.univ-montp2.fr/ihm/tp1/-/raw/master/images/logo.jpeg"));

        EventHandler<ActionEvent> direBonjour = actionEvent -> {
            if(!textField.getText().isEmpty()){
                hello.setText(STR."Hola que tal, \{textField.getText()}?");
                bonjour.setGraphic(new ImageView("exercice3/Bonjour.jpg"));
            }

        };
        bonjour.setOnAction(direBonjour);
        textField.setOnAction(direBonjour);

        textField.setFont(new Font("Courier", 15));
        hello.setFont(new Font("Courier", 30));

        root.getChildren().addAll(hello,textField,bonjour);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("exercice3/Bonjour.css");
        primaryStage.setTitle("El Application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
