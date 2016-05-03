package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import Boundary.Builder.EditPuzzleLevelPanel;
import Boundary.Builder.EditReleaseLevelPanel;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Builder.LevelBuilderReleasePanel;
import Controller.GetMovesController;
import Controller.SaveController;
import Game.Stock;
import junit.framework.TestCase;


public class TestGetMovesController extends TestCase {
	
	JTextField t;
	LevelBuilderPuzzlePanel puzzlePanel;
	
	GetMovesController gmcPuzzlePanel;
	Stock s  = new Stock();
	LevelBuilderFrame lf = new LevelBuilderFrame(s);
	
	@Override
	public void setUp(){
		t = new JTextField();
		t.setText("3");
		puzzlePanel = new LevelBuilderPuzzlePanel(lf);
		gmcPuzzlePanel = new GetMovesController(t, puzzlePanel);
		
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
		gmcPuzzlePanel.actionPerformed(e);
		
		int puzzleMoves = gmcPuzzlePanel.getMoves();
		
		assertEquals(puzzleMoves, 3);
	}
	
}
