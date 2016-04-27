package Boundary.Builder;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.StockView;
import Controller.BullPenController;
import Controller.GetMovesController;
import Controller.GetBoardDimensionsController;
import Controller.HflipController;
import Controller.RotateController;
import Controller.SaveController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import Controller.ReturnToBuilderMenuController;

import java.awt.event.InputMethodListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.InputMethodEvent;


public class LevelBuilderPuzzlePanel extends KabaSuji {
	
	ArrayList<Object> entities;
	GetMovesController getMoves;
	
	BullPen bp;
	Board board;
	Stock stock = new Stock();
	
	JTextField x;
	JTextField y;
	JButton exit;
	JButton btnEnter;
	JButton save;
	
	BullPenView bullPenView;
	BoardView boardView;
	StockView stockView;

	JFrame mainFrame;
	private JTextField txtMoves;
	
	JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public LevelBuilderPuzzlePanel(JFrame f) {
		
		Tile[][] brdTiles = new Tile[10][10];
		//start board empty
		for (int i = 0; i < brdTiles.length; i++) {
			for (int j = 0; j < brdTiles[0].length; j++) {
				brdTiles[i][j] = new Tile(false, i, j);
			}
		}
		
		this.board = new Board(brdTiles);
		
		this.bp = new BullPen();
		
		this.bullPenView = new BullPenView(mainFrame, this.bp, this);
		this.stockView = new StockView(mainFrame, stock, this);
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		this.scrollPane = new JScrollPane();
		
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningLevelbuilder = new JLabel("Puzzle Build");
		lblLightningLevelbuilder.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton button = new JButton("Exit");
		this.exit = button;
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		JButton right = new JButton("90");
		
		JButton addhint = new JButton("Add Hint");
		
		JButton undo = new JButton("Undo");
		
		x = new JTextField();
		
		x.setColumns(10);
		
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		y = new JTextField();
		y.setColumns(10);
		
		JButton redo = new JButton("Redo");
		
		this.save = new JButton("Save");
		
		JButton delete = new JButton("Delete Square");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		btnEnter = new JButton("Enter n x m ");
				
		txtMoves = new JTextField();
		txtMoves.setColumns(10);
		
		JButton btnEnterMoves = new JButton("enter moves");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblLightningLevelbuilder, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(horizontal)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(vertical)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(right)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(addhint)))
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(undo)
								.addComponent(x, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(redo)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(y, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(save)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(delete))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnEnter)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtMoves, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEnterMoves)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningLevelbuilder)
							.addComponent(button))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(x, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEnter)
							.addComponent(txtMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEnterMoves)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(horizontal)
						.addComponent(vertical)
						.addComponent(right)
						.addComponent(addhint)
						.addComponent(delete)
						.addComponent(save)
						.addComponent(redo)
						.addComponent(undo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 10, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
		);
		
		bullPenView.addMouseListener(new BullPenController(this, bullPenView));
		stockView = new StockView(mainFrame, stock, this);
		scrollPane.setViewportView(bullPenView);
		scrollPane_1.setViewportView(stockView);
		panel.setLayout(gl_panel);
		
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		int levelCount = ((LevelBuilderFrame) mainFrame).getPuzzleLevelCount();
	
		levelCount = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		
		((LevelBuilderFrame) mainFrame).setPuzzleLevelCount(levelCount);
		

		this.getMoves = new GetMovesController(txtMoves, this);
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, this));
		btnEnterMoves.addActionListener(getMoves);
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		right.addActionListener(new RotateController(this));
		
		getEntities();
		this.save.addActionListener(new SaveController(entities, 1));
	}
	
	public void addEntity(Object addition){
		entities.add(addition);			
	}
	
	public void getEntities() {
		entities = new ArrayList<Object>();
		entities.add(bp);
		entities.add(board);
		if (getMoves.hasMoves()){
		entities.add(getMoves.getMoves());
		}
	}
	
	public BullPenView getBullPenView(){
		return this.bullPenView;
	}
	
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	public JScrollPane getScrollPane(){
		return this.scrollPane;
	}
	
}
