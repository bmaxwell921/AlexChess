package main.chess.model.notPieces;


/**
 * Interface to represent a Rule
 * @author Brandon
 *
 */
public interface IChessRule {

	/**
	 * A method to evaluate whether a given move evaluates 
	 * to true or not, depending on what Rule this object is testing.
	 * @param move
	 * 				The move that is currently being assessed.
	 * @return
	 * 			True if the chess move is valid, false otherwise
	 */
	public boolean evaluateRule(ChessMove move);
}
