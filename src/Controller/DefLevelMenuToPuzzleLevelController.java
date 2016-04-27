package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.PuzzleLevelPanel;

import java.awt.BorderLayout;

public class DefLevelMenuToPuzzleLevelController implements ActionListener{

	KabasujiFrame frame;
	
	public DefLevelMenuToPuzzleLevelController(KabasujiFrame f) {
		this.frame = f;
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		PuzzleLevelPanel puzzleLevel = new PuzzleLevelPanel(frame, null);
		frame.getContentPane().add(puzzleLevel, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}

}
