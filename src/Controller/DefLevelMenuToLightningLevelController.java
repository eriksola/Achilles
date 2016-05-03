package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.LightningLevelPanel;
import Boundary.Player.PuzzleLevelPanel;
import Game.LightningLevelModel;
import Game.PuzzleLevelModel;

/**
 * Controller to go from the default levels to the a puzzle level.
 * @author Aguila
 *
 */
public class DefLevelMenuToLightningLevelController implements ActionListener {


	KabasujiFrame frame;
	LightningLevelModel lightLevel;
	
	/**
	 * Creates a DefLevelMenuToLightningLevelController that will change to the correct panel with a given frame.
	 * @param k Frame where the game is currently held.
	 * @param plm LightningLevelModel that is being loaded.
	 */
	public DefLevelMenuToLightningLevelController(KabasujiFrame f, LightningLevelModel llm) {
		this.frame = f;
		this.lightLevel = llm;
	}
	
	/**	
	 * Invoked when the button is pressed to go to a level.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		LightningLevelPanel lightningLevelView = new LightningLevelPanel(frame, lightLevel);
		frame.getContentPane().add(lightningLevelView, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}
}
