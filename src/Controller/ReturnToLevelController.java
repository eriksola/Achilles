package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.KabasujiFrame;
import Boundary.PuzzleLevelPanel;

public class ReturnToLevelController implements ActionListener{
	KabasujiFrame frame;

	
	ReturnToLevelController(KabasujiFrame kf){
		this.frame = kf;
	}

	public void actionPerformed(ActionEvent e) {
		
		//remove the rules menu JPanel from the JFrame
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// return the main menu JPanel to the JFrame
		PuzzleLevelPanel puzzleLvl = new PuzzleLevelPanel(frame, null);
		frame.getContentPane().add(puzzleLvl, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}
}
