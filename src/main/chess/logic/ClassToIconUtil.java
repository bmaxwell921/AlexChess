package main.chess.logic;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import main.chess.model.ChessPiece;

public class ClassToIconUtil {

	private static Map<ChessPiece, String> iconMap = new HashMap<ChessPiece, String>(); 
	
	static {
		setUpMap();
	}
	
	private static void setUpMap() {
		// TODO Fill in the map. File paths need to use / not \
		
	}

	/**
	 * A method that takes a Game piece and gets the file path to its image
	 * @param piece
	 * 				the piece to get from
	 * @return
	 * 			the file path to the image to be used for this piece
	 */
	public static String getIconPathFromClass(ChessPiece piece) {
		String iconPath = iconMap.get(piece);
		
		if (iconPath == null) {
			System.out.println("Bad things happened when getting the icon");
			iconPath = "";
		}
		return iconPath;
	}
	
	public static Icon getIconFromClass(ChessPiece piece) {
		String path = getIconPathFromClass(piece);
		ImageIcon icon = new ImageIcon(path);
		
		//Error checks?
		return icon;
	}

}
