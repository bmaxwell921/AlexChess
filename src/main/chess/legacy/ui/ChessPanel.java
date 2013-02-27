package main.chess.legacy.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.chess.logic.ChessGame;

public class ChessPanel extends JPanel implements ActionListener {

	/**
	 * Field to represent the size of a block on the chess board
	 */
	private final int pixelSize = 100;
	
	/**
	 * The chess board, in button representation. Each button will have 
	 * an icon on top of it
	 */
	private JButton[][] chessBoard;
	
	public ChessPanel(ChessGame game) {
		this.setLayout(new GridLayout(game.getHeight(), game.getWidth()));
//		this.setPreferredSize(new Dimension(game.getWidth() * pixelSize, 
//				game.getHeight() * pixelSize));
		
		setUpBoard(game);
	}

	private void setUpBoard(ChessGame game) {
		//TODO will need to keep track of which player this actual is
		//for orientation of the board
		chessBoard = new JButton[game.getHeight()][game.getWidth()];
		int order = 0;
		for (int i = game.getHeight() - 1; i >= 0; --i) {
			this.add(new JLabel("" + (i + 1)));
			for (int j = 0; j < game.getWidth(); ++j) {
				//JButtons can take an ImageIcon as a param on construction which
				//will display in the button. We get this image path
				//from the ClassToIconUtil. 
				JButton newButton;
				
//				newButton =  new JButton(ClassToIconUtil.getIconFromClass(
//						game.getAt(new Point(j, i)).getPiece()));
				newButton = new JButton(i + ", " + j);
				newButton.setPreferredSize(new Dimension(pixelSize, pixelSize));
				newButton.addActionListener(this);
				chessBoard[i][j] = newButton;
				this.add(newButton);
			}
		}
	}
	
	public void paintComponent() {
		//Not sure what's gonna happen here
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Color stuff depending on what the user selects.
		// Attacked pieces are Red, valid move locations are green - negotiable
		
	}

}
