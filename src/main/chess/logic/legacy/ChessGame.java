package main.chess.logic.legacy;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants.ColorEnum;
import main.chess.common.Constants.GameState;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.ChessBlock;
import main.chess.model.pieces.ChessPiece;
import main.chess.player.ChessPlayer;

public class ChessGame {
	//TODO need to protect against black making moves for white so we need an idea of
	//what player the client is. Me field in here?

	//TODO this class may need to be reworked too

	/**
	 * The board for this game
	 */
	private Board board;

	/**
	 * Players for this game
	 */
	private ChessPlayer white;
	private ChessPlayer black;

	/**
	 * The current player who is making a move
	 */
	private ChessPlayer cur;

	/**
	 * The current state of the game
	 */
	private GameState curState;

	/**
	 * The piece that is currently selected, or null
	 */
	private ChessPiece selectedPiece;

	/**
	 * A constructor to set up a normally starting game of chess. I promise
	 * these local variables aren't racist
	 * 
	 * @param whiteName
	 * 					the name of the player controlling the white pieces
	 * @param blackName
	 * 					the name of the player controlling the black pieces 
	 */
	public ChessGame(String whiteName, String blackName) {
		//Sets up a new game of chess
		board = new Board();

		white = new ChessPlayer(whiteName, ColorEnum.WHITE);

		black = new ChessPlayer(blackName, ColorEnum.BLACK);

		//White always starts in chess
		cur = white;

		curState = GameState.START;
	}

	/**
	 * Takes in the string representation of this game. This will be sent from
	 * the server. Format tba
	 * @param source
	 * 					the source string
	 */
	public ChessGame(String source) {
		//TODO
	}

	public ChessBlock getAt(Point loc) {
		return board.getBlock(loc);
	}

	/**
	 * Main execution method for the game. This will execute one step of 
	 * the game.
	 * 
	 * ---------------------NOTE: Maybe be useless------------------------
	 */
	@Deprecated
	public void step() {

	}

	/**
	 * Method to transition to a new internal state
	 * ---------------------NOTE: Maybe be useless------------------------
	 * @param state
	 * 				the state to transition to
	 */
	@Deprecated
	public void transitionToState(GameState state) {
		curState = state;
	}


	@Override
	public String toString() {
		//TODO this will be used for saving the game
		return null;
	}

	public int getWidth() {
		return board.getWidth();
	}

	public int getHeight() {
		return board.getHeight();
	}

	public ChessPiece getSelectedPiece() {
		return selectedPiece;
	}

	public void moveSelectedPieceToLocation(Point p) {
		if (selectedPiece == null || !this.canMoveTo(p)) return;
		board.movePiece(selectedPiece.getLocation(), p);	
	}

	/**
	 * A method to set the selected piece as the piece at point i, j. If this is the same
	 * piece that was already selected then it de-selects it
	 * @param i
	 * 			the first index of the piece
	 * @param j
	 * 			the second index of the piece
	 */
	public void setSelectedPiece(Point p) {
		// TODO only allow selection of current player's pieces
		if (this.canSelect(p)) {
			selectedPiece = board.getBlock(p).getPiece();
		} else {
			selectedPiece = null;
		}
	}

	/**
	 * Method to check whether the current player can select the square at point p
	 * @param p
	 * 			the point to check
	 * @return
	 * 			whether the player can select that piece or not
	 */
	public boolean canSelect(Point p) {
		ChessPiece newPiece = board.getBlock(p).getPiece();
		return (newPiece != null && !newPiece.isSameSelectedPiece(selectedPiece)
				&& newPiece.getColor() == cur.getColor());
	}

	/**
	 * A Method to get the location of the currently selected piece
	 * @return
	 * 			The point where the selected piece is, or null if there is no selected piece
	 */
	public Point getSelectedPieceLocation() {
		if (selectedPiece != null) {
			return selectedPiece.getLocation();
		} else {
			return null;
		}
	}

	/**
	 * A method to return all the points that have pieces at them and that the selected piece can attack
	 * @return
	 * 			the set
	 */
	public Set<Point> getSelectedPieceAttackPieces() {
		return null;
//		Set<Point> pieces = new HashSet<Point>();
//		if (selectedPiece != null) {
//			pieces = selectedPiece.getAttackPositions();
//		}
//		return pieces;
	}

	/**
	 * A method to return all the locations that the selected piece can move to, excluding locations
	 * that already have pieces there.
	 * @return
	 * 			the set
	 */
	public Set<Point> getSelectedPieceMoveLocations() {
		return null;
//		Set<Point> locs = new HashSet<Point>();
//		if (selectedPiece != null) {
//			locs = selectedPiece.getMovePositions();
//		}
//		return locs;
	}

	/**
	 * Resets the selected piece to nothing
	 */
	public void resetSelectedPiece() {
		selectedPiece = null;		
	}

	/**
	 * Method to check whether the selected piece can move to a certain location
	 * @param newP
	 * 				the point to move to
	 * @return
	 * 			whether or not the piece can move there
	 */
	public boolean canMoveTo(Point newP) {
		//TODO may want to keep the set on hand so we don't recalculate it a lot
		if (selectedPiece == null) return false;
		return board.canMovePiece(selectedPiece.getLocation(), newP);
	}

	/**
	 * Method to move the selected piece from one position to another
	 * @param p
	 * 			the point to move to
	 */
	public void moveSelectedTo(Point p) {
		// Moves the selected piece to the chosen location
		board.movePiece(selectedPiece.getLocation(), p);
	}

	/**
	 * Method to check whether the selected piece can capture a piece at the given location
	 * @param p
	 * 			the postion to capture at
	 * @return
	 * 			whether or not the selected piece can capture at the given location
	 */
	public boolean canCaptureAt(Point p) {
		if (selectedPiece == null) return false;
		return board.willCapture(selectedPiece.getLocation(), p); 
	}

	/**
	 * Method to capture a piece at the given location
	 * @param p
	 * 			the location to capture at
	 * @return
	 * 			the block that contains the captured piece
	 */
	public ChessBlock capturePieceAt(Point p) {
		if (selectedPiece == null || !canCaptureAt(p)) return null;
		return board.capture(selectedPiece.getLocation(), p);		
	}

	/**
	 * Method to get the player that just had its piece captured
	 * @return
	 * 			the player who just lost a piece
	 */
	public ChessPlayer getCapturedPlayer() {
		return (cur.getColor() == ColorEnum.WHITE) ? white : black;
	}
	
	/**
	 * A method to change the current player to the other player
	 */
	public void changePlayer() {
		cur = (cur == white) ? black : white;
	}

}