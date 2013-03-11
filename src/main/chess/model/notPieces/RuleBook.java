package main.chess.model.notPieces;

import java.util.ArrayList;
import java.util.List;

import main.chess.logic.ChessGame;

/**
 * A class to hold onto a bunch of rules
 * @author Brandon
 *
 */
public class RuleBook {

	/*
	 * The rules currently found in this rule book
	 */
	private List<IChessRule> rules;
		
	public RuleBook(ChessGame game, ChessGameState state) {
		rules = new ArrayList<IChessRule>();
	}
	
	/**
	 * Method to add a new rule to this Rulebook
	 * @param add
	 * 			The rule to be added
	 */
	public void addRule(IChessRule rule) {
		rules.add(rule);
	}
	
	/**
	 * A method to check if the given move passes the
	 * evaluations of every Rule in this book
	 * @param m
	 * 			The given move
	 * @return
	 * 			True if the move passes every rule in the book, false otherwise
	 */
	public boolean evaluateRules(ChessMove m) {
		for (IChessRule rule : rules) {
			if (!rule.evaluateRule(m)) {
				return false;
			}
		}
		return true;
	}
}
