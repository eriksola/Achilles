package Boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class DefLevelMenuToPuzzleLevelController implements ActionListener{

	KabasujiFrame frame;
	
	public DefLevelMenuToPuzzleLevelController(KabasujiFrame f) {
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		PuzzleLevelPanel puzzleLevel = new PuzzleLevelPanel(frame);
		frame.getContentPane().add(puzzleLevel, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}

}
