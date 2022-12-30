package tetris;

import javafx.scene.layout.Pane;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTests {

    //Tests if a row is full. Bottom row is tested therefore should return true
    @Test
    public void testBoard(){
        Pane testPane = new Pane();
        Board testBoard = new Board(testPane);
        for(int i = 1; i <11; i++) {
            assertTrue(testBoard.isFull(24, i));
        }
    }

    //Tests to see if a piece can rotate. Piece cannot rotate and therefore should return false
    @Test
    public void testWrapperClass(){
        Pane testPane = new Pane();
        Board testBoard = new Board(testPane);
        TetrisPiece testPiece = new TetrisPiece(testPane,testBoard);
        assertFalse(testPiece.rotatePieceValid());
    }
}
