package main.chess.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.chess.common.Constants;
import main.chess.common.Constants.ColorEnum;
import main.chess.common.Constants.Tile;
import main.chess.logic.ChessGame;
import main.chess.logic.ImageUtil;
import main.chess.model.notPieces.ChessBlock;

public class ChessPanel extends JPanel implements MouseListener {

	/*
	 * TODO
	 * This is causing weird bugs...I can click on my own pieces to move to, which should
	 * be taken care of. And the gold square only shows up when I'm debugging
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6167997664863382624L;

	//Meaning 7/8th of the screen is the board and 1/8 is the info panel
	private final float screenPortion = 7f/ 8f;
	
	/*
	 * The chess board images
	 */
	private JLabel[][] tiles;
	
	/*
	 * The current game
	 */
	private ChessGame game;
	
	private JPanel boardPanel;
	private JPanel scorePanel;
	
	private int blockSize;
	
	public ChessPanel(ChessGame game) {
		this.game = game;
		this.setupPanels();
		this.setUpBoard();
	}
	
	private void setupPanels() {
		//Take the screen size...use it appropriately
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double minSpace = Math.min(screenSize.height, screenSize.width * screenPortion);
		blockSize = (int) minSpace / (Constants.BOARDWIDTH + 1);
		
		//+1 here for labels
		boardPanel = new JPanel(new GridLayout(Constants.BOARDHEIGHT + 1, Constants.BOARDWIDTH + 1));
		boardPanel.setPreferredSize(new Dimension((int) minSpace, screenSize.height));
		scorePanel = new JPanel();
		scorePanel.setPreferredSize(new Dimension((int) (screenSize.width - minSpace), 
				screenSize.height));
		
		boardPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		scorePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.add(boardPanel);
		this.add(scorePanel);
	}
	
	private void setUpBoard() {
		tiles = new JLabel[Constants.BOARDHEIGHT][Constants.BOARDWIDTH];
		
		for (int i = Constants.BOARDHEIGHT - 1; i >= 0; --i) {
			boardPanel.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
			for (int j = 0; j < Constants.BOARDWIDTH; ++j) {
				ChessBlock block = game.getBlock(new Point(j, i));
				
				JLabel label = new ChessBoardLabel(ImageUtil.getBlendedIcon(block, 
						block.getBlockColor() == ColorEnum.WHITE ? Tile.WHITE : Tile.BLACK, 
						blockSize, blockSize), i, j);
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				label.setPreferredSize(new Dimension(blockSize, blockSize));
				label.addMouseListener(this);
				tiles[i][j] = label;
				boardPanel.add(label);
			}
		}
		this.add(new JLabel());
		for (int i = 0; i < Constants.BOARDWIDTH; ++i) {
			boardPanel.add(new JLabel("" + (char) (i + 'a'), SwingConstants.CENTER));
		}
	}
	
	private class ChessBoardLabel extends JLabel {

		private static final long serialVersionUID = -3059892928164785881L;
		
		public int i,j;
		
		public ChessBoardLabel(Icon icon, int i, int j) {
			super(icon);
			this.i = i;
			this.j = j;
		}
		
	}
	//test
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*
		 * TODO this shouldn't happen here. The UI is taking forever to update
		 * We probably want to do this like the old version and call the update
		 * when an action is performed. Maybe get a result from the game.evaluateInput.
		 * This result might just be a boolean tell us whether anything changed. The only
		 * time something doesn't change is when nothing is selected and they select an 
		 * empty tile or a piece that isn't theirs
		 */
		Point selLoc = game.getSelectedPieceLoc();
		if (selLoc != null) {
			updateLabel(selLoc, Tile.HOLD);
		}
	}

	private void updateLabel(Point selectedLoc, Tile type) {
		tiles[selectedLoc.y][selectedLoc.x].setIcon(
				ImageUtil.getBlendedIcon(game.getBlock(selectedLoc),
				type, Constants.squareSize, Constants.squareSize));
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getSource().getClass() == ChessBoardLabel.class) {
			ChessBoardLabel source = (ChessBoardLabel) event.getSource();
			game.evaluateInput(new Point(source.j, source.i));
		}	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
