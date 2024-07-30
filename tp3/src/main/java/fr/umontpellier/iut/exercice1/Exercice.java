package fr.umontpellier.iut.exercice1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Exercice {
    private final String enonce;

    public Exercice() {
        Random random = new Random();
        int choice = random.nextInt(4);

        int operande1;
        int operande2;
        String symboleOperateur;
        switch (choice) {
            case 0 -> {
                operande1 = random.nextInt(26);
                operande2 = random.nextInt(26);
                symboleOperateur = "+";
            }
            case 1 -> {
                operande1 = random.nextInt(16) + 10;
                operande2 = random.nextInt(26);
                symboleOperateur = "-";
            }
            case 2 -> {
                operande1 = random.nextInt(15) + 1;
                operande2 = random.nextInt(15) + 1;
                symboleOperateur = "*";
            }
            default -> {
                operande1 = random.nextInt(151);
                operande2 = random.nextInt(15) + 1;
                symboleOperateur = "/";
            }
        }
        enonce = operande1 + " " + symboleOperateur + " " + operande2 + " = ";
    }

    public String getEnonce() {
        return enonce;
    }


}
