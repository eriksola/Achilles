package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.PuzzleLevelPanel;
import Game.PuzzleLevelModel;

import java.awt.BorderLayout;

/**
 * Controller to go from the default levels to the a puzzle level.
 * @author Aguila
 *
 */
public class DefLevelMenuToPuzzleLevelController implements ActionListener{

	KabasujiFrame frame;
	PuzzleLevelModel puzzleLevel;
	
	/**
	 * Creates a DefLevelMenuToPuzzleLevelController that will change to the correct panel with a given frame.
	 * @param k Frame where the game is currently held.
	 * @param plm PuzzleLevelModel that is being loaded.
	 */
	public DefLevelMenuToPuzzleLevelController(KabasujiFrame f, PuzzleLevelModel plm) {
		this.frame = f;
		this.puzzleLevel = plm;
	}
	
	/**
	 * Invoked when the button is pressed to go to a level.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		PuzzleLevelPanel puzzleLevelView = new PuzzleLevelPanel(frame, puzzleLevel);
		frame.getContentPane().add(puzzleLevelView, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}

}
