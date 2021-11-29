package com.example.rgbselectorfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class View extends VBox {
    private final Pane panel;
    private final HBox hboxRed;
    private final HBox hboxGreen;
    private final HBox hboxBlue;
    private final VBox selector;
    private final Slider sliderRed;
    private final Slider sliderGreen;
    private final Slider sliderBlue;
    private final Label red;
    private final Label green;
    private final Label blue;
    private final Label numRed;
    private final Label numGreen;
    private final Label numBlue;
    Controller controller;

    public View() {

        panel = new Pane();
        selector = new VBox();
        hboxRed = new HBox();
        hboxGreen = new HBox();
        hboxBlue = new HBox();
        sliderRed = new Slider();
        sliderGreen = new Slider();
        sliderBlue = new Slider();

        red = new Label(" R ");
        green = new Label(" G ");
        blue = new Label(" B ");
        numRed = new Label("0");
        numGreen = new Label("0");
        numBlue = new Label("0");
        controller = new Controller(sliderRed, sliderGreen, sliderBlue, numRed, numGreen, numBlue, panel);


        initView();
    }

    private void initView() {


        //Padding and set Colors
        panel.setPadding(new Insets(80));
        red.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
        numRed.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
        hboxRed.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        sliderRed.setMax(255);

        green.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
        numGreen.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
        hboxGreen.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sliderGreen.setMax(255);

        blue.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
        numBlue.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
        hboxBlue.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        sliderBlue.setMax(255);

        //Sets
        hboxRed.getChildren().addAll(red, sliderRed, numRed);
        hboxRed.setPadding(new Insets(10));
        hboxRed.prefHeightProperty().bind(this.heightProperty().divide(5));

        hboxGreen.getChildren().addAll(green, sliderGreen, numGreen);
        green.setAlignment(Pos.CENTER_LEFT);
        hboxGreen.setPadding(new Insets(10));
        hboxGreen.prefHeightProperty().bind(this.heightProperty().divide(5));

        hboxBlue.getChildren().addAll(blue, sliderBlue, numBlue);
        hboxBlue.setPadding(new Insets(10));
        hboxBlue.prefHeightProperty().bind(this.heightProperty().divide(5));


        panel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panel.prefHeightProperty().bind(this.heightProperty().divide(2));
        selector.getChildren().addAll(hboxRed, hboxGreen, hboxBlue);


        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(panel, selector);
        this.setPadding(new Insets(10));

    }
}
