package main.chess.model;

import java.awt.Point;

public class Board {

	private ChessBlock[][] board;
	
	public Board() {
		//TODO set up the pieces
	}
	
	/**
	 * A method to move a piece from one location on the board to another
	 * @param fromLocation
	 * 						the location of the piece to be moved			
	 * @param toLocation
	 * 						the location to where the piece should move
	 * @return	
	 * 			the success or failure of the move. Conditions for failure include, non existant piece
	 * 			at fromLocation, a piece at toLocation, etc
	 */
	public boolean movePiece(Point fromLocation, Point toLocation) {
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
	
	public ChessPiece getPieceAt(Point location) {
		//TODO
		return null;
	}
}
