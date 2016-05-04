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
import Controller.GetTimeController;
import Controller.HflipController;
import Controller.HintController;
import Controller.RedoController;
import Controller.ReturnToBuilderMenuController;
import Controller.RotateController;
import Controller.SaveController;
import Controller.UndoController;
import Controller.VflipController;
import Game.Board;
import Game.BullPen;

import Game.LightningBoard;
import Game.LightningScore;
import Game.LevelModel;

import Game.Stock;
import Game.Tile;
import Game.LightningLevelModel;

/**
 * Panel to hold any edits in a lightning level in the <b> LevelBuilder. </b>
 * @author Achilles
 *
 */
public class EditLightningLevelPanel extends KabaSujiBuilder{
	
	GetTimeController getTimer; /** controller to get the Timer. **/
	ArrayList<Object> entities; /** store of entities used is the edit panel. **/
	Stack<LightningLevelModel> levelModels; /** previous level models (for undo). **/
	Stack<LightningLevelModel> redoModels;  /** level models stored for redo. **/
	
	JTextField x_text; /** x dimension of the Board. **/
	JTextField y_text; /** y dimension of the Board. **/
	JTextField time_text; /** input to the time field. **/
	
	JButton exit; /** exit button. **/
	JButton save; /** save button. **/
	JButton btnEnter; /** enter board dimensions button. **/
	JButton setTime; /** button to set the time of the level. **/
	JFrame mainFrame; /** main frame this JPanel exists within. **/
	
	BullPen bp; /** BullPen entity for the level. **/
	Stock stock; /** Stock entity for the level. **/
	LightningBoard board; /** Board entity for the level. **/
	String name; /** name of the level. **/
	BullPenView bullPenView; /** view of the BullPen. **/
	StockView stockView; /** view of the Stock. **/
	BoardView boardView; /** view of the Board. **/
	int time; /** set time for the level. **/
	JScrollPane scrollPane; /** scrollPane for the bullpen. **/
	private JTextField timeTextField; /** field for the time. **/

	
	/**
	 * create the edit lightning level panel.
	 * @param f the frame this panel exists within.
	 * @param d the Deserialization object to extract data from.
	 * @param levelNumber the number of this level.
	 */
	public EditLightningLevelPanel(JFrame f, Deserialization d, int levelNumber) {
		Tile[][] brdTiles = d.getBoard().getTiles();
	
		this.board = (LightningBoard) d.getBoard();
		this.stock = new Stock();
		this.bp = d.getBullPen();
		this.time = d.getTime();
		this.levelModels = new Stack<LightningLevelModel>();
		this.redoModels = new Stack<LightningLevelModel>();
		
		this.stockView = new StockView(mainFrame, stock, this);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
		
		
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningBuild = new JLabel("Lightning Build");
		lblLightningBuild.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton exitbtn = new JButton("Exit");
		this.exit = exitbtn;
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		JButton rightrotate = new JButton("90");
		
		JButton hint = new JButton("Add Hint");
		
		JButton undo = new JButton("Undo");
		
		x_text = new JTextField();
		x_text.setColumns(10);
				
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		y_text = new JTextField();
		y_text.setColumns(10);
		
		JButton redo = new JButton("Redo");
		
		JButton save = new JButton("Save");
		this.save = save;
		
		JButton delete = new JButton("Delete Square");
		
		JButton enter = new JButton("Enter n x m");
		this.btnEnter = enter;
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		time_text = timeTextField;
		
		JButton timebtn = new JButton("Set Time");
		setTime = timebtn;
		timebtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblLightningBuild, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(exitbtn))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(horizontal)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(vertical)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rightrotate)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hint)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(timebtn, GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
								.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(undo)
								.addComponent(x_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(y_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(enter))
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
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningBuild)
							.addComponent(exitbtn)
							.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(x_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(y_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(undo)
						.addComponent(timebtn))
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
		
		
		//activate controllers
		getEntities();
		
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.save.addActionListener(new SaveController(entities, 2));
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x_text, y_text, this));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		rightrotate.addActionListener(new RotateController(this));
		hint.addActionListener(new HintController(this));
		delete.addActionListener(new DeleteTileController(this));
		undo.addActionListener(new UndoController(mainFrame, this));
		redo.addActionListener(new RedoController(mainFrame, this));


		getTimer = new GetTimeController(time_text, this, this);
		this.setTime.addActionListener(getTimer);
	}
	
	/**
	 * Constructor used for undo and redo.
	 * @param f main frame.
	 * @param model the model to be loaded up.
	 * @param levelModels undo stack.
	 * @param redoModels redo stack.
	 */
	public EditLightningLevelPanel(JFrame f, LightningLevelModel model, Stack<LightningLevelModel> levelModels, Stack<LightningLevelModel> redoModels) {
		
		this.board = model.getLightningBoard();
		this.stock = model.getStock();
		this.bp = model.getBullPen();
		this.time = model.getTime();
		this.name = model.getName();
		this.levelModels = levelModels;
		this.redoModels = redoModels;
		
		this.stockView = new StockView(mainFrame, stock, this);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(stockView);
		
		
		this.scrollPane = new JScrollPane();
		this.bullPenView = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullPenView);
		
		this.boardView = new BoardView(mainFrame, this.board, this, bullPenView);
		
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningBuild = new JLabel("Lightning Build");
		lblLightningBuild.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton exitbtn = new JButton("Exit");
		this.exit = exitbtn;
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		JButton rightrotate = new JButton("90");
		
		JButton hint = new JButton("Add Hint");
		
		JButton undo = new JButton("Undo");
		
		x_text = new JTextField();
		x_text.setColumns(10);
		x_text.setText(((Integer)this.board.getTiles()[0].length).toString());

				
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		y_text = new JTextField();
		y_text.setColumns(10);
		y_text.setText(((Integer)this.board.getTiles().length).toString());

		
		JButton redo = new JButton("Redo");
		
		JButton save = new JButton("Save");
		this.save = save;
		
		JButton delete = new JButton("Delete Square");
		
		JButton enter = new JButton("Enter n x m");
		this.btnEnter = enter;
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		time_text = timeTextField;
		time_text.setText(((Integer)time).toString());
		
		JButton timebtn = new JButton("Set Time");
		setTime = timebtn;
		timebtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblLightningBuild, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(exitbtn))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(horizontal)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(vertical)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rightrotate)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hint)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(timebtn, GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
								.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(undo)
								.addComponent(x_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(y_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(enter))
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
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningBuild)
							.addComponent(exitbtn)
							.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(x_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(y_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(undo)
						.addComponent(timebtn))
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
		
		
		//activate controllers
		getEntities();
		
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.save.addActionListener(new SaveController(entities, 2));
		this.btnEnter.addActionListener(new GetBoardDimensionsController(x_text, y_text, this));
		this.bullPenView.addMouseListener(new BullPenController(this, bullPenView, boardView));
		this.boardView.getLabel().addMouseListener(new BoardController(this, boardView, bullPenView));
		horizontal.addActionListener(new HflipController(this));
		vertical.addActionListener(new VflipController(this));
		rightrotate.addActionListener(new RotateController(this));
		hint.addActionListener(new HintController(this));
		undo.addActionListener(new UndoController(mainFrame, this));
		redo.addActionListener(new RedoController(mainFrame, this));
		delete.addActionListener(new DeleteTileController(this));


		getTimer = new GetTimeController(time_text, this, this);
		this.setTime.addActionListener(getTimer);
	}
	
	/**
	 * collect all of the pertinent entities of this panel.
	 */
	public void getEntities() {
		entities = new ArrayList<Object>();
		entities.add(bp);
		entities.add(board);
		Tile[][] tiles = board.getTiles();
		int totalTiles = 0;
		for (int a = 0; a < tiles.length; a++){
			for (int b = 0; b < tiles[0].length; b++){
				if (tiles[a][b] != null) {totalTiles++;}
			}
		}
		entities.add(new LightningScore(totalTiles));
	}
	
	/**
	 * Adds any entity that may need to be serialized as well.
	 * @param addition Object to be serialized.
	 */
	public void addEntity(Object addition){
		entities.add(addition);			
	}
	
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	public BullPenView getBullPenView(){
		return this.bullPenView;
	}
	
	public JScrollPane getScrollPane(){
		return this.scrollPane;
	}

	public StockView getStockView() {
		return this.stockView;
	}
	
	public void setTime(int time){
		this.time = time;
	}
	
	public Stack<LightningLevelModel> getLevelModels(){
		return this.levelModels;
	}
	
	public Stack<LightningLevelModel> getRedoModels(){
		return this.redoModels;
	}
	
	/**
	 * add the current model to the stack for undo.
	 */
	public void addLevelModel(){
		System.out.println("level model pushed.");
		LightningLevelModel changedLevel = new LightningLevelModel(this.board, this.bp, this.name, null, this.stock, this.time);
		this.levelModels.push(changedLevel);
	}

	/**
	 * add the current model to the stack for redo.
	 */
	public void addModelForRedo() {
		System.out.println("level model pushed for redo purposes.");
		LightningLevelModel changedLevel = new LightningLevelModel(this.board, this.bp, this.name, null, this.stock, this.time);
		this.redoModels.push(changedLevel);
	}

	/**
	 * return the last model before undo.
	 */
	public LevelModel getLastLevelModel(){
		if (!this.levelModels.isEmpty()){
			return this.levelModels.pop();
		}
		else return null;
	}
	
	/**
	 * return the last model before redo.
	 */
	public LevelModel getLastRedoModel(){
		if (!this.redoModels.isEmpty()){
			return this.redoModels.pop();
		}
		else return null;
	}
}

