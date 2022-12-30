package tetris;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Random;
public class TetrisPiece {
    private BoardSquare[] squares;
    private Pane mainPane;
    private Board board;
    private int rand;
    public TetrisPiece(Pane mainPane, Board board) {
        this.board = board;
        this.squares = new BoardSquare[Constants.NUM_SQUARES];
        this.mainPane = mainPane;
        this.generateSquares();
    }
    //Method containing a switch statement to generate my squares
    public void generateSquares() {
        Random pieceChoose = new Random();
        rand = pieceChoose.nextInt(7);
        int pos = 6;
        switch (rand) {
            case 0:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.I_PIECE_COORDS[i][0] + 1, Constants.I_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.PALEVIOLETRED);
                }
                break;
            case 1:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.T_PIECE_COORDS[i][0] + 2, Constants.T_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.DARKORANGE);
                }
                break;
            case 2:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.SQUARE_PIECE_COORDS[i][0] + 1, Constants.SQUARE_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.GREENYELLOW);
                }
                break;
            case 3:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.RIGHT_L_PIECE_COORDS[i][0] + 1, Constants.RIGHT_L_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.OLIVE);
                }
                break;
            case 4:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.LEFT_L_PIECE_COORDS[i][0] + 1, Constants.LEFT_L_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.YELLOW);
                }
                break;
            case 5:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.LEFT_ZIGZAG_PIECE_COORDS[i][0] + 1, Constants.LEFT_ZIGZAG_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.BLUEVIOLET);
                }
                break;
            case 6:
                for (int i = 0; i < Constants.NUM_SQUARES; i++) {
                    this.squares[i] = new BoardSquare(mainPane, Constants.RIGHT_ZIGZAG_PIECE_COORDS[i][0] + 1, Constants.RIGHT_ZIGZAG_PIECE_COORDS[i][1] + pos);
                    this.squares[i].setColor(Color.PURPLE);
                }
                break;
            default:
                break;
        }
    }
    //Moves the piece down in a loop until it cannot move down anymore
    public void movePieceDownImmediately() {
        while(movePieceDownValid()) {
            this.movePieceDown();
        }
    }
    //Checks if the piece can move down anymore and if it can it moves the piece down
    public void movePieceDown() {
        if (movePieceDownValid()) {
            this.down();
        }
    }
    //Checks if the piece can move left anymore and if it can it moves the piece left
    public void movePieceLeft() {
        if (movePieceLeftValid()) {
            if (movePieceDownValid()) {
                this.left();
            }
        }
    }
    //Checks if the piece can move right anymore and if it can it moves the piece right
    public void movePieceRight() {
        if (movePieceRightValid()) {
            if (movePieceDownValid()) {
                this.right();
            }
        }
    }
    /*Makes sure it is not a square piece and checks to make sure the piece won't rotate into border,
    then rotates piece
     */
    public void rotatePiece() {
        if (rand != 2) {
            if (rotatePieceValid()) {
                rotate();
            }
        }
    }
    //Moves the piece by the width of a square
    public void down() {
        for (int i = 0; i < 4; i++) {
            this.squares[i].setY(this.squares[i].getY() + Constants.SQUARE_WIDTH);
        }
    }
    //Moves the piece left by the width of a square
    public void left() {
        for (int i = 0; i < 4; i++) {
            this.squares[i].setX(this.squares[i].getX() - Constants.SQUARE_WIDTH);
        }
    }
    //Moves the piece right by the width of a square
    public void right() {
        for (int i = 0; i < 4; i++) {
            this.squares[i].setX(this.squares[i].getX() + Constants.SQUARE_WIDTH);
        }
    }
    //Sets a center of rotation and rotates the squares around the center of rotation
    public void rotate() {
        for (int i = 0; i < 4; i++) {
            int centerOfRotationX = (int) this.squares[2].getX();
            int centerOfRotationY = (int) this.squares[2].getY();
            int oldXLocation = (int) this.squares[i].getX();
            int oldYLocation = (int) this.squares[i].getY();
            int newXLoc = (centerOfRotationX - centerOfRotationY + oldYLocation);
            int newYLoc = (centerOfRotationY + centerOfRotationX - oldXLocation);
            this.squares[i].setX(newXLoc);
            this.squares[i].setY(newYLoc);
        }
    }
    //Checks to see if there are pieces or a border where the piece wants to move down
    public Boolean movePieceDownValid() {
        for (int i = 0; i < 4; i++) {
            if (this.board.isFull(this.squares[i].getRow() + 1, this.squares[i].getColumn())) {
                return false;
            }
        }
        return true;
    }
    //Checks to see if there are pieces or a border where the piece wants to move left
    public Boolean movePieceLeftValid() {
        for (int i = 0; i < squares.length; i++) {
            if (this.board.isFull(this.squares[i].getRow(), this.squares[i].getColumn() - 1)) {
                return false;
            }
        }
        return true;
    }
    //Checks to see if there are pieces or a border where the piece wants to move right
    public Boolean movePieceRightValid() {
        for (int i = 0; i < squares.length; i++)
            if (this.board.isFull(this.squares[i].getRow(), this.squares[i].getColumn() + 1)) {
                return false;
            }
        return true;
    }
    //Checks to see if the place the piece wants to move to is on the board
    public boolean rotatePieceValid() {
        for (int i = 0; i < 4; i++) {
            int centerOfRotationX = (int) this.squares[2].getX();
            int centerOfRotationY = (int) this.squares[2].getY();
            int oldXLocation = (int) this.squares[i].getX();
            int oldYLocation = (int) this.squares[i].getY();
            int newXLoc = (centerOfRotationX - centerOfRotationY + oldYLocation);
            int newYLoc = (centerOfRotationY + centerOfRotationX - oldXLocation);
            if(newXLoc/Constants.SQUARE_WIDTH < 0 || newXLoc/Constants.SQUARE_WIDTH >= Constants.NUM_COLUMN ) {
                return false;
            }
                if (this.board.isFull(newYLoc / Constants.SQUARE_WIDTH, newXLoc / Constants.SQUARE_WIDTH)) {
                    return false;
            }
        }
        return true;
    }
    //Adds the pieces to the board and generates a new piece once it can no longer move down
    public void checkNewPiece() {
        if (movePieceDownValid()) {
        } else {
            this.addToBoard();
            this.generateSquares();
        }
    }
    //Converts the tetris pieces into parts of the board to allow for interaction
    private void addToBoard() {
        for (int i = 0; i < 4; i++) {
            this.board.getBoard()[this.squares[i].getRow()][this.squares[i].getColumn()] = squares[i];
        }
    }
    //Clears the full lines of pieces
    public void clearLines() {
        for (int i = 23; i > 1; i--) {
            if (this.board.rowIsNotEmpty(i)) {
                removeRow(this.board.getBoard()[i]);
                this.moveRowDown(i);
            }
        }
    }
    //Removes an entire row
    private void removeRow(BoardSquare[] row) {
        for (int i = 1; i < row.length -1; i++) {
            this.mainPane.getChildren().remove(row[i].getSquare());
            row[i] = null;
        }
    }
    //Moves each row above the removed row down by however many empty rows there are
    private void moveRowDown(int row) {
        for (int i = row; i > 1; i--) {
            for (int j = 1; j < Constants.NUM_COLUMN - 1; j++) {
                if (this.board.getBoard()[i][j] != null) {
                    this.board.getBoard()[i][j].setY((this.board.getBoard()[i][j].getRow() + 1) * Constants.SQUARE_WIDTH);
                    this.board.getBoard()[i + 1][j] = this.board.getBoard()[i][j];
                    this.board.getBoard()[i][j] = null;
                }
            }
        }
    }
}



