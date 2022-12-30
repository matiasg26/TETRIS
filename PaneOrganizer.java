package tetris;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PaneOrganizer {
    private BorderPane root;
    private BoardSquare square;
    public PaneOrganizer() {
        Pane mainPane = new Pane();
        this.root = new BorderPane();
        this.root.setCenter(mainPane);
        this.createButtonPane();
        new Game(mainPane, square);
    }
    //Creates the quit button
    private void createButtonPane() {
        HBox buttonPane = new HBox();
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setPrefHeight(40);
        buttonPane.setStyle("-fx-background-color: rgb(0,0,0)");
        this.root.setBottom(buttonPane);
        Button button = new Button("Quit");
        button.setFocusTraversable(false);
        button.setOnAction((var0) -> {
            System.exit(0);
        });
        buttonPane.getChildren().add(button);
    }
    //Returns the BorderPane root
    public BorderPane getRoot() {
        return root;
    }
}
