package com.example.juegojavafx;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Game extends BorderPane {

    private final StackPane track;
    private Rectangle leftWall;
    private Rectangle rightWall;
    private Rectangle topWall;
    private Rectangle bottomWall;
    private Rectangle tank;
    private GameController controller;

    public Game() {

        //Instanciar
        this.leftWall = new Rectangle();
        this.rightWall = new Rectangle();
        this.topWall = new Rectangle();
        this.bottomWall = new Rectangle();
        this.tank = new Rectangle();
        this.track = new StackPane();
        this.controller = new GameController(leftWall, rightWall, topWall, bottomWall, tank, track);

        //Inicializar
        Image hWall = new Image("stone2.jpg");
        Image vWall = new Image("stone1.jpg");
        track.setStyle("-fx-background-image: url(grass.png);");
        leftWall.setFill(new ImagePattern(vWall));
        leftWall.heightProperty().bind(track.heightProperty());
        leftWall.widthProperty().bind(track.widthProperty().divide(25));
        rightWall.setFill(new ImagePattern(vWall));
        rightWall.heightProperty().bind(track.heightProperty());
        rightWall.widthProperty().bind(track.widthProperty().divide(25));
        topWall.heightProperty().bind(track.heightProperty().divide(30));
        topWall.widthProperty().bind(track.widthProperty());
        topWall.setFill(new ImagePattern(hWall));
        bottomWall.heightProperty().bind(track.heightProperty().divide(30));
        bottomWall.widthProperty().bind(track.widthProperty());
        bottomWall.setFill(new ImagePattern(hWall));
        tank.heightProperty().bind(track.heightProperty().divide(20));
        tank.widthProperty().bind(track.widthProperty().divide(20));
        Image imageTank = new Image("tankUp.png");
        tank.setFill(new ImagePattern(imageTank));

        //Colocar
        track.getChildren().addAll(leftWall, rightWall, topWall, bottomWall, tank);
        track.setAlignment(leftWall, Pos.CENTER_LEFT);
        track.setAlignment(rightWall, Pos.CENTER_RIGHT);
        track.setAlignment(topWall, Pos.TOP_CENTER);
        track.setAlignment(bottomWall, Pos.BOTTOM_CENTER);
        track.setAlignment(tank, Pos.CENTER);
        this.setCenter(track);
    }
}
