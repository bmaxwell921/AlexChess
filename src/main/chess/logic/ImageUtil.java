package main.chess.logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.common.Constants.Tile;
import main.chess.model.notPieces.ChessBlock;
import main.chess.model.pieces.Bishop;
import main.chess.model.pieces.ChessPiece;
import main.chess.model.pieces.King;
import main.chess.model.pieces.Knight;
import main.chess.model.pieces.Pawn;
import main.chess.model.pieces.Queen;
import main.chess.model.pieces.Rook;

public class ImageUtil {

	private static Map<ChessPiece, List<String>> iconMap = new HashMap<ChessPiece, List<String>>(); 
	
	private static Map<ChessPiece, BufferedImage> imageMap = new HashMap<ChessPiece, BufferedImage>();
	
	private static BufferedImage blackSq, whiteSq, attackSq, moveSq, holdSq;
	
	static {
		//setUpMap();
		setUpImageMap();
	}
	
	@Deprecated
	private static void setUpMap() {
		// Empty square
		iconMap.put(null, Arrays.asList(new String[] {Constants.WHITESQ, Constants.BLACKSQ}));
		
		// Bishop square
		iconMap.put(new Bishop(null, ColorEnum.WHITE, null), Arrays.asList(new String[] 
				{Constants.WBISHPATH, Constants.BBISHPATH}));
		
		// King 
		iconMap.put(new King(null, null, null), Arrays.asList(new String[] 
				{Constants.WKINGPATH, Constants.BKINGPATH}));
		
		// Knight
		iconMap.put(new Knight(null, null, null), Arrays.asList(new String[] 
				{Constants.WKNIGHTPATH, Constants.BKNIGHTPATH}));
		
		// Pawn
		iconMap.put(new Pawn(null, null, null), Arrays.asList(new String[] 
				{Constants.WPAWNPATH, Constants.BPAWNPATH}));
		
		// Queen
		iconMap.put(new Queen(null, null, null), Arrays.asList(new String[] 
				{Constants.WQUEENPATH, Constants.BQUEENPATH}));
		
		// Rook
		iconMap.put(new Rook(null, null, null), Arrays.asList(new String[] 
				{Constants.WROOKPATH, Constants.BROOKPATH}));	
	}

	private static void setUpImageMap() {
		// TODO Auto-generated method stub
		BufferedImage im = null;
		try {
			
			blackSq = ImageIO.read(new File(Constants.BLACKSQ));
			whiteSq = ImageIO.read(new File(Constants.WHITESQ));
			attackSq = ImageIO.read(new File(Constants.ATTACKSQ));
			moveSq = ImageIO.read(new File(Constants.MOVESQ));
			holdSq = ImageIO.read(new File(Constants.HOLDSQ));
			
			im = ImageIO.read(new File(Constants.WBISHPATH));
			imageMap.put(new Bishop(null, ColorEnum.WHITE, null), im);
			
			im = ImageIO.read(new File(Constants.BBISHPATH));
			imageMap.put(new Bishop(null, ColorEnum.BLACK, null), im);
			
			im = ImageIO.read(new File(Constants.WKINGPATH));
			imageMap.put(new King(null, ColorEnum.WHITE, null), im);
			
			im = ImageIO.read(new File(Constants.BKINGPATH));
			imageMap.put(new King(null, ColorEnum.BLACK, null), im);
			
			im = ImageIO.read(new File(Constants.WKNIGHTPATH));
			imageMap.put(new Knight(null, ColorEnum.WHITE, null), im);
			
			im = ImageIO.read(new File(Constants.BKNIGHTPATH));
			imageMap.put(new Knight(null, ColorEnum.BLACK, null), im);
			
			im = ImageIO.read(new File(Constants.WPAWNPATH));
			imageMap.put(new Pawn(null, ColorEnum.WHITE, null), im);
			
			im = ImageIO.read(new File(Constants.BPAWNPATH));
			imageMap.put(new Pawn(null, ColorEnum.BLACK, null), im);
			
			im = ImageIO.read(new File(Constants.WQUEENPATH));
			imageMap.put(new Queen(null, ColorEnum.WHITE, null), im);
			
			im = ImageIO.read(new File(Constants.BQUEENPATH));
			imageMap.put(new Queen(null, ColorEnum.BLACK, null), im);
			
			im = ImageIO.read(new File(Constants.WROOKPATH));
			imageMap.put(new Rook(null, ColorEnum.WHITE, null), im);
			
			im = ImageIO.read(new File(Constants.BROOKPATH));
			imageMap.put(new Rook(null, ColorEnum.BLACK, null), im);	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * A method that takes a Game piece and gets the file path to its image
	 * @param piece
	 * 				the piece to get from
	 * @return
	 * 			the file path to the image to be used for this piece
	 */
	@Deprecated
	public static String getIconPathFromClass(ChessBlock square) {
		List<String> paths = iconMap.get(square.getPiece());
		String iconPath;
		
		/*
		 * If this is an empty square then we just need to get the color of the block
		 * to determine which filepath we need. If it's a piece we need to get the color 
		 * of the piece not the block 
		 */
		
		if (square.getPiece() == null) {
			iconPath = paths.get((square.getBlockColor().equals(Color.WHITE)) ? 0 : 1);
		}
		else {
			iconPath = paths.get((square.getPiece().getColor() == ColorEnum.WHITE) ? 0 : 1);
		}
		
		if (iconPath == null) {
			System.out.println("Bad things happened when getting the icon");
			iconPath = "";
		}
		return iconPath;
	}
	
	@Deprecated
	public static Icon getIconFromClass(ChessBlock square, int imageWidth, int imageHeight) {
		String path = getIconPathFromClass(square);
		
		BufferedImage orig = null;
		try {
			orig = ImageIO.read(new File(path));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImage = resizeImage(orig, imageWidth, imageHeight);
		ImageIcon icon = new ImageIcon(resizedImage);

		//Error checks?
		return icon;
	}
	
	public static Icon getIconFromBlock(ChessBlock square, int imageWidth, int imageHeight) {
		ChessPiece piece = square.getPiece();
		BufferedImage img = null;
		if (piece == null) {
			img = (square.getBlockColor() == ColorEnum.WHITE) ? whiteSq : blackSq;
		}
		else {
			img = imageMap.get(piece);
		}
		
		return new ImageIcon(resizeImage(img, imageWidth, imageHeight));
	}
	
	/**
	 * A method to blend the color of the background square with the color of the piece on that square
	 * @param block 
	 * 				the current block 
	 * @param imageWidth
	 * 					the width of the image to be returned
	 * @param imageHeight
	 * 					the height of the image to be returned
	 * @return
	 * 			an image that shows the piece on top of the block it resides on
	 */
	public static Icon getBlendedIcon(ChessBlock block, Tile backgroundType, int imageWidth, int imageHeight) {
		if (block.getPiece() == null) {
			return getTileIcon(backgroundType, imageWidth, imageHeight);
		}
		BufferedImage background = getTileImage(backgroundType);
		BufferedImage overlay = imageMap.get(block.getPiece());
		
		BufferedImage comb = new BufferedImage(overlay.getWidth(), overlay.getHeight(), 
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g = comb.createGraphics();
		g.drawImage(background, 0, 0, null);
		g.drawImage(overlay, 0, 0, null);
		g.dispose();
		
		return new ImageIcon(resizeImage(comb, imageWidth, imageHeight));
	}

	private static Image resizeImage(Image originalImage, int imageWidth,
			int imageHeight) {
		
		BufferedImage im =  new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = im.createGraphics();
		g.setColor(Color.WHITE);  
		g.fillRect(0, 0, im.getWidth(), im.getHeight()); 
    	g.drawImage(originalImage, 0, 0, imageWidth, imageHeight, null); 
    	g.dispose();
    	return im;
	}

	public static Icon getTileIcon(Tile type, int imageWidth, int imageHeight) {
		BufferedImage img = getTileImage(type);
		
		return new ImageIcon(resizeImage(img, imageWidth, imageHeight));
	}
	
	private static BufferedImage getTileImage(Tile type) {
		BufferedImage img = null;
		switch (type) {
		case ATTACK:
			img = attackSq;
			break;
		case BLACK:
			img = blackSq;
			break;
		case WHITE:
			img = whiteSq;
			break;
		case MOVE:
			img = moveSq;
			break;
		case HOLD:
			img = holdSq;
			break;
		}
		return img;
	}
}
