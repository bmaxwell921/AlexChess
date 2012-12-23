package main.chess.model;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.model.ChessPiece.ColorEnum;

public class Rook extends ChessPiece {

	public Rook(ColorEnum color, Point pos) {
		super(color, pos, Constants.ROOK, Constants.ROOKVAL);
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
