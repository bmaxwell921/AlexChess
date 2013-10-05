package main.chess.model.pieces;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class Rook extends ChessPiece {

	public Rook(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.ROOK, Constants.ROOKVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		// TODO Auto-generated method stub		
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		//check spaces to the right
		for(int i = 1; toAdd.getX() + i <= 8; i++){
	        toAdd.setLocation(myLoc.getX() + i,myLoc.getY());
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
	        	locs.add(toAdd);
	        if(board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		//check spaces to the left
		for(int i = 1; toAdd.getX() + i >= 0; i++){
	        toAdd.setLocation(myLoc.getX() - i,myLoc.getY());
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
	        	locs.add(toAdd);
	        if(board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		//check spaces forward (remember Enum) ??? ohhhhh as in backward and forward are the same 0.0
		for(int i = 1; toAdd.getY() + i <= 8; i++){
		    toAdd.setLocation(myLoc.getX(), myLoc.getY() + i);
		    if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
		    	locs.add(toAdd);
		    if(board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		//check spaces backward
		for(int i = 1; toAdd.getY() - i >= 0; i++){
			toAdd.setLocation(myLoc.getX(), myLoc.getY() + i);
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(toAdd);
			if(board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		return locs;
	}

	@Override
	public LocationCollection getAttackPositions() {
		// TODO Auto-generated method stub
		return null;//this will need Enum to make sure you only take pieces from opposite team.
	}

}
