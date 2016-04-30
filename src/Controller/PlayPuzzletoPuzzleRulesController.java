package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.RulesPuzzle;

/**
 * Controller to bring a player from a to the puzzle rules.
 * @author Achilles
 *
 */
public class PlayPuzzletoPuzzleRulesController implements ActionListener{
	
	KabasujiFrame frame;
	
	/**
	 * Creates a PlayPuzzletoPuzzleRulesController that will change to the correct panel with a given frame.
	 * @param kf Frame where the game is currently held.
	 */	
	public PlayPuzzletoPuzzleRulesController(KabasujiFrame f) {
		this.frame = f;
	}
	
	
	/**
	 * Invoked when the button is pressed to see the rules for a level.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		RulesPuzzle rules = new RulesPuzzle(frame);
		frame.getContentPane().add(rules, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
		// set controller for previous button
		rules.getGameButton().addActionListener(new ReturnToLevelController(frame));
	}	
}
