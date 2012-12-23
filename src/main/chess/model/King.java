package main.chess.model;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.model.ChessPiece.ColorEnum;

public class King extends ChessPiece {

	public King(ColorEnum color, Point pos) {
		super(color, pos, Constants.KING, Constants.KINGVAL);
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
