package main.chess.model;

import java.awt.Point;

import main.chess.common.Constants;

public class Bishop extends ChessPiece {

	public Bishop(ColorEnum color, Point pos) {
		super(color, pos, Constants.BISHOP, Constants.BISHOPVAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Point[] getValidMoveLocations(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChessPiece[] getAttackedPieces(Board b) {
		// TODO Auto-generated method stub
		return null;
	}
}
