package main.chess.legacy.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.chess.logic.ChessGame;

public class StartScreen extends JPanel implements ActionListener {

	/**
	 * Button used to load a previously saved game
	 */
	private JButton loadButton;
	
	/**
	 * Button to start a new game
	 */
	private JButton newGameButton;
	
	/**
	 * Button to exit the program
	 */
	private JButton exitButton;
	
	/**
	 * The frame this panel resides in
	 */
	private JFrame myFrame;
	
	/**
	 * Initializes the start screen
	 */
	public StartScreen(JFrame f) {
		myFrame = f;
		
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Chess", SwingConstants.CENTER);
		title.setFont(new Font("Lucida Grand", 0, 36));
		this.add(title, BorderLayout.CENTER);
		
		//Sets up the buttons, adds actionListeners, and adds them to the panel
		this.setUpButtons();

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	private void setUpButtons() {
		JPanel buttonPanel = new JPanel();
		
		loadButton = new JButton("Load Game");
		newGameButton = new JButton("New Game");
		exitButton = new JButton("Exit");
		
		loadButton.addActionListener(this);
		newGameButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		buttonPanel.add(loadButton);
		buttonPanel.add(newGameButton);
		buttonPanel.add(exitButton);
		
		this.add(buttonPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Checks which button was pressed then acts accordingly
		if(e.getSource() == loadButton) {
			loadChessGame();
		}
		else if (e.getSource() == newGameButton) {
			startNewGame();
		}
		else if (e.getSource() == exitButton) {
			exitGame();
		}
		
	}

	private void loadChessGame() {
		// TODO This will pop open a FileDialogBox and then parse the File.
		// It needs to send the string version of the game to the Game Object 
		// which will parse out the lost players and whose turn it is and then
		//pass everything along to the board. Use the GameIOUtil
		System.out.println("Load button pressed");
	}
	

	private void startNewGame() {
		// This starts up a game with the default values for everything.
		// Then switches the frame.contentPane() to a ChessGamePanel
		System.out.println("Start button pressed");
		
		//TODO get the player names
		PlayScreen play = new PlayScreen(new ChessGame("", ""));
		
		//Transfers the screen to the play screen
		myFrame.getContentPane().add(play);
		
		this.setVisible(false);
		myFrame.getContentPane().remove(this);
	}

	private void exitGame() {
		// Just exits the application since nothing has happened
		System.exit(0);
	}
}
