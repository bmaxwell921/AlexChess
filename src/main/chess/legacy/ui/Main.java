package main.chess.legacy.ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		};
		SwingUtilities.invokeLater(r);
	}

	private static void createAndShowGUI() {
		//Sets up the frame to view everything in
		JFrame frame = new JFrame("Chess");
		
		//Makes it so when you press X it terminates the program
		//TODO need to make sure this saves the game state
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel startScreen = new StartScreen(frame);
		
		//Adds the start panel to this frame so we can see it and sets the size
		frame.getContentPane().add(startScreen);
		frame.setLayout(new FlowLayout());
		
		//Makes the frame fit to the size of the panel and makes it visible
		frame.pack();
		frame.setVisible(true);
	}
}
