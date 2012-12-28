package main.chess.ui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import main.chess.common.Constants;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		frame.getContentPane().add(new StartScreen(frame.getContentPane()), Constants.STARTSCREEN);
		
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

}