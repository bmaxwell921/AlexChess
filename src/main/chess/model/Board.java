package main.chess.model;

import java.awt.Color;
import java.awt.Point;

import main.chess.model.ChessPiece.ColorEnum;

public class Board {

	private final int HEIGHT = 8;
	private final int WIDTH = 8;
	
	/**
	 * The array representation of the board
	 */
	private ChessBlock[][] board;
	
	public Board() {
		board = new ChessBlock[HEIGHT][WIDTH];
		
		//Sets up the black and white squares
		boolean curWhite = false;
		boolean rowStartWhite = false;
		for (int i = 0; i < HEIGHT; ++i) {
			curWhite = rowStartWhite;
			for (int j = 0; j < WIDTH; ++j) {
				board[j][i] = new ChessBlock(
						new Rook(ColorEnum.BLACK, new Point(i, j)), 
						new Point(j, i), curWhite ? ColorEnum.WHITE : ColorEnum.BLACK);
				curWhite = !curWhite;
			}
			rowStartWhite = !rowStartWhite;
		}
		
		//TODO set up the pieces in their default locations
	}
	
	/**
	 * A constructor that reads the locally saved game board from the file system
	 * @param source
	 * 					the serialized version of this board
	 */
	public Board(String source) {
		//TODO Brandon. Alex, let me handle this one, unless you're done with
		//everything else and want to do some string parsing
	}
	
	/**
	 * A method to move a piece from one location on the board to another
	 * @param fromLocation
	 * 						the location of the piece to be moved			
	 * @param toLocation
	 * 						the location to where the piece should move
	 * @return	
	 * 			the success or failure of the move. Conditions for failure include, non 
	 * existent piece at fromLocation
	 */
	public boolean movePiece(Point fromLocation, Point toLocation) {
		//TODO
		return false;
	}
	
	/**
	 * A method that returns whether moving a piece from fromLocation to toLocation
	 * will result in a piece being captured
	 * -----------------------NOTE: This method might be useless-------------------------------
	 * @param fromLocation
	 * 						the location being moved from
	 * @param toLocation
	 * 						the location being moved to
	 * @return
	 */
	public boolean willCapture(Point fromLocation, Point toLocation) {
		//TODO
		return false;
	}
	
	/**
	 * A method to return the configuration of the board
	 * @return
	 */
	public ChessBlock[][] getBoard() {
		return board;
	}
	
	public ChessBlock getBlock(Point loc) {
		return board[loc.y][loc.x];
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
}
