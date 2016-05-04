package Boundary.Player;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.StockView;
import Controller.BoardController;
import Controller.BullPenController;
import Controller.HflipController;
import Controller.LevelPlayerController;
import Controller.ReturnToDefMenuController;
import Controller.RotateController;
import Controller.RulesController;
import Controller.TimerController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.LightningBoard;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.Stock;
import Game.Tile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * JPanel to hold a lightning level in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class LightningLevelPanel extends KabaSujiPlayer{


	KabasujiFrame mainFrame;
	LightningLevelModel currentModel;
	LightningLevelModel initialModel;
	LightningBoard board;
	BullPen bp;
	Stock stock;
	int time;
	LightningScore score;
	
	BoardView boardView;
	BullPenView bullPenView;
	StarView starView;
	JScrollPane scrollPane;
	JTextArea timerView;
	JButton endLvlBtn;
	
	/**
	 * Create the panel.
	 */
	public LightningLevelPanel(KabasujiFrame f, LightningLevelModel m) {
		
		setBackground(new Color(173, 216, 230));
		
		this.mainFrame = f;
		this.currentModel = m;
		this.board = currentModel.getLightningBoard();	
		this.bp = currentModel.getBullPen();
		this.time = currentModel.getTime();
		Tile[][] tiles = m.getLightningBoard().getTiles();
		int totalTiles = 0;
		for (int a = 0; a < tiles.length; a++){
			for (int b = 0; b < tiles[0].length; b++){
				if (tiles[a][b] != null) {totalTiles++;}
			}
		}
		currentModel.setScore(new LightningScore(totalTiles));
		this.score = (LightningScore) currentModel.getScore();
		this.stock = new Stock();
		this.initialModel = new LightningLevelModel(this.board, this.bp, m.getName(), m.getScore(), this.stock, this.time);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		bullPenView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		boardView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton horBtn = new JButton("Horizontal");
		
		JButton vertBtn = new JButton("Vertical");
		
		JButton rotateBtn = new JButton("90");
		
		JButton button_3 = new JButton("Back");
		
		JButton button_4 = new JButton("Help");
				
		JButton button_5 = new JButton("Reset");
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		this.timerView = textArea;
		
		this.starView = new StarView();
		
		JLabel label = new JLabel("Lightning");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
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
						.addComponent(button_3)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(horBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(vertBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rotateBtn)))
					.addGap(54)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
									.addComponent(button_4))
								.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnEndLevel, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
							.addGap(169)
							.addComponent(button_5)
							.addGap(91)))
					.addGap(12))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(308)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(button_3)
							.addComponent(button_4))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
									.addGap(20))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addGap(49)
									.addComponent(starView, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnEndLevel)
									.addGap(67)))
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(horBtn)
								.addComponent(vertBtn)
								.addComponent(rotateBtn)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(172))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers
		button_3.addActionListener(new ReturnToDefMenuController(mainFrame));
		button_4.addActionListener(new RulesController(mainFrame, this, initialModel, 2));
		button_5.addActionListener(new LevelPlayerController(mainFrame, initialModel));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		horBtn.addActionListener(new HflipController(this));
		vertBtn.addActionListener(new VflipController(this));
		rotateBtn.addActionListener(new RotateController(this));

		//start timer
		new TimerController(mainFrame, this, this.timerView, this.time);
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
	
	public LightningLevelModel getInitial(){
		return this.initialModel;
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
		
		//if the maximum score has been earned end the level
		if (score.scoreToStars() == 3){
			mainFrame.endLevel(initialModel, score);
		}
	}

	public LightningLevelModel getCurrent(){
		return this.currentModel;
	}
	
	public Stock getStock(){
		return this.stock;
	}

}
