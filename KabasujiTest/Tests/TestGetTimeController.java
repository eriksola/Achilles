package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.JTextField;

import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderLightningPanel;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Controller.GetTimeController;
import Game.Stock;
import junit.framework.TestCase;

public class TestGetTimeController extends TestCase {

	JTextField t;
	LevelBuilderLightningPanel lightningPanel;
	
	GetTimeController time;
	Stock s  = new Stock();
	LevelBuilderFrame lf = new LevelBuilderFrame(s);
	
	@Override
	public void setUp(){
		t = new JTextField();
		t.setText("100");
		lightningPanel = new LevelBuilderLightningPanel(lf);
		time = new GetTimeController(t, lightningPanel, lightningPanel);
		
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
		time.actionPerformed(e);
		
		int timeEntered = time.getTime();
		
		assertEquals(timeEntered, 100);
	}
	
}

