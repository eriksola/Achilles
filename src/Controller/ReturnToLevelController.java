package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.PuzzleLevelPanel;

/**
 * Controller to return a player to a level.
 * @author Aguila
 *
 */
public class ReturnToLevelController implements ActionListener{
	KabasujiFrame frame;

	/**
	 * Creates a ReturnToLevelController that will change to the correct panel with a given frame.
	 * @param kf Frame where the game is currently held.
	 */	
	ReturnToLevelController(KabasujiFrame kf){
		this.frame = kf;
	}

	/**
	 * Invoked when the button is pressed to return to the level.
	 */
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
