package tetris;
import javafx.scene.layout.Pane;

public class Board {
    BoardSquare[][] tiles;
    private Pane mainPane;
    private TetrisPiece piece;

    public Board(Pane mainPane) {
        this.mainPane = mainPane;
        this.tiles = new BoardSquare[Constants.NUM_ROW][Constants.NUM_COLUMN];
        for (int row = 0; row < Constants.NUM_ROW; row++) {
            for (int col = 0; col < Constants.NUM_COLUMN; col++) {
                if (row == 0 || row == Constants.NUM_ROW - 1 || col == 0 || col == Constants.NUM_COLUMN - 1) {
                    this.tiles[row][col] = new BoardSquare(this.mainPane, row, col);
                    this.tiles[row][col].setColor(Constants.BORDER_COLOR);
                }
            }
        }
    }
    //returns this.tiles, so I can fetch it from other classes
    public BoardSquare[][] getBoard() {
        return this.tiles;
    }
    //Checks if a row is completely full
    public Boolean isFull(int row, int col) {
        if (this.tiles[row][col] != null) {
            return true;
        }
        return false;
    }
    //Checks if there are any pieces in the top as well as if the color is the same color as the border or not
    public Boolean stopGame() {
        for (int i = 0; i < Constants.NUM_ROW; i++) {
            for (int j = 0; j < Constants.NUM_COLUMN; j++) {
                if (this.tiles[i][j] != null && this.tiles[i][j].getColor() != Constants.BORDER_COLOR) {
                    if (i <= 1) {
                        return true;
                    }
                }
            }
        }return false;
    }
    //Checks if there is absoultely anything in the row
    public Boolean rowIsNotEmpty(int row) {
        for (int i = 0; i < this.tiles[row].length; i++) {
            if (this.tiles[row][i] == null) return false;
        }
        return true;
    }
}
