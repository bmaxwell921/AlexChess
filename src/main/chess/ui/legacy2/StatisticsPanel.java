package main.chess.ui.legacy2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import main.chess.common.Constants.ColorEnum;
import main.chess.logic.ImageUtil;
import main.chess.model.notPieces.ChessBlock;
import main.chess.player.ChessPlayer;

public class StatisticsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6104995994656020866L;

	private static final int lostPicSize = 45;
	
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
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		this.add(splitPane);
//		JPanel containerPane = new JPanel();
//		containerPane.setLayout(new BorderLayout());
		
		JPanel whitePanel = new JPanel();
		splitPane.setLeftComponent(whitePanel);
		whitePanel.setLayout(new BorderLayout(0, 0));
		
		whiteLost = new JPanel();
		whiteLost.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		whitePanel.add(whiteLost, BorderLayout.CENTER);
		
		
		JLabel whiteLabel = new JLabel("White's Lost Pieces: ");
		whiteLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		whiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whitePanel.add(whiteLabel, BorderLayout.PAGE_START);
		
		JPanel blackPanel = new JPanel();
		splitPane.setRightComponent(blackPanel);
		blackPanel.setLayout(new BorderLayout(0, 0));
		
		blackLost = new JPanel();
		blackLost.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blackPanel.add(blackLost, BorderLayout.CENTER);
		
		JLabel blackLabel = new JLabel("Black's Lost Pieces: ");
		blackLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		blackPanel.add(blackLabel, BorderLayout.PAGE_START);
		
		whitePieces = new ArrayList<ChessBlock>();
		blackPieces = new ArrayList<ChessBlock>();
		
//		containerPane.add(blackPanel, BorderLayout.EAST);
//		containerPane.add(whitePanel, BorderLayout.WEST);
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
