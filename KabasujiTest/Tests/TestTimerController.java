package Tests;

import java.awt.AWTException;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.LightningLevelPanel;
import Controller.TimerController;
import Game.Board;
import Game.BullPen;
import Game.IScore;
import Game.LightningBoard;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestTimerController extends TestCase {
	Tile[][] t = new Tile[6][6];
	Board board = new Board(t);
	KabasujiFrame frame = new KabasujiFrame();
	LightningLevelPanel lp;
	
	JTextArea ta;
	TimerController timeController;
	
	BullPen bp;
	IScore lScore;
	LightningLevelModel model;
	
	@Override
	public void setUp(){
		ta = new JTextArea();
		bp = new BullPen();
		lScore = new LightningScore(7);
		String name = "lightning";
		model  = new LightningLevelModel((LightningBoard) board, bp, name, lScore, new Stock(), 100);
		lp = new LightningLevelPanel(frame, model);
		timeController = new TimerController(frame, lp, ta, 100);
	}
	
	
	public ActionEvent createPressed (int dx, int dy) {		
		ActionEvent me = new ActionEvent(frame, 0, "click");
		
		return me;
	}
	
	
	public void testTimer() throws AWTException{
		ActionEvent e = createPressed(0, 0);
		timeController.actionPerformed(e);
		
	}
}
