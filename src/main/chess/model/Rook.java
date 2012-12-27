package main.chess.model;

import java.awt.Point;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;

public class Rook extends ChessPiece {

	public Rook(ColorEnum color, Point pos) {
		super(color, pos, Constants.ROOK, Constants.ROOKVAL);
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
