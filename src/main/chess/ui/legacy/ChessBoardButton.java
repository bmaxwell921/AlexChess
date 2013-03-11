package main.chess.ui.legacy;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * A Class be used as the chess board tile. This will provide a constant time access
 * to the row and column that this button is located at
 * @author Brandon
 *
 */
public class ChessBoardButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2825220795376887608L;
	
	private int i,j;
	
	public ChessBoardButton(Icon icon, int i, int j) {
		super(icon);
		this.i = i;
		this.j = j;
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
}
