package Boundary.Player;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.KabaSujiPlayer;
import Game.Board;
import Game.BullPen;
import Game.LevelModel;
import Game.Stock;
import Game.Tile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

/**
 * Panel to hold a Release Level in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class ReleaseLevelPanel extends KabaSujiPlayer{

	KabasujiFrame mainframe;
	
	
	LevelModel model;
	Stock s = new Stock();
	//TILES SHOULD NOT BE SET TO NULL
	Tile[][] brdTiles;
	Board board;
	BullPen bp;
	
	BullPenView bullPenView;
	BoardView boardView;
	/**
	 * Create the panel.
	 */
	public ReleaseLevelPanel(KabasujiFrame f, LevelModel m) {
		
		this.mainframe = f;


		bp = new BullPen();
		
		this.brdTiles = new Tile[10][10];
		//start board empty
		for (int i = 0; i < brdTiles.length; i++) {
			for (int j = 0; j < brdTiles[0].length; j++) {
				brdTiles[i][j] = new Tile(i, j);
			}
		}
		
		this.board = new Board(brdTiles);
		BoardView boardView = new BoardView(mainframe, board, this, bullPenView);
		boardView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		//WINDOWBUILDER - DONT TOUCH
		setBackground(new Color(173, 216, 230));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Horizontal");
		
		JButton button_1 = new JButton("Vertical");
		
		JButton button_2 = new JButton("90");
		
		JButton button_3 = new JButton("Back");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("Level");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton button_4 = new JButton("Help");
				
		JButton button_5 = new JButton("Reset");

		/** Starview for score */
		StarView stars = new StarView();
		//To add a star simply call the addStars method
	
		stars.setBackground(new Color(173, 216, 230));
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
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addGap(298)
									.addComponent(button_4))
								.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_5)
							.addGap(112))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(272)
					.addComponent(stars, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(293, Short.MAX_VALUE))
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
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
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
										.addComponent(button_2)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(32)
							.addComponent(stars, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addGap(32))
		);
		panel.setLayout(gl_panel);

		//activate controllers **TO DO**
	}
	@Override
	public JScrollPane getScrollPane() {
		// TODO Auto-generated method stub
		return null;
	}

	public BoardView getBoardView(){
		return this.boardView;
	}
	
	public BullPenView getBullPenView(){
		return this.bullPenView;
	}
	
	@Override
	public void updateScore() {
	
	}
	@Override
	public void addLevelModel() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public LevelModel getLastLevelModel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addModelForRedo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public LevelModel getLastRedoModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
