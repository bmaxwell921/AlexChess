package main.chess.model;

import java.awt.Point;

import main.chess.common.Constants.ColorEnum;

public class Board {

	private final int HEIGHT = 8;
	private final int WIDTH = 8;
	
	/**
	 * The array representation of the board
	 */
	private ChessBlock[][] board;
	
	public Board() {
		board = new ChessBlock[HEIGHT][WIDTH];
		
		//Sets up the black and white squares
		boolean curWhite = false;
		boolean rowStartWhite = false;
		for (int i = 0; i < HEIGHT; ++i) {
			curWhite = rowStartWhite;
			for (int j = 0; j < WIDTH; ++j) {
				board[j][i] = new ChessBlock(
						null, 
						new Point(i, j), curWhite ? ColorEnum.WHITE : ColorEnum.BLACK);
				curWhite = !curWhite;
			}
			rowStartWhite = !rowStartWhite;
		}
		// For testing
		board[0][WIDTH/2] = new ChessBlock(
				new Pawn(ColorEnum.WHITE, new Point(WIDTH/2, 0)), 
				new Point(WIDTH/2, 0), ColorEnum.BLACK);
		//TODO set up the pieces in their default locations
	}
	
	/**
	 * A constructor that reads the locally saved game board from the file system
	 * @param source
	 * 					the serialized version of this board
	 */
	public Board(String source) {
		//TODO Brandon. Alex, let me handle this one, unless you're done with
		//everything else and want to do some string parsing
	}
	
	/**
	 * A method to check whether you can move a piece from one location to another location
	 * @param fromLocation
	 * 						the poition you are moving from
	 * @param toLocation
	 * 						the position you are moving to
	 * @return
	 * 			whether you can move to toLocation from fromLocation
	 */
	public boolean canMovePiece(Point fromLocation, Point toLocation) {
		ChessPiece occupyingPiece = this.getBlock(toLocation).getPiece();
		// The location you are moving to needs to be empty and the location you are trying to go to
		// must be in the locations you can move to
		return occupyingPiece == null && 
				this.getBlock(fromLocation).getPiece().getMovePositions(this).contains(toLocation);
	}
	
	/**
	 * A method to move a piece from one location on the board to another
	 * @param fromLocation
	 * 						the location of the piece to be moved			
	 * @param toLocation
	 * 						the location to where the piece should move
	 */
	public void movePiece(Point fromLocation, Point toLocation) {
		if (!canMovePiece(fromLocation, toLocation)) return;
		board[toLocation.y][toLocation.x].setPiece(board[fromLocation.y][fromLocation.x].getPiece());
		board[fromLocation.y][fromLocation.x].setPiece(null);
		board[toLocation.y][toLocation.x].getPiece().move(toLocation);
	}
	
	/**
	 * A method that returns whether moving a piece from fromLocation to toLocation
	 * will result in a piece being captured
	 * -----------------------NOTE: This method might be useless-------------------------------
	 * @param fromLocation
	 * 						the location being moved from
	 * @param toLocation
	 * 						the location being moved to
	 * @return
	 */
	public boolean willCapture(Point fromLocation, Point toLocation) {
		//TODO
		return false;
	}
	
	/**
	 * A method to capture the piece at toLocation with the piece at fromLocation
	 * @param fromLocation
	 * 						the location the capturing piece is at
	 * @param toLocation
	 * 						the location the to be captured piece is at
	 * @return
	 * 			the piece that was captured
	 */
	public ChessPiece capture(Point fromLocation, Point toLocation) {
		// TODO
		return null;
	}
	
	/**
	 * A method to return the configuration of the board
	 * @return
	 */
	public ChessBlock[][] getBoard() {
		return board;
	}
	
	/**
	 * A method to get the chess block at a given point
	 * @param loc
	 * 				the position to query
	 * @return
	 * 			the block at that position or NULL if that position is off the board
	 */
	public ChessBlock getBlock(Point loc) {
		if (!isOnBoard(loc)) return null;
		return board[loc.y][loc.x];
	}
	
	/**
	 * Method to check if the given point is on the chess board
	 * @param p
	 * 			the point to check
	 * @return
	 * 			whether or not the point is on the board
	 */
	public boolean isOnBoard(Point p) {
		return 0 <= p.x && p.x < 8 
				&& 0 <= p.y && p.y < 8;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
}
