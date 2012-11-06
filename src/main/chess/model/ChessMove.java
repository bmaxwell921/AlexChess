package main.chess.model;

import java.awt.Point;

/**
 * A Class to box up a gamepiece and a location object
 * @author Brandon
 *
 */
public class ChessMove {

	//The chess piece to be moved
	public ChessPiece piece;
	
	//The location to move to
	public Point location;
	
	public ChessMove(ChessPiece piece, Point toLoc) {
		this.piece = piece;
		this.location = toLoc;
	}

}
