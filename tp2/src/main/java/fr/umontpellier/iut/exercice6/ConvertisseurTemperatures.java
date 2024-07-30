package fr.umontpellier.iut.exercice6;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurTemperatures extends Application {

    private Slider sliderCelsius = sliderCelsius = new Slider(0, 100, 0);;
    private Slider sliderFahrenheit = sliderFahrenheit = new Slider(0, 212, 32);;

    private TextField textFieldCelsius = new TextField();
    private TextField textFieldFahrenheit = new TextField();

    private DoubleProperty celsiusProperty = new SimpleDoubleProperty();
    private DoubleProperty fahrenheitProperty = new SimpleDoubleProperty();

    @Override
    public void start(Stage primaryStage) {
        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);

        {
            Label labelCelsius = new Label("°C");
            Label labelFahrenheit = new Label("°F");

            sliderCelsius.setShowTickLabels(true);
            sliderFahrenheit.setShowTickLabels(true);
            sliderCelsius.setShowTickMarks(true);
            sliderFahrenheit.setShowTickMarks(true);
            sliderCelsius.setOrientation(Orientation.VERTICAL);
            sliderFahrenheit.setOrientation(Orientation.VERTICAL);
            sliderCelsius.setPrefHeight(400);
            sliderFahrenheit.setPrefHeight(400);
            sliderCelsius.setMajorTickUnit(10);
            sliderFahrenheit.setMajorTickUnit(10);

            textFieldCelsius.setPrefWidth(30);
            textFieldFahrenheit.setPrefWidth(30);

            panneauCelsius.getChildren().addAll(labelCelsius, sliderCelsius, textFieldCelsius);
            panneauFahrenheit.getChildren().addAll(labelFahrenheit, sliderFahrenheit, textFieldFahrenheit);
        }

        createBindings();

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void createBindings() {
        sliderCelsius.valueProperty().bindBidirectional(celsiusProperty);
        sliderFahrenheit.valueProperty().bindBidirectional(fahrenheitProperty);

        celsiusProperty.addListener((observable, oldValue, newValue) -> {
                fahrenheitProperty.set(newValue.doubleValue() * 1.8 + 32);
        });
        fahrenheitProperty.addListener((observable, oldValue, newValue) -> {
                celsiusProperty.set((newValue.doubleValue() - 32) / 1.8);
        });

        textFieldCelsius.textProperty().bindBidirectional(celsiusProperty, new javafx.util.converter.NumberStringConverter());
        textFieldFahrenheit.textProperty().bindBidirectional(fahrenheitProperty, new javafx.util.converter.NumberStringConverter());
    }

}