package main.chess.logic;

import java.awt.Point;

import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.ChessGameState;
import main.chess.model.notPieces.RuleBook;

/**
 * Class to handle the logic of playing a game of chess
 * @author Brandon
 *
 */
public class ChessGame {

	/*
	 * A Rulebook for all the rules of chess
	 */
	private RuleBook rules;
	
	/*
	 * An object to represent the state of the current game of chess
	 */
	private ChessGameState state;
	
	/*
	 * The board for this game
	 */
	private Board board;
	
	
	/**
	 * A constructor to set up a completely new game of chess.
	 */
	public ChessGame() {
		this.setUpGame();
		this.setUpRules();
	}
	
	private void setUpGame() {
		//TODO initialize the game state
		
		board = new Board();
	}
	
	private void setUpRules() {
		/*
		 * TODO initialize the Rulebook.
		 * Need a rule to check if it's my turn
		 * If the max number of rules has been reached
		 * if it's checkmate
		 * Need a rule for checking valid movements
		 */
	}
	
	/**
	 * Method called by the UI to tell us which tile the 
	 * user picked
	 * @param in
	 * 			the location of the tile the user selected
	 */
	public void evaluateInput(Point in) {
		
	}
}
