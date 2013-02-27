package main.chess.model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;

public class Rook extends ChessPiece {

	public Rook(ColorEnum color, Point pos) {
		super(color, pos, Constants.ROOK, Constants.ROOKVAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Point> getMovePositions(Board b) {
		// TODO Auto-generated method stub		
		Set<Point> locs = new HashSet<Point>();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		//check spaces to the right
		for(int i = 1; toAdd.getX() + i <= 8; i++){
	        toAdd.setLocation(myLoc.getX() + i,myLoc.getY());
	        if(b.isOnBoard(toAdd) && b.getBlock(toAdd).getPiece() == null)
	        	locs.add(toAdd);
		}
		//check spaces to the left
		for(int i = 1; toAdd.getX() + i >= 0; i++){
	        toAdd.setLocation(myLoc.getX() - i,myLoc.getY());
	        if(b.isOnBoard(toAdd) && b.getBlock(toAdd).getPiece() == null)
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
	public Set<Point> getAttackPositions(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
