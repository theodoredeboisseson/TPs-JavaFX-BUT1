package fr.umontpellier.iut.exercice1;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMaths extends Application {

    DoubleProperty hauteurPage = new SimpleDoubleProperty();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
/*        root.prefHeightProperty().bind(hauteurPage);*/


        HBox top = new HBox();
        Label label = new Label("Combien d'exercices ?");
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(6, 9, 12, 15);
        top.getChildren().addAll(label, comboBox);
        top.setSpacing(10);
        top.setAlignment(Pos.CENTER);

        VBox pannelExos = new VBox();
        pannelExos.setAlignment(Pos.CENTER);
        pannelExos.setSpacing(10);

        comboBox.setOnAction(actionEvent -> {
            pannelExos.getChildren().clear();
            for (int i = 0; i < comboBox.getValue(); i++)
                pannelExos.getChildren().add(new LigneExercice());
            primaryStage.sizeToScene();
        });

/*        pannelExos.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) ->
                        hauteurPage.set(top.getPrefHeight()+pannelExos.getPrefHeight())
        );*/

        root.getChildren().addAll(top, pannelExos);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("App Maths");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
