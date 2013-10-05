package main.chess.model.pieces;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.notPieces.Board;
import main.chess.model.notPieces.LocationCollection;

public class Bishop extends ChessPiece {

	public Bishop(Board b, ColorEnum color, Point pos) {
		super(b, color, pos, Constants.BISHOP, Constants.BISHOPVAL);
	}

	@Override
	public LocationCollection getMovePositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		for(int i = 1; myLoc.getX() - i >= 0 && myLoc.getY() - i >= 0; i++){
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() - i);
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;
		}
		for(int i = 1; myLoc.getX() + i < 8 && myLoc.getY() + i < 8; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + i);
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;
		}
		for(int i = 1; myLoc.getX() - i >= 0 && myLoc.getY() + i < 8; i++){
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() + i);
			if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;
		}
		for(int i = 1; myLoc.getX() + i < 8 && myLoc.getY() - i >= 0; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() - i);
			if(!toAdd.equals(myLoc) && board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() == null)
				locs.add(new Point(toAdd));
			if(board.isOnBoard(toAdd) && board.getBlock(toAdd).getPiece() != null)
	        	break;
		}
		return locs;
	}

	@Override
	public LocationCollection getAttackPositions() {
		LocationCollection locs = new LocationCollection();
		Point myLoc = this.getLocation();
		Point toAdd = new Point(myLoc);
		for(int i = 1; i < 8; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() + i);
			if(board.isOnBoard(toAdd)){
				if(isOpponent(board.getBlock(toAdd).getPiece())){
					locs.add(new Point(toAdd));
					break;
				}
				if(board.getBlock(toAdd).getPiece() != null)
					break;
			}
		}
		for(int i = 1; i < 8; i++){
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() - i);
			if(board.isOnBoard(toAdd)){
				if(isOpponent(board.getBlock(toAdd).getPiece())){
					locs.add(new Point(toAdd));
					break;
				}
				if(board.getBlock(toAdd).getPiece() != null)
					break;
			}
		}
		for(int i = 1; i < 8; i++){
			toAdd.setLocation(myLoc.getX() - i, myLoc.getY() + i);
			if(board.isOnBoard(toAdd)){
				if(isOpponent(board.getBlock(toAdd).getPiece())){
					locs.add(new Point(toAdd));
					break;
				}
				if(board.getBlock(toAdd).getPiece() != null)
					break;
			}
		}
		for(int i = 1; i < 8; i++){
			toAdd.setLocation(myLoc.getX() + i, myLoc.getY() - i);
			if(board.isOnBoard(toAdd)){
				if(isOpponent(board.getBlock(toAdd).getPiece())){
					locs.add(new Point(toAdd));
					break;
				}
				if(board.getBlock(toAdd).getPiece() != null)
					break;
			}
		}
		return locs;
	}
}
