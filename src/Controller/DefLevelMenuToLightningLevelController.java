package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.LightningLevelPanel;
import Boundary.Player.PuzzleLevelPanel;
import Game.LightningLevelModel;
import Game.PuzzleLevelModel;

public class DefLevelMenuToLightningLevelController implements ActionListener {


	KabasujiFrame frame;
	LightningLevelModel lightLevel;
	
	public DefLevelMenuToLightningLevelController(KabasujiFrame f, LightningLevelModel llm) {
		this.frame = f;
		this.lightLevel = llm;
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		LightningLevelPanel lightningLevelView = new LightningLevelPanel(frame, lightLevel);
		frame.getContentPane().add(lightningLevelView, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}
}
