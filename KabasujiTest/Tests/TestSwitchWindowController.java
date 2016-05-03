package Tests;

import java.awt.AWTException;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import Boundary.Builder.LevelBuilderBuiltLevelPanel;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderMainMenuPanel;
import Boundary.Player.BuiltLevelPanel;
import Boundary.Player.DefaultLevelPanel;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.RulesMenuPanel;
import Controller.SwitchWindowController;
import Game.Board;
import Game.BullPen;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestSwitchWindowController extends TestCase {

	BullPen bp = new BullPen();
	Tile[][] t = new Tile[6][6];
	Board board = new Board(t);
	Stock s = new Stock();
	KabasujiFrame kf = new KabasujiFrame();
	LevelBuilderFrame lf = new LevelBuilderFrame(s);
	
	DefaultLevelPanel defaultLevelPanel;
	SwitchWindowController swcDefaultPanel;
	
	RulesMenuPanel rulesPanel;
	SwitchWindowController swcRulesPanel;
	
	BuiltLevelPanel builtPanel;
	SwitchWindowController swcBuiltPanel;
	
	LevelBuilderMainMenuPanel levelBuilderMainPanel;
	SwitchWindowController swcBuilderMainPanel;
	
	LevelBuilderBuiltLevelPanel levelBuilderBuiltPanel;
	SwitchWindowController swcBuilditBuitltPanel;
	
	
	@Override
	public void setUp(){
		defaultLevelPanel = new DefaultLevelPanel(kf);
		swcDefaultPanel = new SwitchWindowController(kf, defaultLevelPanel);
		
		rulesPanel = new RulesMenuPanel(kf);
		swcRulesPanel = new SwitchWindowController(kf, rulesPanel);
		
		builtPanel = new BuiltLevelPanel(kf);
		swcBuiltPanel = new SwitchWindowController(kf, builtPanel);
		
		levelBuilderMainPanel = new LevelBuilderMainMenuPanel(lf);
		swcBuilderMainPanel = new SwitchWindowController(lf, levelBuilderMainPanel);

		levelBuilderBuiltPanel = new LevelBuilderBuiltLevelPanel(lf);
		swcBuilditBuitltPanel = new SwitchWindowController(lf, levelBuilderBuiltPanel);
		
	}
	
	@Override
	public void tearDown(){
	
	}
	
	public ActionEvent createPressed (int dx, int dy) {		
		ActionEvent me = new ActionEvent(kf, 0, "click");
		
		return me;
	}
	
	public void testController() throws AWTException{
		ActionEvent e = createPressed(0, 0);

		swcDefaultPanel.actionPerformed(e);
		swcRulesPanel.actionPerformed(e);
		swcBuiltPanel.actionPerformed(e);
		swcBuilderMainPanel.actionPerformed(e);
		swcBuilditBuitltPanel.actionPerformed(e);
	}
	
}


