package fr.umontpellier.iut.exercice1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class LigneExercice extends HBox {
    private Label enonce;
    private TextField reponse;
    private final Exercice exercice;

    public LigneExercice() {
        setPrefWidth(207);
        setPrefHeight(47);
        setSpacing(10);
        setPadding(new Insets(5));

        enonce = new Label();
        enonce.setStyle(
                "-fx-font-weight: bold;"
                + "-fx-font-size: 14;"
                + "-fx-background-color: LIGHTGREEN;"

        );
        enonce.setMinWidth(80);
        enonce.setAlignment(Pos.BASELINE_RIGHT);

        reponse = new TextField();
        reponse.setMaxWidth(40);

        getChildren().addAll(enonce, reponse);

        exercice = new Exercice();
        enonce.setText(exercice.getEnonce());


        reponse = new TextField();
        // L'objet TextFormatter suivant permet de restreindre le texte aux chiffres
        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
            String texte = change.getControlNewText();
            if (texte.matches("\\d*")) {
                return change;
            }
            return null;
        });
        reponse.setTextFormatter(textFormatter);
        // ici mettre la bonne taille du TextField

        IntegerProperty intReponse = new SimpleIntegerProperty();
        reponse.textProperty().bindBidirectional(intReponse, new NumberStringConverter());
    }
}
