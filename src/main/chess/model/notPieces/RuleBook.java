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
	 * Rules that will always be evaluated
	 */
	private List<IChessRule> staticRules;
	
	/*
	 * Rules that only should be evaluated when a piece is being moved
	 */
	private List<IChessRule> dynamicRules;
		
	public RuleBook() {
		staticRules = new ArrayList<IChessRule>();
		dynamicRules = new ArrayList<IChessRule>();
	}
	
	/**
	 * Method to add a new rule to the static Rules
	 * @param add
	 * 			The rule to be added
	 */
	public void addStaticRule(IChessRule rule) {
		staticRules.add(rule);
	}
	
	/**
	 * Method to add a new rule to the dynamic rules
	 * @param add
	 * 			The rule to be added
	 */
	public void addDynamicRule(IChessRule rule) {
		dynamicRules.add(rule);
	}
	
	/**
	 * A method to check if the given move passes the
	 * evaluations of every static Rule in this book
	 * @param m
	 * 			The given move
	 * @return
	 * 			True if the move passes every rule in the book, false otherwise
	 */
	public boolean evaluateStaticRules(ChessMove m) {
		for (IChessRule rule : staticRules) {
			if (!rule.evaluateRule(m)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * A method to check if the given move passes the
	 * evaluations of every dynamic Rule in this book
	 * @param m
	 * 			The given move
	 * @return
	 * 			True if the move passes every rule in the book, false otherwise
	 */
	public boolean evaluateDynamicRules(ChessMove m) {
		for (IChessRule rule : staticRules) {
			if (!rule.evaluateRule(m)) {
				return false;
			}
		}
		return true;
	}
}
