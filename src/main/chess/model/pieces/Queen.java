package main.chess.model.pieces;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class Queen extends ChessPiece {

	public Queen(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.QUEEN, Constants.QUEENVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationCollection getAttackPositions() {
		// TODO Auto-generated method stub
		return null;
	}

}
