package Boundary.Player;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.BoardController;
import Controller.BullPenController;
import Controller.DefLevelMenuToPuzzleLevelController;
import Controller.HflipController;
import Controller.PlayPuzzletoPuzzleRulesController;
import Controller.ReturnToDefMenuController;
import Controller.RotateController;
import Controller.TimerController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.Piece;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.Stock;
import Game.Tile;
import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.KabaSujiPlayer;
import Boundary.Both.PieceView;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class PuzzleLevelPanel extends KabaSujiPlayer {


	KabasujiFrame mainFrame;
	PuzzleLevelModel levelModel;
	Board board;
	BullPen bp;
	int numMoves;
	PuzzleScore score;
	
	BoardView boardView;
	BullPenView bullPenView;
	JScrollPane scrollPane;
	JTextArea movesView;

	
	/**
	 * Create the panel.
	 */
	public PuzzleLevelPanel(KabasujiFrame f, PuzzleLevelModel m) {
		
		
		this.mainFrame = f;
		this.levelModel = m;
		this.board = m.getBoard();
		this.bp = m.getBullPen();
		this.numMoves = m.getMovesAllowed();
		this.score = (PuzzleScore) m.getScore();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		
		JButton button = new JButton("Horizontal");
		
		JButton button_1 = new JButton("Vertical");
		
		JButton button_2 = new JButton("90");
		
		JButton button_3 = new JButton("Back");
				
		JLabel label = new JLabel("Level");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton button_4 = new JButton("Help");
				
		JButton button_5 = new JButton("Reset");
		
		JTextArea textArea = new JTextArea(Integer.toString(numMoves));
		textArea.setEditable(false);
		this.movesView = textArea;
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2))
						.addComponent(button_3)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addGap(298)
									.addComponent(button_4))
								.addComponent(textArea, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_5)
							.addGap(112))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addComponent(button_4))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1)
								.addComponent(button_2)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers
		button_3.addActionListener(new ReturnToDefMenuController(mainFrame));
		button_4.addActionListener(new PlayPuzzletoPuzzleRulesController(mainFrame));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));


	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	public BoardView getBoardView(){
		return this.boardView;
	}

	@Override
	public void updateScore() {
		score.updateScore(levelModel);
	}

}
