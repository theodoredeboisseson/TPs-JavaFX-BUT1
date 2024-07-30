package fr.umontpellier.iut.exercice2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PanneauPrincipal extends GridPane {

    private final double taillePanneau = 300;
    private final double valeurMaxCoordonnees = 20;
    private final double ratioDessin = taillePanneau / valeurMaxCoordonnees;

    private final Rectangle rectangle = new Rectangle();

    public PanneauPrincipal() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("exercice2/fenetrePerimetre.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addLines();
        setByMinusAction();
        setByPlusAction();
        bindSommetsRectangle();
        bindPerimeterTextField();
        bindHorizontal1();
        bindHorizontal2();
        bindVertical1();
        bindVertical2();
    }

    private void addLines() { // Partie B Question 2
        throw new RuntimeException("Méthode à implémenter");
    }

    @FXML // Partie B Question 1 et onAction correspondant dans panneau.fxml
    public void decrementerBx() {
        throw new RuntimeException("Méthode à implémenter");
    }

    @FXML // Partie B Question 1 et onAction correspondant dans panneau.fxml
    public void incrementerBx() {
        throw new RuntimeException("Méthode à implémenter");
    }

    private void setByPlusAction() { // Partie B Question 3
        throw new RuntimeException("Méthode à implémenter");
    }

    private void setByMinusAction() { // Partie B Question 3
        throw new RuntimeException("Méthode à implémenter");
    }

    private void bindSommetsRectangle() { // Partie C Question 1
        throw new RuntimeException("Méthode à implémenter");
    }

    private void bindPerimeterTextField() { // Partie C Question 2
        throw new RuntimeException("Méthode à implémenter");
    }

    private void bindHorizontal1() { // Partie C Question 3
        throw new RuntimeException("Méthode à implémenter");
    }

    private void bindHorizontal2() { // Partie C Question 3
        throw new RuntimeException("Méthode à implémenter");
    }

    private void bindVertical1() { // Partie C Question 3
        throw new RuntimeException("Méthode à implémenter");
    }

    private void bindVertical2() { // Partie C Question 3
        throw new RuntimeException("Méthode à implémenter");
    }

}
