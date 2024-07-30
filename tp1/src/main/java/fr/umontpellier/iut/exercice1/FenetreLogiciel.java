package fr.umontpellier.iut.exercice1;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Configuration du menu
        MenuBar top = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New");
        MenuItem openFile = new MenuItem("Open");
        MenuItem saveFile = new MenuItem("Save");
        MenuItem closeFile = new MenuItem("Close");
        fileMenu.getItems().addAll(newFile, openFile, saveFile, closeFile);

        Menu editMenu = new Menu("Edit");
        MenuItem editCut = new MenuItem("Cut");
        MenuItem editCopy = new MenuItem("Copy");
        MenuItem editPaste = new MenuItem("Paste");
        editMenu.getItems().addAll(editCut, editCopy, editPaste);

        Menu helpMenu = new Menu("Help");

        top.getMenus().addAll(fileMenu, editMenu, helpMenu);
        root.setTop(top);

        // Configuration de la partie gauche
        HBox left = new HBox();
        left.setAlignment(Pos.CENTER);

        VBox leftContent = new VBox();
        leftContent.setAlignment(Pos.CENTER);
        leftContent.setSpacing(10);

        Label labelBoutons = new Label("Boutons:");
        Button bouton1 = new Button("Bouton 1");
        Button bouton2 = new Button("Bouton 2");
        Button bouton3 = new Button("Bouton 3");

        leftContent.getChildren().addAll(labelBoutons, bouton1, bouton2, bouton3);

        Separator verticalSeparator = new Separator();
        verticalSeparator.setOrientation(Orientation.VERTICAL);

        left.getChildren().addAll(leftContent, verticalSeparator);

        root.setLeft(left);

        // Configuration du GridPane au centre
        GridPane center = new GridPane();
        center.setAlignment(Pos.CENTER);
        center.setHgap(10);
        center.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        center.add(nameLabel, 0, 0);
        center.add(nameField, 1, 0);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        center.add(emailLabel, 0, 1);
        center.add(emailField, 1, 1);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        center.add(passwordLabel, 0, 2);
        center.add(passwordField, 1, 2);

        // Correction de la superposition des boutons
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        hBox.getChildren().addAll(submitButton,cancelButton);

        center.add(hBox, 0, 3,2,1);

        GridPane.setHalignment(hBox, HPos.CENTER);

        root.setCenter(center);

        // Configuration de la partie inférieure
        VBox bottom = new VBox();
        bottom.setAlignment(Pos.CENTER);

        Label bottomLabel = new Label("Ceci est un label de bas de page");
        bottom.getChildren().addAll(new Separator(), bottomLabel);

        root.setBottom(bottom);

        Scene scene = new Scene(root, 700, 500);

        primaryStage.setTitle("Apagnan");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
