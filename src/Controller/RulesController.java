package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabaSujiPlayer;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.RulesLightning;
import Boundary.Player.RulesPuzzle;
import Boundary.Player.RulesRelease;
import Game.LevelModel;

public class RulesController implements ActionListener{
	
	KabasujiFrame frame;
	KabaSujiPlayer view;
	LevelModel initModel;
	int levelType;
	
	/**
	 * Creates a PlayPuzzletoPuzzleRulesController that will change to the correct panel with a given frame.
	 * @param kf Frame where the game is currently held.
	 */	
	public RulesController(KabasujiFrame f, KabaSujiPlayer view, LevelModel level, int levelType) {
		this.frame = f;
		this.view = view;
		this.initModel = level;
		this.levelType = levelType;
	}
	
	
	/**
	 * Invoked when the button is pressed to see the rules for a level.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		if (levelType == 1){
			RulesPuzzle p = new RulesPuzzle(frame, initModel);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if (levelType == 2){
			RulesLightning p = new RulesLightning(frame, initModel);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if (levelType == 3){
			RulesRelease p = new RulesRelease(frame, initModel);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
	}	
}
