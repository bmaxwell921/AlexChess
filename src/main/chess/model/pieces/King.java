package main.chess.model.pieces;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class King extends ChessPiece {

	public King(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.KING, Constants.KINGVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		for(int i = -1; i < 2; i++)
			for(int j = -1; j < 2; j++){
				toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + j);
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
		for(int i = -1; i < 2; i++)
			for(int j = -1; j < 2; j++){
				toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + j);
				if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && isOpponent(board.getBlock(toAdd).getPiece()))
					locs.add(new Point(toAdd));
			}
		return locs;
	}
}
