package main.chess.common;

import java.io.File;

public class Constants {
	
	//Board sizes
	public static final int BOARDHEIGHT = 8;
	public static final int BOARDWIDTH = 8;
	
	//Rule info
	public static final int MAXTURNS = 50;
	
	//Game state info
	public enum GameStateEnum {
		WHITE_NORMAL, BLACK_NORMAL, WHITE_CHECKED, BLACK_CHECKED, WHITE_CHECKMATED, BLACK_CHECKMATED
	}
	
	//Ui stuff
	public static final int squareSize = 125;
	
	//Card names
	public static final String STARTSCREEN = "Screen to start the game";
	
	public static final String PLAYSCREEN = "Screen for playing the game";
	
	//Enums
	public enum Tile {WHITE, BLACK, ATTACK, MOVE, HOLD};
	public enum GameState {START, RUN_WAIT, RUN_HOLD_PIECE, END};
	public enum ColorEnum {BLACK, WHITE};
	
	
	//Filepaths to images
	public static final String WHITESQ = "images" + File.separator + "blocks" + File.separator + "LightSquare.png";
	public static final String BLACKSQ = "images" + File.separator + "blocks" + File.separator + "DarkSquare.png";
	public static final String ATTACKSQ = "images" + File.separator + "blocks" + File.separator + "AttackSquare.png";
	public static final String MOVESQ = "images" + File.separator + "blocks" + File.separator +"MoveSquare.png";
	public static final String HOLDSQ = "images" + File.separator + "blocks" + File.separator +"HoldSquare.png";
	
	public static final String WBISHPATH = "images" + File.separator + "pieces" + File.separator + "WhiteBishop.png";
	public static final String BBISHPATH = "images" + File.separator + "pieces" + File.separator + "BlackBishop.png";
	
	public static final String WKINGPATH = "images" + File.separator + "pieces" + File.separator + "WhiteKing.png";
	public static final String BKINGPATH = "images" + File.separator + "pieces" + File.separator + "BlackKing.png";
	
	public static final String WKNIGHTPATH = "images" + File.separator + "pieces" + File.separator + "WhiteKnight.png";
	public static final String BKNIGHTPATH = "images" + File.separator + "pieces" + File.separator + "BlackKnight.png";
	
	public static final String WPAWNPATH = "images" + File.separator + "pieces" + File.separator + "WhitePawn.png";
	public static final String BPAWNPATH = "images" + File.separator + "pieces" + File.separator + "BlackPawn.png";
	
	public static final String WQUEENPATH = "images" + File.separator + "pieces" + File.separator + "WhiteQueen.png";
	public static final String BQUEENPATH = "images" + File.separator + "pieces" + File.separator + "BlackQueen.png";
	
	public static final String WROOKPATH = "images" + File.separator + "pieces" + File.separator + "WhiteRook.png";
	public static final String BROOKPATH = "images" + File.separator + "pieces" + File.separator + "BlackRook.png";
	
	//Ids for chess pieces
	//Prepends
	public static final String WPRE = "W";
	public static final String BPRE = "B";
	
	public static final String BISHOP = "_BISHOP";
	
	public static final String KING = "_KING";
	
	public static final String KNIGHT ="_KNIGHT";
	
	public static final String PAWN = "_PAWN";
	
	public static final String QUEEN = "_QUEEN";
	
	public static final String ROOK = "_ROOK";
	
	//Default piece value
	public static final int BISHOPVAL = 3;
	public static final int KINGVAL = 10;
	public static final int KNIGHTVAL = 3;
	public static final int PAWNVAL = 1;
	public static final int QUEENVAL = 9;
	public static final int ROOKVAL = 5;
	
}
