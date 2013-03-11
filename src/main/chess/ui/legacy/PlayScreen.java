package main.chess.ui.legacy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.chess.logic.legacy.ChessGame;
import main.chess.model.notPieces.ChessBlock;
import main.chess.player.ChessPlayer;

public class PlayScreen extends JPanel implements ActionListener {

	/**
	 * A button used to pull from the server
	 */
	private JButton refresh;
	
	/**
	 * A button used to push your move to the server
	 */
	private JButton pushMove;
	
	/**
	 * A button to save the state of the game locally
	 */
	private JButton save;
	
	/**
	 * Panel that holds the lost pieces for this game
	 */
	private StatisticsPanel statPanel;
	
	/**
	 * This panel's parent. To be used to go back to the main menu
	 */
	private Container parent;
	
	public PlayScreen(ChessGame game, Container parent) {		
		this.parent = parent;
		
		this.setLayout(new BorderLayout());
		
		JLabel l = new JLabel("Chess", SwingConstants.CENTER);
		l.setFont(new Font("Lucida Grand", 0, 16));
		this.add(l, BorderLayout.PAGE_START);
		
		this.setUpButtons();
		
		//ChessPanel holds the actual board of buttons to click
		ChessPanel chessPanel = new ChessPanel(this, game);
		this.add(chessPanel, BorderLayout.CENTER);
		
		statPanel = new StatisticsPanel();
		this.add(statPanel, BorderLayout.EAST);
	}
	
	private void setUpButtons() {
		JPanel buttonPanel = new JPanel();
		
		refresh = new JButton("Refresh");
		pushMove = new JButton("Make Move");
		save = new JButton("Save");
		
		refresh.addActionListener(this);
		pushMove.addActionListener(this);
		save.addActionListener(this);
		
		buttonPanel.add(refresh);
		buttonPanel.add(pushMove);
		buttonPanel.add(save);
		
		this.add(buttonPanel, BorderLayout.PAGE_END);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == refresh) {
			refreshGame();
		}
		else if (e.getSource() == pushMove) {
			pushMoveToServer();
		}
		else if (e.getSource() == save) {
			saveGame();
		}
		
	}

	private void refreshGame() {
		// TODO Work with the Internet package to get the current
		//configuration of the board. Should probably check that they're the same
		
	}

	private void pushMoveToServer() {
		// TODO Push the new board to the server
		
	}

	private void saveGame() {
		// TODO Saves the state of the game to the given file
		
		CardLayout lay = (CardLayout) parent.getLayout();
		lay.previous(parent);
		
	}
	
	public void addCapturedPiece(ChessPlayer lostPlayer, ChessBlock lostPiece) {
		statPanel.addCapturedPiece(lostPlayer, lostPiece);
		statPanel.revalidate();
	}

}
