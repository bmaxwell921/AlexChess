package main.chess.model.pieces;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;

public class Rook extends ChessPiece {

	public Rook(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.ROOK, Constants.ROOKVAL);
	}

	@Override
	public Set<Point> getMovePositions() {
		// TODO Auto-generated method stub		
		Set<Point> locs = new HashSet<Point>();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		//check spaces to the right
		for(int i = 1; toAdd.getX() + i <= 8; i++){
	        toAdd.setLocation(myLoc.getX() + i,myLoc.getY());
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
	        	locs.add(toAdd);
		}
		//check spaces to the left
		for(int i = 1; toAdd.getX() + i >= 0; i++){
	        toAdd.setLocation(myLoc.getX() - i,myLoc.getY());
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
	        	locs.add(toAdd);
		}
		//check spaces forward (remember Enum)
		for(int i = 0; toAdd.getY() + i < 8; i++){
		    //TODO	
		}
		//check spaces backward
		
		
		return locs;
	}

	@Override
	public Set<Point> getAttackPositions() {
		// TODO Auto-generated method stub
		return null;
	}

}
