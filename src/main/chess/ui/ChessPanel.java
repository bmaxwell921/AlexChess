package main.chess.ui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.chess.common.Constants.ColorEnum;
import main.chess.common.Constants.GameState;
import main.chess.common.Constants.Tile;
import main.chess.logic.ChessGame;
import main.chess.logic.ImageUtil;
import main.chess.model.ChessBlock;

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
	 * The chess board, in button representation. Each button will have an icon
	 * on top of it
	 */
	private JButton[][] chessBoard;

	/**
	 * The game currently being played
	 */
	private ChessGame game;

	/**
	 * The current state of the game
	 */
	private GameState state;

	public ChessPanel(ChessGame game) {
		this.game = game;
		state = GameState.START;
		this.setLayout(new GridLayout(game.getHeight(), game.getWidth()));
		setUpBoard(game);
	}

	private void setUpBoard(ChessGame game) {
		// TODO will need to keep track of which player this actually is
		// for orientation of the board
		chessBoard = new JButton[game.getHeight()][game.getWidth()];
		for (int i = game.getHeight() - 1; i >= 0; --i) {
			this.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
			for (int j = 0; j < game.getWidth(); ++j) {
				// JButtons can take an ImageIcon as a param on construction
				// which
				// will display in the button. We get this image path
				// from the ClassToIconUtil.
				ChessBlock block = game.getAt(new Point(j, i));
				JButton newButton = new ChessBoardButton(
						ImageUtil.getBlendedIcon(
								block,
								(block.getBlockColor() == ColorEnum.WHITE) ? Tile.WHITE
										: Tile.BLACK, squareSize, squareSize),
						i, j);
				newButton.addActionListener(this);
				chessBoard[i][j] = newButton;
				this.add(newButton);
			}
		}
		// Adds the letters on the bottom
		this.add(new JLabel());
		for (int i = 0; i < game.getHeight(); ++i) {
			this.add(new JLabel("" + (char) (i + 'a'), SwingConstants.CENTER));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Attacked pieces are Red, valid move locations are green - negotiable
		if (e.getSource().getClass() == ChessBoardButton.class) {
			this.updateSelectedPiece((ChessBoardButton) e.getSource());
		}
		repaint();
	}

	private void updateSelectedPiece(ChessBoardButton b) {
		Point newP = new Point(b.getJ(), b.getI());
		if (state == GameState.RUN_HOLD_PIECE) {
			this.resetOldSelected();
		}
		if (game.canSelect(newP)) {
			//If we already have a selected piece reset its stuff
			game.setSelectedPiece(newP);
			this.updateSelected();
			state = GameState.RUN_HOLD_PIECE;
		} else {
			game.resetSelectedPiece();
			state = GameState.RUN_WAIT;
		}
	}

	private void resetOldSelected() {
		//Changes the hold tile back to the block color
		this.changeHold(game.getAt(game.getSelectedPieceLocation()).getBlockColor() == 
				ColorEnum.WHITE ? Tile.WHITE : Tile.BLACK);
		this.changeLocColor(game.getSelectedPieceAttackPieces(), true, Tile.WHITE);
		this.changeLocColor(game.getSelectedPieceMoveLocations(), true, Tile.WHITE);
	}
	
	private void updateSelected() {
		this.changeHold(Tile.HOLD);
		this.changeLocColor(game.getSelectedPieceAttackPieces(), false, Tile.ATTACK);
		this.changeLocColor(game.getSelectedPieceMoveLocations(), false, Tile.MOVE);
	}
	
	private void changeHold(Tile type) {
		Point selectedLoc = game.getSelectedPieceLocation();
		ChessBlock block = game.getAt(selectedLoc);
		updateButton(block, selectedLoc, type);	
	}
	
	private void changeLocColor(Set<Point> locs, boolean useTileType, Tile otherType) {
		if (locs != null) {
			Tile backgroundType;
			for (Point p : locs) {
				if (useTileType) {
					//If we are resetting we need to blend with the tile color
					backgroundType = (game.getAt(p).getBlockColor() == ColorEnum.WHITE) ? Tile.WHITE : Tile.BLACK;
				} else {
					backgroundType = otherType;
				}
				this.updateButton(game.getAt(p), p, backgroundType);
			}
		}
	}
	
	private void updateButton(ChessBlock block, Point selectedLoc, Tile type) {
		chessBoard[selectedLoc.y][selectedLoc.x].setIcon(ImageUtil.getBlendedIcon(block,
				type, squareSize, squareSize));
	}
}
