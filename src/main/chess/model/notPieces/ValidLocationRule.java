package main.chess.model.notPieces;

import main.chess.logic.ChessGame;

/**
 * A rule to check if the given chess move can be made 
 * by the selected piece
 * @author Brandon
 *
 */
public class ValidLocationRule implements IChessRule {
		
	/**
	 * Checks if the given location is possible to get
	 * to from the given piece
	 */
	@Override
	public boolean evaluateRule(ChessMove move) {
		return move.piece.getMovePositions().contains(move.location) 
				|| move.piece.getAttackPositions().contains(move.location);
	}

}
