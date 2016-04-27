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

import Controller.BullPenController;
import Controller.PlayPuzzletoPuzzleRulesController;
import Controller.ReturnToDefMenuController;
import Game.Board;
import Game.BullPen;
import Game.LevelModel;
import Game.Piece;
import Game.PuzzleLevelModel;
import Game.Stock;
import Game.Tile;
import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;

public class PuzzleLevelPanel extends KabaSuji {

	KabasujiFrame mainframe;
	PuzzleLevelModel levelModel;
	Board board;
	BullPen bp;
	int numMoves;
	
	JButton lvlMenuBtn;
	JButton helpBtn;
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
		
		//WINDOWBUILDER - DONT TOUCH
		setBackground(new Color(173, 216, 230));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton back = new JButton("Back");
		this.lvlMenuBtn = back;
		
		JLabel label = new JLabel();
		label.setText("Level #" + this.levelModel.getLevelNum());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton help = new JButton("Help");
		this.helpBtn = help;
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		BullPenView bullPenView = new BullPenView(this.mainframe, this.bp, this);
		this.bullPenView = bullPenView;
		
		BoardView boardView = new BoardView(this.mainframe, this.board, this, bullPenView);
		this.boardView = boardView;
		
		JButton deg = new JButton("90");
		
		JButton reset = new JButton("Reset");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		this.scrollPane = scrollPane_2;
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(back)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(bullPenView, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(157))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(74)
							.addComponent(horizontal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(vertical)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deg)))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addGap(298)
							.addComponent(help)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(reset)
							.addGap(112))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addGap(69))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(label))
								.addComponent(help)
								.addComponent(back))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(27)
									.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(37)
									.addComponent(bullPenView, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(240)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(101)))
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(reset)
						.addComponent(horizontal)
						.addComponent(vertical)
						.addComponent(deg))
					.addGap(32))
		);
		
		panel.setLayout(gl_panel);
		ReturnToDefMenuController n; 
		
		//-------------
		//activate controllers for buttons
		lvlMenuBtn.addActionListener(new ReturnToDefMenuController(mainframe));
		helpBtn.addActionListener(new PlayPuzzletoPuzzleRulesController(mainframe));
		bullPenView.addMouseListener(new BullPenController(this, bullPenView));
		scrollPane.setViewportView(bullPenView);
	}
	
	public JButton getLevelMenuButton(){
		return lvlMenuBtn;
	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}
}
