package com.example.rgbselectorfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {
    private final Pane panel;
    private final Label numBlue;
    private final Label numGreen;
    private final Label numRed;
    private final Slider sliderRed;
    private final Slider sliderGreen;
    private final Slider sliderBlue;
    private final IntegerProperty valueRed;
    private final IntegerProperty valueGreen;
    private final IntegerProperty valueBlue;

    public Controller(Slider sliderRed, Slider sliderGreen, Slider sliderBlue, Label numRed,
                      Label numGreen, Label numBlue, Pane panel) {
        this.sliderRed = sliderRed;
        this.sliderGreen = sliderGreen;
        this.sliderBlue = sliderBlue;
        this.numRed = numRed;
        this.numGreen = numGreen;
        this.numBlue = numBlue;
        this.panel = panel;

        valueRed = new SimpleIntegerProperty();
        valueGreen = new SimpleIntegerProperty();
        valueBlue = new SimpleIntegerProperty();

        numRed.textProperty().bind(valueRed.asString());
        numGreen.textProperty().bind(valueGreen.asString());
        numBlue.textProperty().bind(valueBlue.asString());

        valueRed.bind(sliderRed.valueProperty());
        valueGreen.bind(sliderGreen.valueProperty());
        valueBlue.bind(sliderBlue.valueProperty());

        valueRed.addListener(v -> changeColor());
        valueGreen.addListener(v -> changeColor());
        valueBlue.addListener(v -> changeColor());
    }

    public void changeColor() {

        panel.setBackground(new Background(new BackgroundFill(
                Color.rgb(valueRed.get(), valueGreen.get(), valueBlue.get()),
                CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
