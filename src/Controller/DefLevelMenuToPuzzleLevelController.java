package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.PuzzleLevelPanel;
import Game.PuzzleLevelModel;

import java.awt.BorderLayout;

public class DefLevelMenuToPuzzleLevelController implements ActionListener{

	KabasujiFrame frame;
	PuzzleLevelModel puzzleLevel;
	
	public DefLevelMenuToPuzzleLevelController(KabasujiFrame f, PuzzleLevelModel plm) {
		this.frame = f;
		this.puzzleLevel = plm;
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		PuzzleLevelPanel puzzleLevelView = new PuzzleLevelPanel(frame, puzzleLevel);
		frame.getContentPane().add(puzzleLevelView, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}

}
