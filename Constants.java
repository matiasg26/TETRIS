package tetris;

import javafx.scene.paint.Color;

public class Constants {

    // width of each square
    public static final int SQUARE_WIDTH = 30;

    // coordinates for squares in each tetris piece
    public static final int[][] I_PIECE_COORDS = {{0, 0}, {1, 0}, {2, 0 }, {3, 0}};
    public static final int[][] T_PIECE_COORDS = {{-1 , 0},{-1 , 2 },{-1 , 1}, {0, 1}};
    public static final int[][] SQUARE_PIECE_COORDS = {{0 , 0}, {0 , 1}, {1 , 0}, {1 , 1}};
    public static final int[][] RIGHT_L_PIECE_COORDS = {{0,0},{0,1},{1,0},{2,0}};
    public static final int[][] LEFT_L_PIECE_COORDS = {{0,0},{0,1},{1,1},{2,1}};
    public static final int[][] LEFT_ZIGZAG_PIECE_COORDS = {{0,0},{1,0},{1,1},{2,1}};
    public static final int[][] RIGHT_ZIGZAG_PIECE_COORDS = {{0,1},{1,1},{1,0},{2,0}};
    public static Color BORDER_COLOR = Color.IVORY;

    //frame dimensions
    public static int FRAME_WIDTH = 390;
    public static int FRAME_HEIGHT = 790;
    //rows and columns
    public static int NUM_COLUMN = 13;
    public static int NUM_ROW = 25;
    public static int NUM_SQUARES = 4;
}
