package fr.umontpellier.iut.exercice2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;

public class CustomButton extends Button {

    private String couleur;
    private IntegerProperty nbClics;

    public CustomButton(String texte, String couleur) {
        super(texte);
        this.couleur = couleur;
        nbClics = new SimpleIntegerProperty();
    }

    public void incrementNbClics(){
        nbClics.setValue(nbClics.get()+1);
    }

    public IntegerProperty nbClicsProperty() {
        return nbClics;
    }

    public int getNbClics() {
        return nbClics.get();
    }

    public String getCouleur() {
        return couleur;
    }

}
