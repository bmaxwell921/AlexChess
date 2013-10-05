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
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		//check spaces to the right
		for(int i = 1; myLoc.getX() + i < 8; i++){
	        toAdd.setLocation(myLoc.getX() + i,myLoc.getY());
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
	        	locs.add(new Point(toAdd));
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		//check spaces to the left
		for(int i = 1; myLoc.getX() - i >= 0; i++){
	        toAdd.setLocation(myLoc.getX() - i,myLoc.getY());
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
	        	locs.add(new Point(toAdd));
	        if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		//check spaces forward (remember Enum) ??? 
		for(int i = 1; myLoc.getY() + i < 8; i++){
		    toAdd.setLocation(myLoc.getX(), myLoc.getY() + i);
		    if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
		    	locs.add(new Point(toAdd));
		    if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		//check spaces backward
		for(int i = 1; myLoc.getY() - i >= 0; i++){
			toAdd.setLocation(myLoc.getX(), myLoc.getY() - i);
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;//if there is a piece there, rooks can't jump pieces.
		}
		return locs;
	}

	@Override
	public LocationCollection getAttackPositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		//check right for opponents
		for(int i = 1; myLoc.getX() + i < 8; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY());
			//add if the spot is real and it has an opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null 
					&& this.isOpponent(board.getBlock(toAdd).getPiece())){
				locs.add(new Point(toAdd));
				break;//can only attack one opponent!
			}
			//stop searching if the spot is real and it has a non-opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null
					&& !this.isOpponent(board.getBlock(toAdd).getPiece()))
				break;
		}
		//check left
		for(int i = 1; myLoc.getX() - i >= 0; i++){
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY());
			//add if the spot is real and it has an opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null 
					&& this.isOpponent(board.getBlock(toAdd).getPiece())){
				locs.add(new Point(toAdd));
				break;//can only attack one opponent!
			}
			//stop searching if the spot is real and it has a non-opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null
					&& !this.isOpponent(board.getBlock(toAdd).getPiece()))
				break;
		}
		//check forward
		for(int i = 1; myLoc.getY() + i < 8; i++){
			toAdd.setLocation(myLoc.getX(), myLoc.getY() + i);
			//add if the spot is real and it has an opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null 
					&& this.isOpponent(board.getBlock(toAdd).getPiece())){
				locs.add(new Point(toAdd));
			break;//can only attack one opponent!
		}
			//stop searching if the spot is real and it has a non-opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null
					&& !this.isOpponent(board.getBlock(toAdd).getPiece()))
				break;
		}
		//check backward
		for(int i = 1; myLoc.getY() - i >= 0; i++){
			toAdd.setLocation(myLoc.getX(), myLoc.getY() - i);
			//add if the spot is real and it has an opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null 
					&& this.isOpponent(board.getBlock(toAdd).getPiece())){
				locs.add(new Point(toAdd));
				break;//can only attack one opponent!
			}
			//stop searching if the spot is real and it has a non-opponent
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null
					&& !this.isOpponent(board.getBlock(toAdd).getPiece()))
				break;
		}
		return locs;//this will need Enum to make sure you only take pieces from opposite team.
	}
}
