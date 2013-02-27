package main.chess.legacy.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.chess.logic.ChessGame;

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
	 * The game currently being played
	 */
	private ChessGame game;
	
	public PlayScreen(ChessGame game) {
		this.game = game;
		
		this.setLayout(new BorderLayout());
		
		this.setUpButtons();
		
		//ChessPanel holds the actual board of buttons to click
		this.add(new ChessPanel(game), BorderLayout.CENTER);
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
		
	}

}
