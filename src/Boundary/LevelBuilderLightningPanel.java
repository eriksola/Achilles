package Boundary;

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

import Controller.BullPenController;
import Controller.GetMovesController;
import Controller.GetTimeController;
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


public class LevelBuilderLightningPanel extends KabaSuji {
	
	
	ArrayList<Object> entities;
	
	GetTimeController getTimer;
	
	BullPen bp;
	Stock stock;
	Board board;
	
	JTextField x;
	JTextField y;
	JTextField time;
	
	JButton exit;
	JButton btnEnter;
	JButton save;
	JButton btnTime;
	
	BullPenView bullpen;
	BoardView boardView;
	StockView stockView;

	JFrame mainFrame;
	private JTextField txtMoves;
	
	JScrollPane scrollPane;
	private JTextField time_text;
	/**
	 * Create the panel.
	 */
	public LevelBuilderLightningPanel(JFrame f) {
		Tile[][] brdTiles = new Tile[10][10];
		//start board empty
		for (int i = 0; i < brdTiles.length; i++) {
			for (int j = 0; j < brdTiles[0].length; j++) {
				brdTiles[i][j] = new Tile(false, i, j);
			}
		}
		this.bp = new BullPen();
		this.board = new Board(brdTiles);
		this.stock = new Stock();
		
		
		//WINDOW BUILDER
		this.bullpen = new BullPenView(mainFrame, bp, this);
		this.stockView = new StockView(mainFrame, stock, this);
		this.boardView = new BoardView(mainFrame, this.board, this, bullpen);
		this.scrollPane = new JScrollPane();
		
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningLevelbuilder = new JLabel("Lightning Build");
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
		
		time_text = new JTextField();
		time_text.setColumns(10);
		time = time_text;
		
		JButton timerBtn = new JButton("Set Time");
		btnTime = timerBtn;
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
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
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(timerBtn)
								.addComponent(time_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
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
									.addComponent(btnEnterMoves))))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningLevelbuilder)
							.addComponent(button)
							.addComponent(time_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(undo)
						.addComponent(timerBtn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 12, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
		);
		
		bullpen.addMouseListener(new BullPenController(this, bullpen));
		stockView = new StockView(mainFrame, stock, this);
		scrollPane.setViewportView(bullpen);
		scrollPane_1.setViewportView(stockView);
		panel.setLayout(gl_panel);
		
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		int levelCount = ((LevelBuilderFrame) mainFrame).getLightningLevelCount();
		
		getEntities();
		this.save.addActionListener(new SaveController(entities, 2));
		
		
		levelCount = new File("./src/BuiltLevels/LightningLevels").list().length;
		
		((LevelBuilderFrame) mainFrame).setLightningLevelCount(levelCount);
		
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, boardView));
		btnEnterMoves.addActionListener(new GetMovesController(txtMoves));
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		right.addActionListener(new RotateController(this));
		getTimer = new GetTimeController(time_text, this);
		this.btnTime.addActionListener(getTimer);
		
	}
	
	public void getEntities() {
		entities = new ArrayList<Object>();
		entities.add(bp);
		entities.add(board);
		entities.add(stock);
		
	}
	
	public void addEntity(Object addition){
		entities.add(addition);			
	}
	
	public BullPenView getBullPenView(){
		return this.bullpen;
	}
	
	public JScrollPane getScrollPane(){
		return this.scrollPane;
	}
	
}
