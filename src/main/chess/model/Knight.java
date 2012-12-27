package main.chess.model;

import java.awt.Point;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;

public class Knight extends ChessPiece {

	public Knight(ColorEnum color, Point pos) {
		super(color, pos, Constants.KNIGHT, Constants.KNIGHTVAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Point> getValidMoveLocations(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Point> getAttackedPieces(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
