package main.chess.model;

import java.awt.Color;
import java.awt.Point;

/**
 * A class to box up a ChessPiece and a location on the board
 * @author Brandon
 *
 */
public class ChessBlock {

	/**
	 * The piece held in this block. If null then this block is empty
	 */
	private ChessPiece piece;
	
	/**
	 * The location of this block
	 */
	private Point location;
	
	/**
	 * The color of THIS block, not the color of the chess piece
	 */
	private Color blockColor;
	
	/**
	 * A constructor to set up this chess block
	 * @param piece
	 * 				the piece that goes in this location, or null if empty
	 * @param location
	 * 					the location of this piece on the board
	 */
	public ChessBlock(ChessPiece piece, Point location, Color blockColor) {
		// TODO
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public void setPiece(ChessPiece piece) {
		this.piece = piece;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Color getBlockColor() {
		return blockColor;
	}

	public void setBlockColor(Color blockColor) {
		this.blockColor = blockColor;
	}
}
