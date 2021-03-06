package Boundary.Player;

import javax.swing.JPanel;

import java.awt.BorderLayout;
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
import Controller.LevelPlayerController;
import Controller.ReturnToDefMenuController;
import Controller.RotateController;
import Controller.RulesController;
import Controller.TimerController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.IScore;
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
import Boundary.Both.PieceView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

/**
 * JPanel to hold a PuzzleLevel in the <b> Kabasuji </b> game.
 * @author User
 *
 */
public class PuzzleLevelPanel extends KabaSujiPlayer {

	KabasujiFrame mainFrame;
	PuzzleLevelModel initialModel;
	PuzzleLevelModel currentModel;
	Board board;
	BullPen bp;
	int numMoves;
	PuzzleScore score;
	Stock stock;
	
	BoardView boardView;
	BullPenView bullPenView;
	StarView starView;
	JScrollPane scrollPane;
	JTextArea movesView;
	JButton endLvlBtn;
	
	/**
	 * Create the panel.
	 */
	public PuzzleLevelPanel(KabasujiFrame f, PuzzleLevelModel m) {
		
		this.mainFrame = f;
		this.currentModel = m;
		System.out.println(m.getName());
		this.board = currentModel.getBoard();
		this.bp = currentModel.getBullPen();
		this.numMoves = currentModel.getMovesAllowed();	
		currentModel.setScore(new PuzzleScore(numMoves));
		this.score = (PuzzleScore) currentModel.getScore();
		this.stock = new Stock();
		this.initialModel = new PuzzleLevelModel(this.board, this.bp, m.getName(),(PuzzleScore) m.getScore(), this.stock, this.numMoves);
		
		setBackground(new Color(173, 216, 230));
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		bullPenView.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		boardView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		JButton horBtn = new JButton("Horizontal");
		
		JButton vertBtn = new JButton("Vertical");
		
		JButton rotateBtn = new JButton("90");
		
		JButton button_3 = new JButton("Back");
				
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setForeground(Color.BLACK);
		lblPuzzle.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton button_4 = new JButton("Help");
				
		JButton button_5 = new JButton("Reset");
		
		JTextArea textArea = new JTextArea("Moves Left: " + Integer.toString(numMoves));
		textArea.setEditable(false);
		this.movesView = textArea;
		
		this.starView = new StarView();
		
		JButton btnEndLevel = new JButton("END LEVEL");
		btnEndLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.endLevel(initialModel, score);
			}
		});
		btnEndLevel.setEnabled(false);
		this.endLvlBtn = btnEndLevel;
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(horBtn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(vertBtn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rotateBtn))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_3)))
					.addGap(60)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnEndLevel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
									.addGap(48)
									.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGap(20)
									.addComponent(lblPuzzle)
									.addPreferredGap(ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
									.addComponent(button_4)))
							.addGap(38))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(starView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(341))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(138)
								.addComponent(button_5)
								.addGap(138)))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPuzzle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(starView, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_3)
						.addComponent(button_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(213)
									.addComponent(btnEndLevel)))
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(horBtn)
								.addComponent(vertBtn)
								.addComponent(rotateBtn)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(36))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers
		button_3.addActionListener(new ReturnToDefMenuController(mainFrame));
		button_4.addActionListener(new RulesController(mainFrame, this, initialModel, 1));
		button_5.addActionListener(new LevelPlayerController(mainFrame, initialModel));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		horBtn.addActionListener(new HflipController(this));
		vertBtn.addActionListener(new VflipController(this));
		rotateBtn.addActionListener(new RotateController(this));

	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	public BoardView getBoardView(){
		return this.boardView;
	}
	
	public BullPenView getBullPenView(){
		return this.bullPenView;
	}

	@Override
	public void updateScore() {
		score.updateScore(currentModel);
		
		//update the star view
		if (score.scoreToStars() > starView.getStars()){
			starView.addStar();
		}
		
		if (score.scoreToStars() < starView.getStars()){
			starView.removeStar();
		}
		
		//if the player has earned at least one star, they can end the level
		if (score.scoreToStars() >= 1){
			endLvlBtn.setEnabled(true);
		}
		
		//if the maximum score has been earned, end the level
		if (score.scoreToStars() == 3){
			mainFrame.endLevel(initialModel, score);
		}
	}
	
	//called by BoardController when successfully using addPiece()
	public void useMove(){
		//decrement the number of moves left and change to a string
		String strMoves = Integer.toString(--numMoves);
		
		//if there are no moves left, end the game
		if (numMoves <= 0){
			mainFrame.endLevel(initialModel, score);
		}
		//update the boundary view of moves left
		this.movesView.setText("Moves Left: " + strMoves);
	}

}
