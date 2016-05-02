package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.LightningLevelPanel;
import Boundary.Player.PuzzleLevelPanel;
import Boundary.Player.ReleaseLevelPanel;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.PuzzleLevelModel;

public class LevelPlayerController implements ActionListener{


	KabasujiFrame frame;
	LevelModel level;
	
	/**
	 * Creates a DefLevelMenuToLightningLevelController that will change to the correct panel with a given frame.
	 * @param k Frame where the game is currently held.
	 * @param plm LightningLevelModel that is being loaded.
	 */
	public LevelPlayerController(KabasujiFrame f, LevelModel level) {
		this.frame = f;
		this.level = level;
	}
	
	/**
	 * Invoked when the button is pressed to go to a level.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		if (level instanceof PuzzleLevelModel){
			System.out.println("Loaded a puzzle level");
			PuzzleLevelPanel puzzlePanel = new PuzzleLevelPanel(frame, (PuzzleLevelModel) level);
			frame.getContentPane().add(puzzlePanel, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		
		if (level instanceof LightningLevelModel){
			System.out.println("Loaded a lightning level");
			LightningLevelPanel lightningPanel = new LightningLevelPanel(frame, (LightningLevelModel) level);
			frame.getContentPane().add(lightningPanel, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		
		else {
			System.out.println("Loaded a release level");
			ReleaseLevelPanel releasePanel = new ReleaseLevelPanel(frame, level);
			frame.getContentPane().add(releasePanel, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
	}
}
