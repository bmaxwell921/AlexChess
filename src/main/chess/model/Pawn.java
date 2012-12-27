package main.chess.model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;

public class Pawn extends ChessPiece {

	// TODO remember to change this
	private boolean hasMoved;
	
	public Pawn(ColorEnum color, Point pos) {
		super(color, pos, Constants.PAWN, Constants.PAWNVAL);
		hasMoved = false;
	}

	@Override
	public Set<Point> getMovePositions(Board b) {
		Set<Point> locs = new HashSet<Point>();
		Point myLoc = this.getLocation();
		for (int i = 1; i <= 2; ++i) {
			Point toAdd = new Point(myLoc.x, myLoc.y + i * (this.getColor() == ColorEnum.WHITE ? 1 : -1));
			if (b.isOnBoard(toAdd) && b.getBlock(toAdd).getPiece() == null) {
				locs.add(toAdd);
			}
			if (hasMoved) {
				break;
			}
		}
		return locs;
	}
	
	@Override
	public Set<Point> getAttackPositions(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
