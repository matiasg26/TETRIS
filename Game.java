package tetris;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Game {
    private Pane mainPane;
    private Timeline tetTimeline;
    private Board board;
    private BoardSquare square;
    private TetrisPiece piece;
    private int countP;
    private Label label;
    private VBox labelBox;

    public Game(Pane mainPane, BoardSquare square) {
        countP = 0;
        this.label = new Label();
        this.labelBox = new VBox(label);
        this.square = square;
        this.mainPane = mainPane;
        this.board = new Board(this.mainPane);
        this.piece = new TetrisPiece(mainPane, board);
        this.tetrisTimeLine();
        this.mainPane.setOnKeyPressed((KeyEvent e) -> this.handleKeyPress(e));
        this.mainPane.setFocusTraversable(true);
    }
    //Timeline that controls the whole game
    private void tetrisTimeLine() {
        KeyFrame ef = new KeyFrame(Duration.seconds(.3), (f) -> {
            this.piece.movePieceDown();
            this.piece.checkNewPiece();
            this.piece.clearLines();
            this.board.stopGame();
            if (this.board.stopGame()) {
                this.gameOver();
            }
        });
        this.tetTimeline = new Timeline(ef);
        this.tetTimeline.setCycleCount(Animation.INDEFINITE);
        this.tetTimeline.play();
    }
    //Ends the game if the stopGame conditions are met
    public void gameOver() {
        if(this.board.stopGame()) {
            this.tetTimeline.stop();
            this.label.setText("Game Over!");
            this.setUpLabel();
        }
    }
    //Controls all the key input of the game
    public void handleKeyPress(KeyEvent e) {
        KeyCode keyPressed = e.getCode();
        switch (keyPressed) {
            case RIGHT:
                if(board.stopGame()==false) {
                    if (handlePause()) {
                        piece.movePieceRight();
                    }
                }
                break;
            case LEFT:
                if(board.stopGame()==false) {
                    if (handlePause()) {
                        piece.movePieceLeft();
                    }
                }
                break;
            case UP:
                if(board.stopGame()==false) {
                    if (handlePause()) {

                        piece.rotatePiece();
                    }
                }
                break;
            case DOWN:
                if(board.stopGame()==false) {
                    if (handlePause()) {
                        piece.movePieceDown();;
                    }
                }
                break;
            case SPACE:
                if(board.stopGame()==false) {
                    if (handlePause()) {
                        piece.movePieceDownImmediately();
                    }
                }
                break;
            case P:
                if(board.stopGame()==false) {
                    countP = countP + 1;
                    this.handlePause();
                 if (countP %2 ==0) {
                this.mainPane.getChildren().remove(labelBox);
                } else {
                this.setUpLabel();
                this.label.setText("PAUSED");
                }
                }
                break;
        }
        e.consume();
    }
    //Handles the pausing and un-pausing of the timeline based on when the button is pressed
    private Boolean handlePause() {
        if (countP % 2 == 1) {
            this.tetTimeline.stop();
            return false;
        } else {
            this.tetTimeline.play();
        }
        return true;
    }
    //Sets up the label for pause and game over (borrowed from Snake)
    private void setUpLabel() {
        labelBox.setAlignment(Pos.CENTER);
        labelBox.setPrefHeight(this.mainPane.getHeight());
        labelBox.setPrefWidth(this.mainPane.getWidth());
        label.setStyle("-fx-font: italic bold 45px arial, serif;-fx-text-alignment: center;-fx-text-fill: white;");

        Color[] colors = new Color[]{Color.web("#E00009"), Color.web("#E47C00"), Color.web("#ECEF02"),
                Color.web("#65F400"), Color.web("#51B5FF")};
        DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.web("#E02EF3"),
                0, 10, 2, 2);
        for (Color color : colors) {
            DropShadow temp = new DropShadow(BlurType.GAUSSIAN, color, 0, 10, 2, 2);
            temp.setInput(shadow);
            shadow = temp;
        }
        label.setEffect(shadow);
        this.mainPane.getChildren().add(labelBox);
    }
}


