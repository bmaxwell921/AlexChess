package main.chess.player;

import java.util.ArrayList;
import java.util.List;

import main.chess.common.Constants.ColorEnum;
import main.chess.model.ChessPiece;

public class ChessPlayer {

	//The name of this chess player
	private String name;
	
	//The color of this player
	private ColorEnum color;
	
	//A list of all the pieces this player has lost
	private List<ChessPiece> lostPieces;
	
	/**
	 * A constructor to create a Chess player
	 * @param name
	 * 				the name of this player
	 * @param color
	 * 				the color of this player
	 */
	
	public ChessPlayer(String name, ColorEnum color) {
		this.name = name;
		this.color = color;
		
		lostPieces = new ArrayList<ChessPiece>();		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ColorEnum getColor() {
		return color;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public List<ChessPiece> getLostPieces() {
		return lostPieces;
	}
	
	public void addLostPiece(ChessPiece piece) {
		if (piece != null)
			lostPieces.add(piece);
	}

}
