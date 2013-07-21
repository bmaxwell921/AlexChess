package main.chess.model.notPieces;

/**
 * A rule to check if the given movement is valid under
 * conditions of check
 * @author Brandon
 *
 */
public class MovingOutOfCheckRule implements IChessRule {

	/*
	 * The current board
	 */
	private Board board;
	
	public MovingOutOfCheckRule(Board board) {
		this.board = board;
	}
	
	@Override
	public boolean evaluateRule(ChessMove move) {
		// TODO check if we are in check. If we aren't return true otherwise
		// make sure the given move takes us out of check
		return true;
	}

}
