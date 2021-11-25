package com.example.juegojavafx;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Menu extends BorderPane {

    private final Pane menu;
    private MenuController controller;
    private Button startButton;
    private Button exitButton;
    private Label title;
    private Label img;

    public Menu() {

        //Instanciar
        this.menu = new Pane();
        this.startButton = new Button("START");
        this.exitButton = new Button("EXIT");
        this.title = new Label("TankFX");
        this.img= new Label();

        //Inicializar
        menu.setMinSize(0,0);
        menu.setStyle("-fx-background-image: url(grass.png)");
        startButton.setPrefSize(100, 20);
        exitButton.setPrefSize(100,20);
        title.setStyle("-fx-background-color: grey");
        title.setPrefSize(300,100);
        title.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(title, 0.0);
        AnchorPane.setRightAnchor(title, 0.0);
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font(60));
        title.setStyle(
                "-fx-text-fill: red;" +
                "-fx-font-weight: bold;" +
                "-fx-underline: true;" +
                "-fx-background-color: null"
        );
        img.setPrefSize(100,100);
        img.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(img, 0.0);
        AnchorPane.setRightAnchor(img, 0.0);
        img.setAlignment(Pos.CENTER);
        ImageView view = new ImageView(new Image("tankUp.png"));
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        img.setGraphic(view);


        //Colocar
        menu.getChildren().addAll(startButton, exitButton, title, img);
        startButton.setLayoutX(200);
        startButton.setLayoutY(250);
        exitButton.setLayoutX(200);
        exitButton.setLayoutY(290);
        title.setLayoutX(100);
        title.setLayoutY(50);
        img.setLayoutX(200);
        img.setLayoutY(140);

        this.setCenter(menu);

    }
}
