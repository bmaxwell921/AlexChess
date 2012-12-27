package main.chess.model;

import java.awt.Point;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;

public class Queen extends ChessPiece {

	public Queen(ColorEnum color, Point pos) {
		super(color, pos, Constants.QUEEN, Constants.QUEENVAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Point> getMovePositions(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Point> getAttackPositions(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
