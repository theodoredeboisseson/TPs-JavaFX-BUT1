package fr.umontpellier.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
import java.util.Random;


public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");

        Media inferno = new Media("file:///C:/Users/Theodoros/Desktop/dev/javafx/src/main/resources/exercice2/Inferno.mp3");
        MediaPlayer player = new MediaPlayer(inferno);
        player.setAutoPlay(true);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                root.add(forme(),i,j);

        root.setStyle(
                "-fx-background-color: white;"
        );

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Label forme(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        Label label = new Label();
        ImageView image = new ImageView();

        image = switch (randomNumber) {
            case 0 -> new ImageView("exercice2/Rond.png");
            case 1 -> new ImageView("exercice2/Croix.png");
            case 2 -> new ImageView("exercice2/Vide.png");
            default -> image;
        };

        image.setFitWidth(100);
        image.setFitHeight(100);
        label.setGraphic(image);

        label.setStyle(
                "-fx-border-color: lightgrey;" +
                        "-fx-border-width: 2px;"
        );

        return label;
    }

    public static void main(String[] args){
        launch(args);
    }
}


