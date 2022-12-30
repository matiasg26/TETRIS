package tetris;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardSquare {
    private Rectangle square;
    private int row;
    private int col;
    private Pane mainPane;
    private Color originalColor;

    public BoardSquare(Pane mainPane, int row, int col) {
        this.mainPane = mainPane;
        this.row = row;
        this.col = col;
        this.originalColor = null;
        this.square = new Rectangle(col * Constants.SQUARE_WIDTH, row * Constants.SQUARE_WIDTH,
                Constants.SQUARE_WIDTH, Constants.SQUARE_WIDTH);
        this.square.setStroke(Color.BLACK);
        mainPane.getChildren().add(this.square);
    }
    //Sets x location of the squares
    public void setX(double x) {
        square.setX(x);
    }
    //Sets y location of the squares
    public void setY(double y) {
        square.setY(y);
    }
    //Returns the y location of the square
    public double getY() {
        return square.getY();
    }
    //Returns the x location of the square
    public double getX() {
        return square.getX();
    }
    //Returns the row the square is in
    public int getRow() {
        return (int) square.getY() / Constants.SQUARE_WIDTH;
    }
    //Returns the column the square is in
    public int getColumn() {
        return (int) square.getX() / Constants.SQUARE_WIDTH;
    }
    //Sets the color of the square
    public void setColor(Color color) {
        this.square.setFill(color);
    }
    //Returns the color of the square
    public Color getColor() {return (Color) this.square.getFill();}
    //Returns a square
    public Rectangle getSquare() {
        return this.square;
    }
}
