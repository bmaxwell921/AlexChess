package main.chess.logic;

import java.awt.Point;

import main.chess.model.Board;
import main.chess.model.ChessBlock;
import main.chess.model.ChessPiece.ColorEnum;
import main.chess.player.ChessPlayer;

public class ChessGame {
	//TODO need to protect against black making moves for white so we need an idea of
	//what player the client is. Me field in here?
	
	//TODO this class may need to be reworked too
	
	
	public enum GameState {START, RUN_WAIT, RUN_HOLD_PIECE, END};
	
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
	public void step() {
		
	}
	
	/**
	 * Method to transition to a new internal state
	 * ---------------------NOTE: Maybe be useless------------------------
	 * @param state
	 * 				the state to transition to
	 */
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

}
