package main.chess.model.notPieces;

public class MyTurnRule implements IChessRule {

	/*
	 * The current state of the game
	 */
	private ChessGameState state;
	
	public MyTurnRule(ChessGameState state) {
		this.state = state;
	}
	
	@Override
	public boolean evaluateRule(ChessMove move) {
		return state.isCurrentPlayersPiece(move.piece);
	}

}
