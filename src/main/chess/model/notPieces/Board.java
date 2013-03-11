package main.chess.model.notPieces;

import java.awt.Point;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.model.pieces.Bishop;
import main.chess.model.pieces.ChessPiece;
import main.chess.model.pieces.King;
import main.chess.model.pieces.Knight;
import main.chess.model.pieces.Pawn;
import main.chess.model.pieces.Queen;
import main.chess.model.pieces.Rook;

public class Board {
	/**
	 * The array representation of the board
	 */
	private ChessBlock[][] board;

	public Board() {
		board = new ChessBlock[Constants.BOARDHEIGHT][Constants.BOARDWIDTH];

		// Sets up the black and white squares
		boolean curWhite = false;
		boolean rowStartWhite = false;
		for (int i = 0; i < Constants.BOARDHEIGHT; ++i) {
			curWhite = rowStartWhite;
			for (int j = 0; j < Constants.BOARDWIDTH; ++j) {
				board[j][i] = new ChessBlock(
						null, 
						new Point(i, j), curWhite ? ColorEnum.WHITE : ColorEnum.BLACK);
				curWhite = !curWhite;
			}
			rowStartWhite = !rowStartWhite;
		}
		//TODO set up the pieces in their default locations


		this.setUpPawns();
		this.setUpRooks();
		this.setUpKnights();
		this.setUpBishops();
		this.setUpQueens();
		this.setUpKings();
	}

	private void setUpPawns() {
		for (int x = 0; x <= 7; x++) {
			board[1][x].setPiece(new Pawn(this, ColorEnum.WHITE, new Point(x, 1)));
			board[6][x].setPiece(new Pawn(this, ColorEnum.BLACK, new Point(x, 6)));
		}
	}

	private void setUpRooks() {
		board[0][0].setPiece(new Rook(this, ColorEnum.WHITE, new Point(0,0)));
		board[0][7].setPiece(new Rook(this, ColorEnum.WHITE, new Point(7,0)));
		board[7][0].setPiece(new Rook(this, ColorEnum.BLACK, new Point(0,7)));
		board[7][7].setPiece(new Rook(this, ColorEnum.BLACK, new Point(7,7)));
	}

	private void setUpKnights() {
		board[0][1].setPiece(new Knight(this, ColorEnum.WHITE, new Point(1,0)));
		board[0][6].setPiece(new Knight(this, ColorEnum.WHITE, new Point(6,0)));
		board[7][1].setPiece(new Knight(this, ColorEnum.BLACK, new Point(1,7)));
		board[7][6].setPiece(new Knight(this, ColorEnum.BLACK, new Point(6,7)));
	}

	private void setUpBishops() {
		board[0][2].setPiece(new Bishop(this, ColorEnum.WHITE, new Point(2,0)));
		board[0][5].setPiece(new Bishop(this, ColorEnum.WHITE, new Point(5,0)));
		board[7][2].setPiece(new Bishop(this, ColorEnum.BLACK, new Point(2,7)));
		board[7][5].setPiece(new Bishop(this, ColorEnum.BLACK, new Point(5,7)));
	}

	private void setUpQueens() {
		board[0][3].setPiece(new Queen(this, ColorEnum.WHITE, new Point(3,0)));
		board[7][4].setPiece(new Queen(this, ColorEnum.BLACK, new Point(4,7)));
	}

	private void setUpKings() {
		board[0][4].setPiece(new King(this, ColorEnum.WHITE, new Point(4,0)));
		board[7][3].setPiece(new King(this, ColorEnum.BLACK, new Point(3,7)));
	}

	/**
	 * A constructor that reads the locally saved game board from the file
	 * system
	 * 
	 * @param source
	 *            the serialized version of this board
	 */
	public Board(String source) {
		// TODO Brandon. Alex, let me handle this one, unless you're done with
		// everything else and want to do some string parsing
	}

	/**
	 * A method to check whether you can move a piece from one location to
	 * another location
	 * 
	 * @param fromLocation
	 *            the poition you are moving from
	 * @param toLocation
	 *            the position you are moving to
	 * @return whether you can move to toLocation from fromLocation
	 */
	public boolean canMovePiece(Point fromLocation, Point toLocation) {
		if (fromLocation.equals(toLocation)) return false;
		ChessPiece occupyingPiece = this.getBlock(toLocation).getPiece();
		// The location you are moving to needs to be empty and the location you
		// are trying to go to
		// must be in the locations you can move to
		return occupyingPiece == null
				&& (this.getBlock(fromLocation).getPiece()
						.getMovePositions().contains(toLocation));
	}

	/**
	 * A method to move a piece from one location on the board to another
	 * 
	 * @param fromLocation
	 *            the location of the piece to be moved
	 * @param toLocation
	 *            the location to where the piece should move
	 */
	public void movePiece(Point fromLocation, Point toLocation) {
		if (!canMovePiece(fromLocation, toLocation))
			return;
//		board[toLocation.y][toLocation.x]
//				.setPiece(board[fromLocation.y][fromLocation.x].getPiece());
//		board[fromLocation.y][fromLocation.x].setPiece(null);
//		board[toLocation.y][toLocation.x].getPiece().move(toLocation);
		this.unsafeMovePiece(fromLocation, toLocation);
	}
	
	private void unsafeMovePiece(Point fromLocation, Point toLocation) {
		board[toLocation.y][toLocation.x]
				.setPiece(board[fromLocation.y][fromLocation.x].getPiece());
		board[fromLocation.y][fromLocation.x].setPiece(null);
		board[toLocation.y][toLocation.x].getPiece().move(toLocation);
	}

	/**
	 * A method that returns whether moving a piece from fromLocation to
	 * toLocation will result in a piece being captured
	 * -----------------------NOTE: This method might be
	 * useless-------------------------------
	 * 
	 * @param fromLocation
	 *            the location being moved from
	 * @param toLocation
	 *            the location being moved to
	 * @return
	 */
	public boolean willCapture(Point fromLocation, Point toLocation) {
		if (fromLocation.equals(toLocation)) return false;
		ChessPiece occupyingPiece = this.getBlock(toLocation).getPiece();
		ChessPiece capturingPiece = this.getBlock(fromLocation).getPiece();
		return occupyingPiece != null && capturingPiece != null 
				&& capturingPiece.getAttackPositions().contains(toLocation)
				&& capturingPiece.isOpponent(occupyingPiece);
	}

	/**
	 * A method to capture the piece at toLocation with the piece at
	 * fromLocation
	 * 
	 * @param fromLocation
	 *            the location the capturing piece is at
	 * @param toLocation
	 *            the location the to be captured piece is at
	 * @return the piece that was captured
	 */
	public ChessBlock capture(Point fromLocation, Point toLocation) {
		if (!willCapture(fromLocation, toLocation)) return null;
		ChessBlock captured = (ChessBlock) this.getBlock(toLocation).clone();
		// TODO We are getting pass by reference issues here because captured.piece becomes null when we still want it
		//maybe need to make a clone method or something
		//this.getBlock(toLocation).setPiece(null);
		this.unsafeMovePiece(fromLocation, toLocation);
		return captured;
	}
	
	/**
	 * A method to move a piece from a given location to a given location. 
	 * If this movement results in capturing another piece, the captured piece
	 * is returned.
	 * 
	 * ------------------------------------------------------------------------
	 * 								The method pretty much makes
	 * 								all the other move/capture
	 * 								methods useless.
	 * ------------------------------------------------------------------------
	 * @param fromLoc
	 * 				The location to move from
	 * @param toLoc
	 * 				The location to move to
	 * @return
	 * 			The piece that was captured, or null
	 */
	public ChessPiece moveAndOrCapture(Point fromLoc, Point toLoc) {
		ChessBlock toBlock = board[toLoc.y][toLoc.x];
		ChessPiece capped = (toBlock.getPiece() == null) ? 
				null : (ChessPiece) toBlock.getPiece().clone();
		this.unsafeMovePiece(fromLoc, toLoc);
		return capped;
	}

	/**
	 * A method to return the configuration of the board
	 * 
	 * @return
	 */
	public ChessBlock[][] getBoard() {
		return board;
	}

	/**
	 * A method to get the chess block at a given point
	 * 
	 * @param loc
	 *            the position to query
	 * @return the block at that position or NULL if that position is off the
	 *         board
	 */
	public ChessBlock getBlock(Point loc) {
		if (!isOnBoard(loc))
			return null;
		return board[loc.y][loc.x];
	}

	/**
	 * Method to check if the given point is on the chess board
	 * 
	 * @param p
	 *            the point to check
	 * @return whether or not the point is on the board
	 */
	public boolean isOnBoard(Point p) {
		return 0 <= p.x && p.x < 8 && 0 <= p.y && p.y < 8;
	}

	public int getWidth() {
		return Constants.BOARDWIDTH;
	}

	public int getHeight() {
		return Constants.BOARDHEIGHT;
	}
}