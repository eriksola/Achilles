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
import Boundary.Both.PieceView;
import Boundary.Both.StockView;
import Controller.BoardController;
import Controller.BullPenController;
import Controller.DeleteTileController;
import Controller.GetMovesController;
import Controller.GetBoardDimensionsController;
import Controller.HflipController;
import Controller.HintController;
import Controller.RedoController;
import Controller.RotateController;
import Controller.SaveController;
import Controller.UndoController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.Piece;
import Game.PuzzleScore;
import Game.PuzzleLevelModel;
import Game.Stock;
import Game.Tile;
import Controller.ReturnToBuilderMenuController;

import java.awt.event.InputMethodListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.InputMethodEvent;

/**
 * Panel for a Puzzle level type to be built in the <b> LevelBuilder. </b>
 * @author Achilles
 *
 */
public class LevelBuilderPuzzlePanel extends KabaSujiBuilder {
	
	ArrayList<Object> entities; /** array of objects for serializing the level **/
	Stack<PuzzleLevelModel> levelModels; /** stack of level models for undoing any actions **/
	Stack<PuzzleLevelModel> redoModels; /** stack of level models for redoing any undo **/
	
	JFrame mainFrame; /** frame of the application **/
	JTextField x; /** x parameter for the board setter **/
	JTextField y; /** y parameter for the board setter **/
	JButton exit; /** button for exiting the lightning builder **/
	JButton btnEnter; /** button for setting the board **/
	JButton save; /** button for saving the lightning level **/
	BullPenView bullPenView; /** boundary for the bullpen **/
	BoardView boardView; /** boundary for the board **/
	StockView stockView; /** boundary for the stock **/
	JScrollPane scrollPane; /** scrollpane of the bullpen **/
	JTextField txtMoves; /** parameter for the move setter **/
	JButton btnMoves; /** button for setting the number of moves **/
	
	GetMovesController movesController; /** controller for the move setter **/
	
	BullPen bp; /** the bullpen entity **/
	Board board; /**the board entity **/
	Stock stock; /**the stock entity **/
	String name; /** the name of the level **/
	int numMoves; /** the number of moves allowed **/
	
	/**
	 * Create the panel.
	 */
	public LevelBuilderPuzzlePanel(JFrame f) {
		
		this.mainFrame = f;
		this.stock = new Stock();
		//start with empty 10x10 board
		Tile[][] brdTiles = new Tile[10][10];
		for (int i = 0; i < brdTiles.length; i++) {
			for (int j = 0; j < brdTiles[0].length; j++) {
				brdTiles[i][j] = new Tile(i, j);
			}
		}
		this.board = new Board(brdTiles);
		this.bp = new BullPen();
		this.levelModels = new Stack<PuzzleLevelModel>();
		this.redoModels = new Stack<PuzzleLevelModel>();
		
		//WINDOW BUILDER
		this.stockView = new StockView(mainFrame, stock, this);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
		
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, this.bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		
		setBackground(new Color(173, 216, 230));

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
		
		btnEnter = new JButton("Enter n x m ");
				
		txtMoves = new JTextField();
		txtMoves.setColumns(10);
		
		this.btnMoves = new JButton("enter moves");
		
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
									.addComponent(btnMoves)))
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
							.addComponent(btnMoves)))
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
		
		panel.setLayout(gl_panel);
		
		//activate controllers
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.movesController = new GetMovesController(txtMoves, this);
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, this));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		btnMoves.addActionListener(movesController);
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		right.addActionListener(new RotateController(this));
		addhint.addActionListener(new HintController(this));
		undo.addActionListener(new UndoController(mainFrame, this));
		redo.addActionListener(new RedoController(mainFrame, this));
		getEntities();
		this.save.addActionListener(new SaveController(entities, 1));
		delete.addActionListener(new DeleteTileController(this));
		
		int levelCount = ((LevelBuilderFrame) mainFrame).getPuzzleLevelCount();
		levelCount = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		((LevelBuilderFrame) mainFrame).setPuzzleLevelCount(levelCount);
	}
	
	public LevelBuilderPuzzlePanel(JFrame frame, PuzzleLevelModel model, Stack<PuzzleLevelModel> prevMoves, Stack<PuzzleLevelModel>	redoMoves){
		
		this.mainFrame = frame;	
		this.name = model.getName();
		this.board = model.getBoard();
		this.bp = model.getBullPen();
		this.stock = model.getStock();
		this.numMoves = model.getMovesAllowed();
		this.levelModels = prevMoves;
		this.redoModels = redoMoves;
		
		//WINDOW BUILDER
		this.stockView = new StockView(mainFrame, this.stock, this);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
	
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, this.bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		
		setBackground(new Color(173, 216, 230));

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
		x.setText(((Integer)this.board.getTiles()[0].length).toString());
		
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		y = new JTextField();
		y.setColumns(10);
		y.setText(((Integer)this.board.getTiles().length).toString());

		
		JButton redo = new JButton("Redo");
		
		this.save = new JButton("Save");
		
		JButton delete = new JButton("Delete Square");
		
		this.btnEnter = new JButton("Enter n x m ");
				
		this.txtMoves = new JTextField();
		txtMoves.setColumns(10);
		txtMoves.setText(((Integer)numMoves).toString());
		
		this.btnMoves = new JButton("enter moves");
		
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
									.addComponent(btnMoves)))
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
							.addComponent(btnMoves)))
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
		panel.setLayout(gl_panel);
		
		//activate controllers
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		delete.addActionListener(new DeleteTileController(this));
		this.movesController = new GetMovesController(txtMoves, this);
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, this));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		this.btnMoves.addActionListener(movesController);
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		right.addActionListener(new RotateController(this));
		addhint.addActionListener(new HintController(this));
		undo.addActionListener(new UndoController(mainFrame, this));
		redo.addActionListener(new RedoController(mainFrame, this));
		getEntities();
		this.save.addActionListener(new SaveController(entities, 1));
		
		int levelCount = ((LevelBuilderFrame) mainFrame).getPuzzleLevelCount();
		levelCount = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		((LevelBuilderFrame) mainFrame).setPuzzleLevelCount(levelCount);
	}
	
	/**
	 * Adds any entity that may need to be serialized as well.
	 * @param addition Object to be serialized.
	 */
	public void addEntity(Object addition){
		entities.add(addition);			
	}
	
	/**
	 * gets the entities for the save controller
	 */
	public void getEntities() {
		entities = new ArrayList<Object>();
		entities.add(bp);
		entities.add(board);
	}
	
	/**
	 * getter function for the bullpenview
	 */
	public BullPenView getBullPenView(){
		return this.bullPenView;
	}

	/**
	 * getter function for the boardview
	 */
	public BoardView getBoardView(){
		return this.boardView;
	}

	/**
	 * getter function for the scrollpane of the bullpenview
	 */
	public JScrollPane getScrollPane(){
		return this.scrollPane;
	}
	
	/**
	 * getter function for the stockview
	 */
	public StockView getStockView() {
		return this.stockView;
	}

	/**
	 * setter function for the number of moves
	 * @param time new number of moves allowed
	 */
	public void setNumMoves(int numMoves){
		this.numMoves = numMoves;
	}
	
	/**
	 * getter function for the undo models
	 * @return undo models
	 */
	public Stack<PuzzleLevelModel> getLevelModels(){
		return this.levelModels;
	}

	/**
	 * getter function for the redo models
	 * @return redo models
	 */
	public Stack<PuzzleLevelModel> getRedoModels(){
		return this.redoModels;
	}

	/**
	 * adds a level model to the stack of undo models
	 */
	public void addLevelModel(){
		System.out.println("level model pushed.");
		PuzzleLevelModel changedLevel = new PuzzleLevelModel(this.board, this.bp, this.name, null, this.stock, this.numMoves);
		this.levelModels.push(changedLevel);
	}

	/** 
	 * adds a level model to the stack of redo models
	 */
	public void addModelForRedo(){
		System.out.println("level model pushed for redo purpose.");
		PuzzleLevelModel changedLevel = new PuzzleLevelModel(this.board, this.bp, this.name, null, this.stock, this.numMoves);
		this.redoModels.push(changedLevel);
	}

	/**
	 * gets the last undo model
	 */
	public LevelModel getLastLevelModel(){
		if (!this.levelModels.isEmpty()){
			return this.levelModels.pop();
		}
		else return null;
	}

	/**
	 * gets the last redo model
	 */
	public LevelModel getLastRedoModel(){
		if (!this.redoModels.isEmpty()){
			return this.redoModels.pop();
		}
		else return null;
	}
}
