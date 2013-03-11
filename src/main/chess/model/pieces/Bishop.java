package main.chess.model.pieces;

import java.awt.Point;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;

public class Bishop extends ChessPiece {

	public Bishop(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.BISHOP, Constants.BISHOPVAL);
	}

	@Override
	public Set<Point> getMovePositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Point> getAttackPositions() {
		// TODO Auto-generated method stub
		return null;
	}
}
