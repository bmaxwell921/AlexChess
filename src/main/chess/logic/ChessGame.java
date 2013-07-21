package main.chess.logic;

import java.awt.Point;

import main.chess.common.Constants.ColorEnum;
import main.chess.common.Constants.Tile;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.ChessBlock;
import main.chess.model.notPieces.ChessGameState;
import main.chess.model.notPieces.ChessMove;
import main.chess.model.notPieces.LocationCollection;
import main.chess.model.notPieces.MovingOutOfCheckRule;
import main.chess.model.notPieces.MyPieceRule;
import main.chess.model.notPieces.MyTurnRule;
import main.chess.model.notPieces.RuleBook;
import main.chess.model.notPieces.UIChange;
import main.chess.model.notPieces.UIChangeList;
import main.chess.model.notPieces.ValidLocationRule;
import main.chess.model.pieces.ChessPiece;
import main.chess.player.ChessPlayer;

/**
 * Class to handle the logic of playing a game of chess
 * @author Brandon
 *
 */
public class ChessGame {
	
	private boolean DEBUGGING = true;
	
	/*
	 * TODO how to handle castling and pawn promotion??
	 */

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
	
	/*
	 * A player to tell who the player on this computer is
	 */
	private ChessPlayer me;
	
	
	/**
	 * A constructor to set up a completely new game of chess.
	 */
	public ChessGame() {
		this.setUpGame();
		this.setUpRules();
	}
	
	private void setUpGame() {
		me = new ChessPlayer("arsd", ColorEnum.WHITE);
		state = new ChessGameState();
		board = new Board();
	}
	
	private void setUpRules() {
		rules = new RuleBook();
		rules.addStaticRule(new MyTurnRule(state));
		rules.addStaticRule(new MyPieceRule(me));
		rules.addDynamicRule(new ValidLocationRule(state));
		rules.addDynamicRule(new MovingOutOfCheckRule(board));
	}
	
	/**
	 * Method called by the UI to tell us which tile the 
	 * user picked
	 * @param in
	 * 			the location of the tile the user selected
	 */
	public UIChangeList evaluateInput(Point in) {
		//Be careful because in comes from the UI so it is
		// y, x
		ChessMove curMove = new ChessMove(board.getBlock(in).getPiece(), in);
		UIChangeList ret = new UIChangeList();
		/*
		 * If they fail to pass a static rule, it's because it's either not their turn
		 * or they clicked on something that isn't their piece, so don't change state and 
		 * just return. 
		 */
		if (!rules.evaluateStaticRules(curMove)) {
			if (DEBUGGING) {
				System.out.println("Failed a static rule check");
			}
			return ret;
		}
		/*
		 * Otherwise, if we don't have a selected piece they are just selecting a
		 * piece for the first time, so update the state to reflect that selection
		 */
		else if (!state.hasSelectedPiece()) {
			if (DEBUGGING) {
				System.out.println("Selecting: " + curMove.piece.toString());
			}
			//Add the changes for attack and move locations
			state.setSelectedPiece(curMove.piece);
			this.addSelectChanges(ret, curMove);
			return ret;
		}
		/*
		 * Otherwise, they are moving their piece somewhere, so we need to evaluate
		 * the dynamic rules. If they don't pass the dynamic rules then they clicked on
		 * a tile they can't move to, so we need to de-select the selected piece, but 
		 * keep it as their turn
		 */
		else if (!rules.evaluateDynamicRules(curMove)) {
			if (DEBUGGING) {
				System.out.println("Deselecting: " + state.getSelectedPiece());
			}
			//Need to get the UI changes before we deselect
			this.addDeselectChanges(ret, curMove);
			state.deselectPiece();
			return ret;
		} 
		/*
		 * If we get to this point then the user has made a move that is
		 * valid so we need to update the board and the state to reflect
		 * that movement.
		 */
		else {
			//TODO checking pawn promotion and castling will occur down here probs
			this.addDeselectChanges(ret, curMove);
			ChessPiece capped = board.moveAndOrCapture(state.getSelectedPiece().getLocation(), curMove.location);
			if (capped != null) {
				state.addLostPiece(capped);
			}
			this.updateState();
			this.addCaptureChanges(ret, capped);
			return ret;
		}
	}
	
	private void addSelectChanges(UIChangeList list, ChessMove move) {
		list.addChange(new UIChange(state.getSelectedPiece().getLocation(), null, Tile.HOLD, null));
		
		for (Point location : state.getSelectedPiece().getAttackPositions()) {
			list.addChange(new UIChange(location, null, Tile.ATTACK, null));
		}
		
		for (Point location : state.getSelectedPiece().getMovePositions()) {
			list.addChange(new UIChange(location, null, Tile.MOVE, null));
		}
	}
	
	private void addDeselectChanges(UIChangeList list, ChessMove move) {
		Tile changeColor = this.getBlock(state.getSelectedPiece().getLocation()).getBlockColor() 
				== ColorEnum.BLACK 
				? Tile.BLACK : Tile.WHITE;
		list.addChange(new UIChange(state.getSelectedPiece().getLocation(), null, changeColor, null));
		
		//Remove attack and move locations
		for (Point location : state.getSelectedPiece().getAttackPositions()) {
			Tile change = this.getBlock(location).getBlockColor() == ColorEnum.BLACK 
					? Tile.BLACK : Tile.WHITE;
			list.addChange(new UIChange(location, null, change, null));
		}
		
		for (Point location : state.getSelectedPiece().getMovePositions()) {
			Tile change = this.getBlock(location).getBlockColor() == ColorEnum.BLACK 
					? Tile.BLACK : Tile.WHITE;
			list.addChange(new UIChange(location, null, change, null));
		}
	}
	
	private void addCaptureChanges(UIChangeList list, ChessPiece captured) {
		//TODO
	}

	/*
	 * A method to update the state of the game. This will need to
	 * check if we have reached checkmate or not
	 */
	private void updateState() {
		/*
		 * TODO 
		 * First solution: Brute force.
		 * 	Just check if any opposing piece's attackLocations are where the king is at
		 * 
		 * Second solution: Optimized brute force
		 * 	We can probably eliminate lots of pawn checks based on how far they are from the king
		 * 
		 * Third solution: ???
		 */
		
	}
	
	/**
	 * A Method to return the point where the selected piece is located
	 * @return
	 * 			The point where the currently selected piece is located, or null
	 */
	public Point getSelectedPieceLoc() {
		return (state.hasSelectedPiece()) ? state.getSelectedPiece().getLocation() : null;
	}
	
	/**
	 * A method to return all the positions the selected piece can move to
	 * @return
	 * 		All the points where the selected piece can move, or null
	 */
	public LocationCollection getSelectedPieceMoveLocs() {
		return (state.hasSelectedPiece()) ? state.getSelectedPiece().getMovePositions() : null;
	}
	
	/**
	 * A method to return all the positions that the selected piece can attack,
	 * that also have opposing pieces in them
	 * @return
	 * 			all the positions the selected piece can attack, or null
	 */
	public LocationCollection getSelectedPieceAttackLocs() {
		return (state.hasSelectedPiece()) ? state.getSelectedPiece().getAttackPositions() : null;
	}
	
	public ChessBlock getBlock(Point loc) {
		return board.getBlock(loc);
	}
}
