package fr.umontpellier.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Fantome extends Personnage {

    private Rectangle basCorps;


    private Circle oeilGauche;
    private Circle retineGauche;

    private Circle oeilDroit;
    private Circle retineDroite;


    public Fantome() {
        super("droite", Color.BLUE, Color.BLUE);
        basCorps = new Rectangle(0, 10, 20, 10);
        basCorps.setFill(Color.BLUE);

        oeilGauche = new Circle(6, 6, 2, Color.WHITE);
        //regarde vers la droite
        retineGauche = new Circle(oeilGauche.getCenterX() + 1, 6, 1, Color.BLACK);

        oeilDroit = new Circle(14, 6, 2, Color.WHITE);
        //regarde vers la droite
        retineDroite = new Circle(oeilDroit.getCenterX() + 1, 6, 1, Color.BLACK);


        super.getChildren().add(basCorps);
        super.getChildren().add(oeilGauche);
        super.getChildren().add(retineGauche);
        super.getChildren().add(oeilDroit);
        super.getChildren().add(retineDroite);
    }

    @Override
    public void deplacerAGauche() {
        super.deplacerAGauche();
        //sens des yeux
        deplacerYeuxFantome(-1,0);
    }

    @Override
    public void deplacerADroite(double largeurJeu) {
        super.deplacerADroite(largeurJeu);
        //sens des yeux
        deplacerYeuxFantome(1,0);
    }

    @Override
    public void deplacerEnBas(double hauteurJeu) {
        super.deplacerEnBas(hauteurJeu);
        //sens des yeux
        deplacerYeuxFantome(0,1);
    }

    @Override
    public void deplacerEnHaut() {
        super.deplacerEnHaut();
        //sens des yeux
        deplacerYeuxFantome(0,-1);
    }

    public void deplacerYeuxFantome(int deplacementHozirontal, int deplacementVertical){
        retineGauche.setLayoutX(oeilGauche.getLayoutX() -1 + deplacementHozirontal);
        retineGauche.setLayoutY(oeilGauche.getLayoutY() + deplacementVertical);

        retineDroite.setLayoutX(oeilDroit.getLayoutX() -1 + deplacementHozirontal);
        retineDroite.setLayoutY(oeilDroit.getLayoutY() + deplacementVertical);

    }

}
