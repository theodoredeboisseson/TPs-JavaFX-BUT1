package fr.umontpellier.iut.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.exit;

public class IHMPendu extends Application {

    private int nbVies = 7;
    private ImageView pendu;
    private Label etatVies = new Label("Nombre de vies restantes: "+ nbVies);
    private Label text = new Label("Cliquez sur un lettre");
    private VBox inputsLettres = new VBox();
    private char[] motCache;
    private Label affichageMot;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox content = new VBox();
        root.setCenter(content);
        content.setAlignment(Pos.CENTER);
        content.setSpacing(10);

        root.setStyle(
                "-fx-background-color: #e8fcf4;"
        );

        Dico dico = new Dico();
        String mot = dico.getMot();
        motCache = new char[mot.length()];
        Arrays.fill(motCache, '*');
        affichageMot = new Label(new String(motCache));

        pendu = new ImageView(STR."exercice6/pendu\{nbVies}.png");

        makeLettersButtons(dico,mot);

        content.getChildren().addAll(pendu,etatVies,affichageMot,text,inputsLettres);

        Scene scene = new Scene(root,500,500);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    private void makeLettersButtons(Dico dico, String mot){
        String voyelles = "aeiouy";
        HBox boxVoyelles = makeLettersBox(dico, mot, voyelles);

        String consonnes1 = "bcdfghjklm";
        HBox boxConsonnes1 = makeLettersBox(dico, mot, consonnes1);

        String consonnes2 = "npqrstvwxz";
        HBox boxConsonnes2 = makeLettersBox(dico, mot, consonnes2);

        boxVoyelles.setAlignment(Pos.CENTER);
        boxConsonnes1.setAlignment(Pos.CENTER);
        boxConsonnes2.setAlignment(Pos.CENTER);
        inputsLettres.setAlignment(Pos.CENTER);

        inputsLettres.getChildren().addAll(boxVoyelles,boxConsonnes1,boxConsonnes2);
    }

    private HBox makeLettersBox(Dico dico, String mot, String consonnes) {
        HBox boxLettres = new HBox();
        for(int i = 0; i < consonnes.length(); i++){
            char lettre = consonnes.charAt(i);
            Button bouton = new Button(lettre+"");
            bouton.setOnAction(testAnswer(lettre,dico,mot));
            bouton.setStyle(
                    "-fx-border-color: orange;"+
                    "-fx-background-color: none;"+
                    "-fx-border-radius: 10px;"+
                    "-fx-font-size: 20px;"+
                    "-fx-font-family: Calibri;"+
                    "-fx-font-weight: bold"
            );

            boxLettres.getChildren().add(bouton);
        }
        return boxLettres;
    }

    private EventHandler<ActionEvent> testAnswer(char lettre, Dico dico, String mot) {
        return actionEvent -> {
            ArrayList<Integer> positions = dico.getPositions(lettre, mot);
            if(!positions.isEmpty()){
                for(Integer i : positions)
                    motCache[i] = lettre;
                text.setText("Lettre correcte!");
                affichageMot.setText(new String(motCache));
                if(new String(motCache).equals(mot)){
                    text.setText("Mot trouvé, bien joué le s!");
                    pendu.setImage(new Image("/exercice6/penduWin.png"));
                }
            } else {
                nbVies--;
                if(nbVies == -1)
                    exit(0);

                etatVies.setText("Nombre de vies restantes: "+ nbVies);
                pendu.setImage(new Image(STR."exercice6/pendu\{nbVies}.png") );
                if(nbVies == 0)
                    text.setText("Perdu, le mot était "+mot);
                else
                    text.setText("Le mot ne contiens pas la lettre "+lettre);
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
