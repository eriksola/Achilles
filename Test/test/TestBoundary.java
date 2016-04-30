package test;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderLightningPanel;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Builder.LevelBuilderReleasePanel;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import junit.framework.TestCase;

public class TestBoundary extends TestCase {
	Stock s = new Stock();
	final LevelBuilderFrame frame = new LevelBuilderFrame(s);
	
	/*
	public void setUp(){
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}      
		});
	}
	*/
	
	public void testPuzzleButton(){
		JButton puzzleButton = (JButton)TestUtils.getChildNamed(frame, "Puzzle");
		MouseEvent me = new MouseEvent(frame.getContentPane(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, puzzleButton.getX() + 10, puzzleButton.getY() + 10,
				1, false);
		assertTrue(frame.getContentPane() instanceof LevelBuilderPuzzlePanel);
		
	}
	

}
