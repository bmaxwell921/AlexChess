package main.chess.model.notPieces;

import main.chess.player.ChessPlayer;

/**
 * Class to check that the selected piece is the same color as the player
 * who selected it
 * @author Brandon
 *
 */
public class MyPieceRule implements IChessRule {

	/*
	 * A player to represent this player 
	*/
	private ChessPlayer me;
	
	public MyPieceRule(ChessPlayer me) {
		this.me = me;
	}
	
	@Override
	public boolean evaluateRule(ChessMove move) {
		return move.piece == null || move.piece.getColor() == me.getColor();
	}
}
