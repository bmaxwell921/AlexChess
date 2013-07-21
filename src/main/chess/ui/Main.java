package main.chess.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

import main.chess.logic.ChessGame;

public class Main {
	
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ChessPanel(new ChessGame()));
		frame.pack();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
