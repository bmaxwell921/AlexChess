package main.chess.model.pieces;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class Knight extends ChessPiece {

	public Knight(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.KNIGHT, Constants.KNIGHTVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		//Spots to try...always 8 spots.
		for(int i = 1; i < 3; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() - (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() + (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() - (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
		}
		return locs;
	}

	@Override
	public LocationCollection getAttackPositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		/*
		toAdd.setLocation(myLoc.getX() + 1, myLoc.getY() + 2);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() + 1, myLoc.getY() - 2);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() - 1, myLoc.getY() + 2);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() - 1, myLoc.getY() - 2);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() + 2, myLoc.getY() + 1);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() + 2, myLoc.getY() - 1);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() - 2, myLoc.getY() + 1);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		toAdd.setLocation(myLoc.getX() - 2, myLoc.getY() - 1);
		if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
			locs.add(new Point(toAdd));
		*/
		for(int i = 1; i < 3; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() - (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() + (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() - (i % 2 + 1));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null && isOpponent(board.getBlock(toAdd).getPiece()))
				locs.add(new Point(toAdd));
		}
		return locs;
	}

}
