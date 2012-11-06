package main.chess.model;

import java.awt.Point;

/**
 * A class to hold all the information about a given chess piece
 * @author Brandon
 *
 */
public abstract class ChessPiece {
	
	public enum ColorEnum {BLACK, WHITE};
	


	//Piece's current location on board
	private Point location;
	
	//Piece's color, black or white. If you don't understand Enums look it up or text me
	private ColorEnum color;
	
	public ChessPiece(ColorEnum color, Point pos) {
		this.color = color;
		this.location = pos;
	}
	
	/**
	 * A method to get the locations that this piece can move to. 
	 *                     -----------NOTE---------------
	 *                     This method must handle pieces blocking other pieces 
	 * @param b 
	 * 			the current game board
	 * @return 
	 * 			an array of points representing the locations on the board that can be moved to 
	 */
	public abstract Point[] getValidMoveLocations(Board b);
	
	/**
	 * A method to get all the locations that this piece can attack at it's current location.
	 * 					----------NOTE----------
	 * 					Like the getValidMoveLocations method this must handle pieces blocking
	 * 					each other
	 * @param b 
	 * 			the current game board
	 * @return
	 * 			an array of the pieces that this piece can attack. Return an empty array if there
	 * 			aren't any. This will NOT return any NullPieces
	 */
	public abstract ChessPiece[] getAttackedPieces(Board b);
	
	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}
	
	public ColorEnum getColor() {
		return color;
	}
	
	
	

}
