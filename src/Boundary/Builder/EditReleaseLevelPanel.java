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
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import Controller.BoardController;
import Controller.BullPenController;
import Controller.DeleteTileController;
import Controller.GetBoardDimensionsController;
import Controller.GetMovesController;
import Controller.HflipController;
import Controller.HintController;
import Controller.RedoController;
import Controller.ReleaseTileController;
import Controller.ReturnToBuilderMenuController;
import Controller.RotateController;
import Controller.SaveController;
import Controller.UndoController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;
import Game.LightningBoard;
import Game.LightningLevelModel;
import Game.ReleaseScore;
import Game.LevelModel;
import Game.PuzzleLevelModel;
import Game.Stock;
import Game.Tile;

/**
 * Panel to hold any edits in a release level in the <b> LevelBuilder. </b>
 * @author Achilles
 *
 */
public class EditReleaseLevelPanel extends KabaSujiBuilder {
	
	ArrayList<Object> entities; /** array of objects for serializing the level **/
	Stack<LevelModel> levelModels; /** stack of level models for undoing any actions **/
	Stack<LevelModel> redoModels; /** stack of level modesl for redoing any undo **/
	
	JFrame mainFrame; /** frame of the application **/
	JTextField x; /** x parameter for the board setter **/
	JTextField y; /** y parameter for the board setter **/
	JTextField numberChoice; /** number for release tile setter **/
	JComboBox<String> colChoice; /** color for release tile setter **/
	JTextField enterMovesText; /** parameter for the time setter **/
	JButton exit; /** button for exiting the release builder **/
	JButton btnEnter; /** button for setting the board **/
	JButton save; /** button for saving the release level **/
	BullPenView bullPenView; /** boundary for the bullpen **/
	StockView stockView; /** boundary for the stock **/
	BoardView boardView; /** boundary for the board **/
	JScrollPane scrollPane; /** scrollpane for the bullpen **/
	
	BullPen bp; /** the bullpen entity **/
	Stock stock; /** the stock entity **/
	Board board; /** the board entity **/
	String name; /** the name of the level **/
	
	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public EditReleaseLevelPanel(JFrame f, Deserialization d, int levelNumber) {

		this.mainFrame = f;
		this.levelModels = new Stack<LevelModel>();
		this.redoModels = new Stack<LevelModel>();
		this.board = d.getBoard();
		this.stock = new Stock();
		this.bp = d.getBullPen();
		
		this.stockView = new StockView(mainFrame, stock, this);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
		
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
				
		setBackground(new Color(173, 216, 230));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningLevelbuilder = new JLabel("Release Build");
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
		
		this.numberChoice = new JTextField();
		numberChoice.setColumns(10);
		
		JButton releaseTileBtn = new JButton("ColorNum");
		releaseTileBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		String[] colors = {"red", "yellow", "green"};
		this.colChoice = new JComboBox<String>(colors);
		
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
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(releaseTileBtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(colChoice, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(numberChoice, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(4))))
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
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
								.addComponent(btnEnter))
							.addGap(77))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
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
							.addComponent(numberChoice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(colChoice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(releaseTileBtn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 12, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, this));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		right.addActionListener(new RotateController(this));
		addhint.addActionListener(new HintController(this));
		undo.addActionListener(new UndoController(mainFrame, this));
		redo.addActionListener(new RedoController(mainFrame, this));
		getEntities();
		this.save.addActionListener(new SaveController(entities, 3));
		delete.addActionListener(new DeleteTileController(this));
		releaseTileBtn.addActionListener(new ReleaseTileController(this, colChoice, numberChoice));
		
		int levelCount = ((LevelBuilderFrame) mainFrame).getReleaseLevelCount();
		levelCount = new File("./src/BuiltLevels/ReleaseLevels").list().length;
		((LevelBuilderFrame) mainFrame).setReleaseLevelCount(levelCount);
	}
	
	/**
	 * constructor for undoing/redoing moves
	 * @param f the frame of the application
	 * @param model the level model after the undo/redo
	 * @param levelModels stack of undo models
	 * @param redoModels stack of redo models
	 */
	public EditReleaseLevelPanel(JFrame f, LevelModel model, Stack<LevelModel> levelModels, Stack<LevelModel> redoModels) {
		
		this.mainFrame = f;
		this.levelModels = levelModels;
		this.redoModels = redoModels;
		this.name = model.getName();
		this.board = model.getBoard();
		this.stock = model.getStock();
		this.bp = model.getBullPen();
		
		//WINDOW BUILDER
		this.stockView = new StockView(mainFrame, stock, this);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
		
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
				
		setBackground(new Color(173, 216, 230));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningLevelbuilder = new JLabel("Release Build");
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
		
		this.numberChoice = new JTextField();
		numberChoice.setColumns(10);
		
		JButton releaseTileBtn = new JButton("ColorNum");
		releaseTileBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		String[] colors = {"red", "yellow", "green"};
		this.colChoice = new JComboBox<String>(colors);
		
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
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(releaseTileBtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(colChoice, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(numberChoice, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(4))))
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
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
								.addComponent(btnEnter))
							.addGap(77))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
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
							.addComponent(numberChoice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(colChoice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(releaseTileBtn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 12, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x, y, this));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		right.addActionListener(new RotateController(this));
		addhint.addActionListener(new HintController(this));
		undo.addActionListener(new UndoController(mainFrame, this));
		redo.addActionListener(new RedoController(mainFrame, this));
		getEntities();
		this.save.addActionListener(new SaveController(entities, 3));
		delete.addActionListener(new DeleteTileController(this));
		releaseTileBtn.addActionListener(new ReleaseTileController(this, colChoice, numberChoice));
		
		int levelCount = ((LevelBuilderFrame) mainFrame).getReleaseLevelCount();
		levelCount = new File("./src/BuiltLevels/ReleaseLevels").list().length;
		((LevelBuilderFrame) mainFrame).setReleaseLevelCount(levelCount);		
		}
	
	/**
	 * gets the entities for the save controller
	 */
	public void getEntities() {
		entities = new ArrayList<Object>();
		entities.add(bp);
		entities.add(board);
		entities.add(new ReleaseScore());
	}
	
	/**
	 * Adds any entity that may need to be serialized as well.
	 * @param addition Object to be serialized.
	 */
	public void addEntity(Object addition){
		entities.add(addition);			
	}
	
	/**
	 * return the boardView
	 */
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	/**
	 * return the bullPenView
	 */
	public BullPenView getBullPenView(){
		return this.bullPenView;
	}
	
	/**
	 * return the scrollpane of the bullpenView
	 */
	public JScrollPane getScrollPane(){
		return this.scrollPane;
	}
	
	/** 
	 * returns the stack of undo models
	 * @return stack of undo models
	 */
	public Stack<LevelModel> getLevelModels(){
		return this.levelModels;
	}
	
	/**
	 * returns the stack of redo models
	 * @return stack of redo models
	 */
	public Stack<LevelModel> getRedoModels(){
		return this.redoModels;
	}
	
	/**
	 * adds a level model to the stack of undo models
	 */
	public void addLevelModel(){
		System.out.println("level model pushed.");
		LevelModel changedLevel = new LevelModel(this.board, this.bp, this.name, null, this.stock);
		this.levelModels.push(changedLevel);
	}
	
	/**
	 * adds a level model to the stack of redo models
	 */
	public void addModelForRedo() {
		System.out.println("level model pushed for redo purposes.");
		LevelModel changedLevel = new LevelModel(this.board, this.bp, this.name, null, this.stock);
		this.redoModels.push(changedLevel);
	}
	
	/**
	 * returns the most recent undo model
	 */
	public LevelModel getLastLevelModel(){
		if (!this.levelModels.isEmpty()){
			return this.levelModels.pop();
		}
		else return null;
	}
	
	/**
	 * returns the most recent redo model
	 */
	public LevelModel getLastRedoModel(){
		if (!this.redoModels.isEmpty()){
			return this.redoModels.pop();
		}
		else return null;
	}

	@Override
	/**
	 * returns the stockView
	 */
	public StockView getStockView() {
		return this.stockView;
	}

}

