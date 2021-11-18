package com.example.juegojavafx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameController {
    private Rectangle leftWall;
    private Rectangle rightWall;
    private Rectangle topWall;
    private Rectangle bottomWall;
    private Rectangle tank;
    private StackPane track;
    private double velocity;
    private Timeline animationR;
    private Timeline animationL;
    private Timeline animationU;
    private Timeline animationD;

    public GameController(Rectangle leftWall, Rectangle rightWall, Rectangle topWall,
                          Rectangle bottomWall, Rectangle tank, StackPane track){
        this.leftWall = leftWall;
        this.rightWall = rightWall;
        this.topWall = topWall;
        this.bottomWall = bottomWall;
        this.tank = tank;
        this.track = track;
        this.velocity = 1;

        initiateGame();
        initiateControlls();
    }

    private void initiateControlls() {

        track.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.RIGHT){
                    animationL.stop();
                    animationU.stop();
                    animationD.stop();
                    animationR.play();
                    tank.setFill(new ImagePattern(new Image("tankRight.png")));
                }
                if(keyEvent.getCode() == KeyCode.LEFT){
                    animationR.stop();
                    animationU.stop();
                    animationD.stop();
                    animationL.play();
                    tank.setFill(new ImagePattern(new Image("tankLeft.png")));
                }
                if(keyEvent.getCode() == KeyCode.UP){
                    animationR.stop();
                    animationL.stop();
                    animationD.stop();
                    animationU.play();
                    tank.setFill(new ImagePattern(new Image("tankUp.png")));
                }
                if(keyEvent.getCode() == KeyCode.DOWN){
                    animationR.stop();
                    animationL.stop();
                    animationU.stop();
                    animationD.play();
                    tank.setFill(new ImagePattern(new Image("tankDown.png")));
                }
                if(keyEvent.getCode() == KeyCode.SPACE){
                    Bounds position = tank.getBoundsInParent();
                    Rectangle bullet = new Rectangle();
                    bullet.setHeight(5);
                    bullet.setWidth(5);
                    bullet.setFill(Color.ORANGERED);
                    track.getChildren().add(bullet);
                }
            }
        });

        track.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.LEFT){
                    animationL.stop();
                    animationR.stop();
                    animationU.stop();
                    animationD.stop();
                }
                if(keyEvent.getCode() == KeyCode.RIGHT){
                    animationL.stop();
                    animationR.stop();
                    animationU.stop();
                    animationD.stop();
                }
                if(keyEvent.getCode() == KeyCode.UP){
                    animationL.stop();
                    animationR.stop();
                    animationU.stop();
                    animationD.stop();
                }
                if(keyEvent.getCode() == KeyCode.DOWN){
                    animationL.stop();
                    animationR.stop();
                    animationU.stop();
                    animationD.stop();
                }
            }
        });

        track.setFocusTraversable(true);
    }

    private void initiateGame(){

        this.animationR = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveTankRight();
        }));
        animationR.setCycleCount(Animation.INDEFINITE);

        this.animationL = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveTankLeft();
        }));
        animationL.setCycleCount(Animation.INDEFINITE);

        this.animationU = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveTankUp();
        }));
        animationU.setCycleCount(Animation.INDEFINITE);

        this.animationD = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveTankDown();
        }));
        animationD.setCycleCount(Animation.INDEFINITE);
    }

    private void moveTankRight() {
        tank.setTranslateX(tank.getTranslateX()+1);
    }

    private void moveTankLeft(){
        tank.setTranslateX(tank.getTranslateX()-1);
    }

    private void moveTankUp(){
        tank.setTranslateY(tank.getTranslateY()-1);
    }

    private void moveTankDown(){
        tank.setTranslateY(tank.getTranslateY()+1);
    }

    private void detectCollide(){
        while(tank.getBoundsInParent().intersects(topWall.getBoundsInLocal())){
            System.out.println("colisión");
        }
    }

    private void shootBullet(){
        
    }
}
