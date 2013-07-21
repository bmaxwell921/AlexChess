package main.chess.model.pieces;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class Pawn extends ChessPiece {

	public Pawn(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.PAWN, Constants.PAWNVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		for (int i = 1; i <= 2; ++i) {
			Point toAdd = new Point(myLoc.x, myLoc.y + i
					* (this.getColor() == ColorEnum.WHITE ? 1 : -1));
			if (board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null) {
				locs.add(toAdd);
			}
			if (hasMoved) {
				break;
			}
		}
		return locs;
	}

	@Override
	public LocationCollection getAttackPositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc.x + 1, myLoc.y + 1
				* (this.getColor() == ColorEnum.WHITE ? 1 : -1));
		if (board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null
				&& this.isOpponent(board.getBlock(toAdd).getPiece())) {
			locs.add(toAdd);
		}
		Point toAdd1 = new Point(myLoc.x - 1, myLoc.y + 1
				* (this.getColor() == ColorEnum.WHITE ? 1 : -1));
		if (board.isOnBoard(toAdd1) && board.getBlock(toAdd1).getPiece() != null
				&& this.isOpponent(board.getBlock(toAdd1).getPiece())) {
			locs.add(toAdd1);
		}
		return locs;
	}

}
