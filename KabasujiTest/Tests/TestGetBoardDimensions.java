package Tests;

import java.awt.AWTException;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Controller.GetBoardDimensionsController;
import Controller.GetMovesController;
import Game.Stock;
import junit.framework.TestCase;

public class TestGetBoardDimensions extends TestCase {

	JTextField x;
	JTextField y;
	LevelBuilderPuzzlePanel puzzlePanel;
	
	GetBoardDimensionsController gbcPuzzlePanel;
	Stock s  = new Stock();
	LevelBuilderFrame lf = new LevelBuilderFrame(s);
	
	@Override
	public void setUp(){
		x = new JTextField();
		y = new JTextField();
		x.setText("6");
		y.setText("6");
		puzzlePanel = new LevelBuilderPuzzlePanel(lf);
		gbcPuzzlePanel = new GetBoardDimensionsController(x, y, puzzlePanel);
		
	}
	
	@Override
	public void tearDown(){
	
	}
	
	public ActionEvent createPressed (int dx, int dy) {		
		ActionEvent me = new ActionEvent(lf, 0, "click");
		return me;
	}
	
	public void testController() throws AWTException{
		ActionEvent e = createPressed(0, 0);
		gbcPuzzlePanel.actionPerformed(e);
		
		int x = gbcPuzzlePanel.getXNum();
		int y = gbcPuzzlePanel.getYNum();
		
		//Ensure that the x coordinate is right
		assertEquals(x, 6);
		
		//Ensure that the y coordinate is right
		assertEquals(y, 6);
		
		
	}
	
}
