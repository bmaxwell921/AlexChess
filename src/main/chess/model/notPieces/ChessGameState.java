package main.chess.model.notPieces;

import java.util.ArrayList;
import java.util.List;

import main.chess.common.Constants.ColorEnum;
import main.chess.common.Constants.GameStateEnum;
import main.chess.model.pieces.ChessPiece;

public class ChessGameState {

	/*
	 * The currently selected piece, or null
	 */
	private ChessPiece selectedPiece;
	
	/*
	 * Count of the number of moves made so far
	 */
	private int numMoves;
	
	/*
	 * Lists for the pieces each player has lost
	 */
	private List<ChessPiece> whiteLostPieces;
	private List<ChessPiece> blackLostPieces;

	private GameStateEnum state;
	
	public ChessGameState() {
		selectedPiece = null;
		numMoves = 0;
		
		whiteLostPieces = new ArrayList<ChessPiece>();
		blackLostPieces = new ArrayList<ChessPiece>();
		
		state = GameStateEnum.WHITE_NORMAL;
	}
	
	/**
	 * A method to check if the given piece is one of the 
	 * current player's pieces
	 * @param piece
	 * 				The piece to check
	 * @return
	 * 			True if the given piece belongs to the current player
	 */
	public boolean isCurrentPlayersPiece(ChessPiece piece) {
		if (piece == null) return true;
		if (piece.getColor() == ColorEnum.BLACK) {
			return state == GameStateEnum.BLACK_CHECKED || state == GameStateEnum.BLACK_CHECKMATED 
					|| state == GameStateEnum.BLACK_NORMAL;
		} else {
			return state == GameStateEnum.WHITE_CHECKED || state == GameStateEnum.WHITE_CHECKMATED
					|| state == GameStateEnum.WHITE_NORMAL;
		}
	}
	
	/**
	 * A method to add a captured piece
	 * @param killed
	 * 				The piece that was captured
	 */
	public void addLostPiece(ChessPiece killed) {
		List<ChessPiece> theDead = (killed.getColor() == ColorEnum.WHITE) ? whiteLostPieces : blackLostPieces;
		theDead.add(killed);
	}
	
	/**
	 * A method to promote a pawn to the given piece
	 * @param toRelive
	 * 					The piece the pawn is promoting to
	 */
	public void removeLostPiece(ChessPiece toRelive) {
		List<ChessPiece> theDead = (toRelive.getColor() == ColorEnum.WHITE) ? whiteLostPieces : blackLostPieces;
		theDead.remove(toRelive);
	}
	
	/**
	 * A method to check if there is a selected piece currently
	 * @return
	 * 			True if there is a selected piece, false otherwise
	 */
	public boolean hasSelectedPiece() {
		return selectedPiece != null;
	}
	
	/**
	 * A method to deselect the currently selected piece
	 */
	public void deselectPiece() {
		selectedPiece = null;
	}
	
	/**
	 * A method to change the state in normal conditions. Normal
	 * conditions mean from white's move to black's, then black's to white's
	 */
	public void changeStateNormally() {
		this.changeState((state == GameStateEnum.WHITE_NORMAL) ? 
				GameStateEnum.BLACK_NORMAL : GameStateEnum.WHITE_NORMAL);
	}
	
	/**
	 * A method to update the current state to the next state
	 * @param newState
	 * 					The next state to move to
	 */
	public void changeState(GameStateEnum newState) {
		state = newState;
	}
	
	public ChessPiece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(ChessPiece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	public int getNumMoves() {
		return numMoves;
	}

	public void setNumMoves(int numMoves) {
		this.numMoves = numMoves;
	}

	public List<ChessPiece> getWhiteLostPieces() {
		return whiteLostPieces;
	}

	public void setWhiteLostPieces(List<ChessPiece> whiteLostPieces) {
		this.whiteLostPieces = whiteLostPieces;
	}

	public List<ChessPiece> getBlackLostPieces() {
		return blackLostPieces;
	}

	public void setBlackLostPieces(List<ChessPiece> blackLostPieces) {
		this.blackLostPieces = blackLostPieces;
	} 

	public GameStateEnum getState() {
		return state;
	}
}
