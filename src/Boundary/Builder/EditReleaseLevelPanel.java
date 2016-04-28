package Boundary.Builder;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.Deserialization;
import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Both.StockView;
import Controller.BullPenController;
import Controller.GetBoardDimensionsController;
import Controller.GetMovesController;
import Controller.HflipController;
import Controller.ReturnToBuilderMenuController;
import Controller.RotateController;
import Controller.SaveController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.Stock;
import Game.Tile;

public class EditReleaseLevelPanel extends KabaSuji {
	
	ArrayList<Object> entities;
	
	JTextField x;
	JTextField y;
	JTextField enterMovesText;
	JFrame mainFrame;
	JButton exit;
	JButton btnEnter;
	JButton save;
	int levelNum;
	int numMoves;
	
	BullPen bp;
	Stock stock;
	Board board;
	
	BullPenView bullPenView;
	StockView stockView;
	BoardView boardView;
	JScrollPane scrollPane;
	JTextField entertext;
	/**
	 * Create the panel.
	 */
	public EditReleaseLevelPanel(JFrame f, Deserialization d, int levelNumber) {
		Tile[][] brdTiles = d.getBoard().getTiles();
		
		this.levelNum = levelNumber;
		this.board = d.getBoard();
		this.stock = new Stock();
		this.bp = d.getBullPen();
		this.numMoves = d.getNumMoves();
		this.stockView = new StockView(mainFrame, stock, this);
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullPenView);
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
		
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningLevelbuilder = new JLabel("Release Build");
		lblLightningLevelbuilder.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton exitbtn = new JButton("Exit");
		this.exit = exitbtn;
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		JButton rightrotate = new JButton("90");
		
		JButton hint = new JButton("Add Hint");
						
		JButton undo = new JButton("Undo");
		
		x = new JTextField();
		x.setColumns(10);
		
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		y = new JTextField();
		y.setColumns(10);
		
		JButton redo = new JButton("Redo");
		
		JButton save = new JButton("Save");
		this.save = save;
		
		JButton delete = new JButton("Delete Square");
		
		JButton enter = new JButton("Enter n x m");
		this.btnEnter = enter;
		
		entertext = new JTextField();
		entertext.setColumns(10);
	
		
		JButton btnEnterMoves = new JButton("Enter moves");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblLightningLevelbuilder, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(exitbtn))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(horizontal)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(vertical)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rightrotate)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(hint)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(undo)
								.addComponent(x, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(y, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(enter)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(entertext, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(btnEnterMoves, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(redo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(save)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(delete))))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(1)
								.addComponent(entertext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnEnterMoves))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningLevelbuilder)
							.addComponent(exitbtn))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(x, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(enter)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(horizontal)
						.addComponent(vertical)
						.addComponent(rightrotate)
						.addComponent(hint)
						.addComponent(delete)
						.addComponent(save)
						.addComponent(redo)
						.addComponent(undo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 10, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)))
		);
		

		panel.setLayout(gl_panel);

		getEntities();
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.save.addActionListener(new SaveController(entities, 3));
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, this));
		btnEnterMoves.addActionListener(new GetMovesController(entertext, this));
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		rightrotate.addActionListener(new RotateController(this));
		
		}
	
	public void getEntities() {
		entities = new ArrayList<Object>();
		entities.add(bp);
		entities.add(board);
	}
	
	public void addEntity(Object addition){
		entities.add(addition);			
	}
	
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	public JScrollPane getScrollPane(){
		return this.scrollPane;
	}

}

