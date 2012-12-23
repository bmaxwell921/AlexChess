package main.chess.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import main.chess.logic.ImageUtil;
import main.chess.model.Bishop;
import main.chess.model.ChessBlock;
import main.chess.model.ChessPiece;
import main.chess.model.ChessPiece.ColorEnum;
import main.chess.model.Knight;
import main.chess.model.Pawn;
import main.chess.model.Queen;
import main.chess.model.Rook;
import main.chess.player.ChessPlayer;

public class StatisticsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6104995994656020866L;

	private static final int lostPicSize = 30;
	
	//Panels to hold images of the lost pieces
	private JPanel whiteLost;
	private JPanel blackLost;
	
	//Lists of what each person has lost
	private List<ChessBlock> whitePieces;
	private List<ChessBlock> blackPieces;
	
	/**
	 * Create the panel.
	 */
	public StatisticsPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Statistics");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel capturedPanel = new JPanel();
		add(capturedPanel, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		capturedPanel.add(splitPane);
		
		JPanel whitePanel = new JPanel();
		splitPane.setLeftComponent(whitePanel);
		whitePanel.setLayout(new BorderLayout(0, 0));
		
		whiteLost = new JPanel();
		whitePanel.add(whiteLost, BorderLayout.PAGE_END);
		
		
		JLabel whiteLabel = new JLabel("White's Lost Pieces: ");
		whiteLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		whiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whitePanel.add(whiteLabel);
		
		JPanel blackPanel = new JPanel();
		splitPane.setRightComponent(blackPanel);
		blackPanel.setLayout(new BorderLayout(0, 0));
		
		blackLost = new JPanel();
		blackPanel.add(blackLost, BorderLayout.PAGE_END);
		
		JLabel blackLabel = new JLabel("Black's Lost Pieces: ");
		blackLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		blackPanel.add(blackLabel);
		
		whitePieces = new ArrayList<ChessBlock>();
		blackPieces = new ArrayList<ChessBlock>();
	}
	
	public void addCapturedPiece(ChessPlayer lostPlayer, ChessBlock lostPiece) {
		JPanel workingPanel = null;
		List<ChessBlock> workingList = null;
		if (lostPlayer.getColor() == ColorEnum.WHITE) {
			workingPanel = whiteLost;
			workingList = whitePieces;
		}
		else {
			workingPanel = blackLost;
			workingList = blackPieces;
		}
		
		workingList.add(lostPiece);
		Collections.sort(workingList);
		
		workingPanel.removeAll();
		
		for (int i = 0; i < workingList.size(); ++i) {
			workingPanel.add(new JLabel(ImageUtil.getIconFromBlock(workingList.get(i), lostPicSize, lostPicSize)));
		}
	}

}
