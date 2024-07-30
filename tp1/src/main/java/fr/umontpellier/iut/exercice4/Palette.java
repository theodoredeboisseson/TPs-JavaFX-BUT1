package fr.umontpellier.iut.exercice4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        HBox top = new HBox();
        label = new Label();
        top.getChildren().add(label);
        panneau = new Pane();
        bas = new HBox();
        root.setTop(top);
        root.setCenter(panneau);
        root.setBottom(bas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        bas.getChildren().addAll(vert,rouge,bleu);

        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20));
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(10);
        bas.setPadding(new Insets(20));

        vert.setOnAction(actionEvent -> {
            panneau.setStyle("-fx-background-color: green");
            nbVert++;
            label.setText(STR."\{vert.getText()} cliqué \{nbVert} fois!");
        });
        rouge.setOnAction(actionEvent -> {
            panneau.setStyle("-fx-background-color: red");
            nbRouge++;
            label.setText(STR."\{rouge.getText()} cliqué \{nbRouge} fois!");
        });
        bleu.setOnAction(actionEvent -> {
            panneau.setStyle("-fx-background-color: blue");
            nbBleu++;
            label.setText(STR."\{bleu.getText()} cliqué \{nbBleu} fois!");
        });

        Scene scene = new Scene(root,400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

