package fr.umontpellier.iut.exercice5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private List<Obstacle> obstacles = new ArrayList<>();
    private int secondesRestantes = 20;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        Label label = new Label("Attrapez le fantôme en 20 secondes");
        root.setTop(label);

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        //obstacles
        obstacles.add(new Obstacle(50,100,300,100));
        jeu.getChildren().addAll(obstacles);

        //timer
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        event -> {
                            if (secondesRestantes > 0) {
                                secondesRestantes--;  // Décrémenter le compteur
                                label.setText("Timer: " + secondesRestantes + " sec");
                            } else {
                                label.setText("Timer terminé");
                            }
                        }
                )
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1 (up, down, right, left), pour le j2(z, q, s, d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double posX1 = j1.getLayoutX();
            double posY1 = j1.getLayoutX();
            double posX2 = j2.getLayoutX();
            double posY2 = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;

            }
            if (j1.estEnCollisionPersonnage(j2))
                alerteCollision();

            if (j1.estEnCollisionObstacle(obstacles)){
                j1.setLayoutX(posX1);
                j1.setLayoutY(posY1);
            }
            if (j2.estEnCollisionObstacle(obstacles)){
                j2.setLayoutX(posX2);
                j2.setLayoutY(posY2);
            }


        });
    }

    private void alerteCollision() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Collision");
        alert.setHeaderText("Collision détectée !");
        alert.setContentText("Les personnages sont entrés en collision.");
        alert.showAndWait();
    }


}
