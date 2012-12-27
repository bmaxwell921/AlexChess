package main.chess.model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;

public class Pawn extends ChessPiece {

	public Pawn(ColorEnum color, Point pos) {
		super(color, pos, Constants.PAWN, Constants.PAWNVAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Point> getValidMoveLocations(Board b) {
		// TODO Auto-generated method stub
		Set<Point> ret = new HashSet<Point>();
		ret.add(new Point(this.getLocation().y, this.getLocation().x + 1));
		return ret;
	}

	@Override
	public Set<Point> getAttackedPieces(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
