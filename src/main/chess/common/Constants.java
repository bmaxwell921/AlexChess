package main.chess.common;

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
	public static final String WHITESQ = "Images/LightSquare.png";
	public static final String BLACKSQ = "Images/DarkSquare.png";
	public static final String ATTACKSQ = "Images/AttackSquare.png";
	public static final String MOVESQ = "Images/MoveSquare.png";
	public static final String HOLDSQ = "Images/HoldSquare.png";
	
	public static final String WBISHPATH = "Images/WhiteBishop.png";
	public static final String BBISHPATH = "Images/BlackBishop.png";
	
	public static final String WKINGPATH = "Images/WhiteKing.png";
	public static final String BKINGPATH = "Images/BlackKing.png";
	
	public static final String WKNIGHTPATH = "Images/WhiteKnight.png";
	public static final String BKNIGHTPATH = "Images/BlackKnight.png";
	
	public static final String WPAWNPATH = "Images/WhitePawn.png";
	public static final String BPAWNPATH = "Images/BlackPawn.png";
	
	public static final String WQUEENPATH = "Images/WhiteQueen.png";
	public static final String BQUEENPATH = "Images/BlackQueen.png";
	
	public static final String WROOKPATH = "Images/WhiteRook.png";
	public static final String BROOKPATH = "Images/BlackRook.png";
	
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
