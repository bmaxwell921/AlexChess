package main.chess.model.notPieces;


/**
 * A rule to check if the given chess move can be made 
 * by the selected piece
 * @author Brandon
 *
 */
public class ValidLocationRule implements IChessRule {
		
	private ChessGameState state;
	
	public ValidLocationRule(ChessGameState state) {
		this.state = state;
	}
	
	/**
	 * Checks if the given location is possible to get
	 * to from the given piece
	 */
	@Override
	public boolean evaluateRule(ChessMove move) {
		if (!state.hasSelectedPiece()) {
			throw new IllegalStateException("Tried to move with no selected piece");
		}
		return state.getSelectedPiece().getMovePositions().contains(move.location) 
				|| state.getSelectedPiece().getAttackPositions().contains(move.location);
	}

}
