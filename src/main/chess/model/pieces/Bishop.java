package main.chess.model.pieces;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class Bishop extends ChessPiece {

	public Bishop(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.BISHOP, Constants.BISHOPVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		for(int i = -7; i < 8; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + i);
			if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() + i);
			if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
		}
		return locs;
	}

	@Override
	public LocationCollection getAttackPositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		for(int i = -7; i < 8; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + i);
			if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && isOpponent(board.getBlock(toAdd).getPiece())){
				locs.add(new Point(toAdd));
				break;
			}
		}
		for(int i = -7; i < 8; i++){
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() + i);
			if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && isOpponent(board.getBlock(toAdd).getPiece())){
				locs.add(new Point(toAdd));
				break;
			}
		}
		return locs;
	}
}
