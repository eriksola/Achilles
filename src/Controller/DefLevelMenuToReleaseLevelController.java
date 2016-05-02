package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.PuzzleLevelPanel;
import Boundary.Player.ReleaseLevelPanel;
import Game.LevelModel;

import java.awt.BorderLayout;

/**
 * Controller to go from the default levels to the a puzzle level.
 * @author Aguila
 *
 */
public class DefLevelMenuToReleaseLevelController implements ActionListener{

	KabasujiFrame frame;
	LevelModel releaseLevel;
	
	/**
	 * Creates a DefLevelMenuToPuzzleLevelController that will change to the correct panel with a given frame.
	 * @param k Frame where the game is currently held.
	 * @param plm PuzzleLevelModel that is being loaded.
	 */
	public DefLevelMenuToReleaseLevelController(KabasujiFrame f, LevelModel lm) {
		this.frame = f;
		this.releaseLevel = lm;
	}
	
	/**
	 * Invoked when the button is pressed to go to a level.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		ReleaseLevelPanel releaseLevelView = new ReleaseLevelPanel(frame, releaseLevel);
		frame.getContentPane().add(releaseLevelView, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}

}