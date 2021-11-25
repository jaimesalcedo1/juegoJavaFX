package com.example.juegojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MenuController extends Application{

    private Button startButton;
    private Button exitButton;

    public MenuController(Button startButton, Button exitButton){
        this.startButton = startButton;
        this.exitButton = exitButton;

        initiateControlls();
    }

    private void initiateControlls() {
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                try {
                    start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                launch();

            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Game(), 500, 500);
        stage.setTitle("TankFX");
        stage.getIcons().add(new Image("tankUp.png"));
        stage.setScene(scene);
        stage.show();
    }
}
