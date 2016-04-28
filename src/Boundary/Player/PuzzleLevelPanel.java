package Boundary.Player;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.BoardController;
import Controller.BullPenController;
import Controller.DefLevelMenuToPuzzleLevelController;
import Controller.PlayPuzzletoPuzzleRulesController;
import Controller.ReturnToDefMenuController;
import Game.Board;
import Game.BullPen;
import Game.LevelModel;
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

	KabasujiFrame mainframe;
	PuzzleLevelModel levelModel;
	Board board;
	BullPen bp;
	int numMoves;
	PuzzleScore score;
	
	JButton lvlMenuBtn;
	JButton helpBtn;
	JButton resetBtn;
	BullPenView bullPenView;

	BoardView boardView;
	JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public PuzzleLevelPanel(KabasujiFrame f, PuzzleLevelModel model) {

		this.mainframe = f;
		this.levelModel = model;
		this.bp = levelModel.getBullPen();
		this.board = levelModel.getBoard();
		this.numMoves = levelModel.getMovesAllowed();
		this.score = (PuzzleScore) levelModel.getScore();
		
		PuzzleLevelModel initLevel = new PuzzleLevelModel(this.board, this.bp, model.getLevelNum(), new PuzzleScore(this.numMoves), this.numMoves);
		//WINDOWBUILDER - DONT TOUCH
		
		setBackground(new Color(173, 216, 230));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(100, 100, 769, 485);
		
		JButton help = new JButton("Help");
		this.helpBtn = help;
		helpBtn.addActionListener(new PlayPuzzletoPuzzleRulesController(mainframe));
		
		JLabel label = new JLabel();
		label.setText("Level #" + this.levelModel.getLevelNum());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton back = new JButton("Back");
		this.lvlMenuBtn = back;
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(back)
					.addGap(242)
					.addComponent(label)
					.addGap(234)
					.addComponent(help)
					.addGap(114))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(back)
						.addComponent(help))
					.addGap(5))
		);
		panel.setLayout(gl_panel);
		
		JButton reset = new JButton("Reset");
		this.resetBtn = reset;
		
		JButton vertical = new JButton("Vertical");
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton deg = new JButton("90");
		
		
		//generate the BullPenView (with scroll panel)
		JScrollPane scrollPane_2 = new JScrollPane();
		this.scrollPane = scrollPane_2;
		BullPenView bpView = new BullPenView(this.mainframe, this.bp, this);
		this.bullPenView = bpView;
		scrollPane.setViewportView(bullPenView);
		
		//generate the bullPenView
		BoardView boardView_1 = new BoardView(this.mainframe, this.board, this, this.bullPenView);
		this.boardView = boardView_1;
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(horizontal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(vertical)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deg))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(bpView, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(boardView_1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addGap(101))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(reset)
							.addGap(211))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(bpView, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boardView_1, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(horizontal)
						.addComponent(vertical)
						.addComponent(deg)
						.addComponent(reset))
					.addGap(90))
		);
		setLayout(groupLayout);
		
		//-------------
		//activate controllers for buttons
		lvlMenuBtn.addActionListener(new ReturnToDefMenuController(mainframe));
		resetBtn.addActionListener(new DefLevelMenuToPuzzleLevelController(mainframe, initLevel));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
	}
	
	public JButton getLevelMenuButton(){
		return lvlMenuBtn;
	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}
	
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	public LevelModel getLevelModel(){
		return this.levelModel;
	}

	@Override
	public void updateScore() {
		score.updateScore(levelModel);
	}
}
