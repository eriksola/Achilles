package Boundary;

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

import Controller.ReturnToDefMenuController;
import Game.Board;
import Game.BullPen;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import Boundary.PieceView;

public class PuzzleLevelPanel extends JPanel {

	KabasujiFrame mainframe;
	JButton lvlMenuBtn;
	JButton helpBtn;
	Stock s = new Stock();
	//RIGHT NOW THIS TILE SIZE IS DEFAULT, IT WILL CHANGE
	Tile[][] tiles = new Tile[6][6];
	Board board;

	BullPen bp;
	/**
	 * Create the panel.
	 */
	public PuzzleLevelPanel(KabasujiFrame f) {
		setBackground(new Color(173, 216, 230));
		this.mainframe = f;
		//Add pieces to the bull
		bp = new BullPen(null, null);
		bp.setPieces(s.getRandomPiecesForPen());
		PieceView[] pvs = new PieceView[35];
		bp.setPvs(pvs);
		
		board = new Board(tiles);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton back = new JButton("Back");
		this.lvlMenuBtn = back;
		
		JLabel label = new JLabel("Level");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton help = new JButton("Help");
		this.helpBtn = help;
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		BoardView boardView = new BoardView(mainframe, board);
		
		JButton deg = new JButton("90");
		
		JButton reset = new JButton("Reset");
		
		
		JPanel bullpen = new BullPenView(f,bp);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(38)
								.addComponent(back)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(bullpen, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
								.addGap(3)))
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
							.addComponent(bullpen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
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
	}
	
	public JButton getLevelMenuButton(){
		return lvlMenuBtn;
	}
}
