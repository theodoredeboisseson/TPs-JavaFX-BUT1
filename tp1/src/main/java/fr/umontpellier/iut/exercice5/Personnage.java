package fr.umontpellier.iut.exercice5;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

class Personnage extends Group {
    protected final static double LARGEUR_MOITIE_PERSONNAGE = 10;
    protected final static double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
    private final Circle corps;
    private String direction;

    public Personnage(String direction, Color couleurContour, Color couleurRemplissage) {
        this.direction = direction;
        corps = new Circle(10, 10, LARGEUR_MOITIE_PERSONNAGE, couleurContour);
        corps.setFill(couleurRemplissage);
        getChildren().add(corps);
    }

    public void deplacerAGauche() {
        //    ****
        //   *    *
        //  *---   *
        //   *    *
        //    ****

        //déplacement <----
        if (getLayoutX() >= LARGEUR_PERSONNAGE)
            setLayoutX(getLayoutX() - LARGEUR_PERSONNAGE);
        if (!direction.equals("gauche"))
            direction = "gauche";
    }

    public void deplacerADroite(double largeurJeu) {
        //    ****
        //   *    *
        //  *   ---*
        //   *    *
        //    ****
        //déplacement ---->
        if (getLayoutX() < largeurJeu - LARGEUR_PERSONNAGE)
            setLayoutX(getLayoutX() + LARGEUR_PERSONNAGE);
        if (!direction.equals("droite"))
            direction = "droite";
    }

    public void deplacerEnBas(double hauteurJeu) {
        //    *****
        //   *     *
        //  *   |   *
        //   *  |  *
        //    *****
        if (getLayoutY() < hauteurJeu - LARGEUR_PERSONNAGE)
            setLayoutY(getLayoutY() + LARGEUR_PERSONNAGE);
        if (!direction.equals("bas"))
            direction = "bas";
    }

    public void deplacerEnHaut() {
        //    *****
        //   *  |  *
        //  *   |   *
        //   *     *
        //    *****
        if (getLayoutY() >= LARGEUR_PERSONNAGE)
            setLayoutY(getLayoutY() - LARGEUR_PERSONNAGE);
        if (!direction.equals("haut"))
            direction = "haut";
    }

    boolean estEnCollisionPersonnage(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }

    boolean estEnCollisionObstacle(List<Obstacle> obstacles){
        for(Obstacle o : obstacles)
            if(getBoundsInParent().contains(o.getBoundsInParent())
                    || o.getBoundsInParent().contains(getBoundsInParent()))
                return true;

        return false;
    }

}
