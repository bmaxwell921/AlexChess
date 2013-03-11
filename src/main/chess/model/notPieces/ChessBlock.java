package main.chess.model.notPieces;

import java.awt.Point;

import main.chess.common.Constants.ColorEnum;
import main.chess.model.pieces.ChessPiece;

/**
 * A class to box up a ChessPiece and a location on the board
 * @author Brandon
 *
 */
public class ChessBlock implements Comparable<ChessBlock> {

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
	private ColorEnum blockColor;
	
	/**
	 * A constructor to set up this chess block
	 * @param piece
	 * 				the piece that goes in this location, or null if empty
	 * @param location
	 * 					the location of this piece on the board
	 */
	public ChessBlock(ChessPiece piece, Point location, ColorEnum blockColor) {
		this.piece = piece;
		this.location = location;
		this.blockColor = blockColor;
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
	
	public ColorEnum getBlockColor() {
		return blockColor;
	}

	public void setBlockColor(ColorEnum blockColor) {
		this.blockColor = blockColor;
	}

	@Override
	public int compareTo(ChessBlock o) {
		if (this.getPiece() == null && o.getPiece() == null) {
			return 0;
		}
		else if (this.getPiece() == null) {
			return -1;
		}
		else {
			return this.getPiece().compareTo(o.getPiece());
		}
	}
	
	@Override
	public Object clone() {
		return new ChessBlock((ChessPiece) this.piece.clone(), (Point) this.location.clone(), this.blockColor);
	}
}
