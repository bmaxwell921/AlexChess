package main.chess.ui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.chess.logic.ChessGame;
import main.chess.logic.ImageUtil;

public class ChessPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1257303797158861968L;

	/**
	 * Field to represent the size of a block on the chess board
	 */
	private final int squareSize = 125;
	
	/**
	 * The chess board, in button representation. Each button will have 
	 * an icon on top of it
	 */
	private JButton[][] chessBoard;
	
	public ChessPanel(ChessGame game) {
		this.setLayout(new GridLayout(game.getHeight(), game.getWidth()));		
		setUpBoard(game);
	}

	private void setUpBoard(ChessGame game) {
		//TODO will need to keep track of which player this actually is
		//for orientation of the board
		chessBoard = new JButton[game.getHeight()][game.getWidth()];
		for (int i = game.getHeight() - 1; i >= 0; --i) {
			this.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
			for (int j = 0; j < game.getWidth(); ++j) {
				//JButtons can take an ImageIcon as a param on construction which
				//will display in the button. We get this image path
				//from the ClassToIconUtil. 
				JButton newButton;
				
//				newButton =  new JButton(ImageUtil.getIconFromBlock(
//						game.getAt(new Point(j, i)), squareSize, squareSize));
				newButton = new JButton(ImageUtil.getBlendedIcon(game.getAt(new Point(j, i)),
						squareSize, squareSize));
				newButton.addActionListener(this);
				chessBoard[i][j] = newButton;
				this.add(newButton);
			}
		}
		//Adds the letters on the bottom
		this.add(new JLabel());
		for (int i = 0; i < game.getHeight(); ++i) {
			this.add(new JLabel("" + (char) (i + 'a'), SwingConstants.CENTER));
		}
		System.out.println(chessBoard[0][0].getSize());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Color stuff depending on what the user selects.
		// Attacked pieces are Red, valid move locations are green - negotiable
		
	}

}
