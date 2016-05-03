package Boundary.Player;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import Controller.DefLevelMenuToLightningLevelController;
import Controller.LevelPlayerController;
import Controller.ReturnToPlayerMenuController;
import Game.IScore;
import Game.LevelModel;

public class LevelEndPanel extends JPanel {

	KabasujiFrame playerFrame;
	LevelModel initialModel;
	IScore currentScore;
	
	StarView starView;
	
	/**
	 * Create the starView.
	 */
	public LevelEndPanel(KabasujiFrame frame, LevelModel level, IScore score) {

		this.playerFrame = frame;
		this.initialModel = level;
		this.currentScore = score;
		
		int initStars = initialModel.getScore().scoreToStars();
		int currentStars = currentScore.scoreToStars();
		
		//if the new score is better, set is as the new top score
		if (currentStars > initStars){
			initialModel.setScore(currentScore);
			
		}
		
		setBackground(new Color(173, 216, 230));
		
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton replayBtn = new JButton("Replay");
		replayBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		
		if (currentStars > 0){
			label.setText("Level Won!");
		}
		else {
			label.setText("Level Lost!");
		}
		
		JButton nextLvlBtn = new JButton("Next Level");
		nextLvlBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nextLvlBtn.setVisible(false);
		//add code to check for next level
		if (false) {nextLvlBtn.setVisible(true);}
		
		this.starView = new StarView();
		
		for(int i = 0; i < currentStars; i++){
			starView.addStar();
		}
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(nextLvlBtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(309)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(mainMenuBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addComponent(replayBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
					.addGap(327))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(277)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(replayBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainMenuBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nextLvlBtn)
					.addGap(103))
		);
		setLayout(groupLayout);
		
		//activate controllers
		replayBtn.addActionListener(new LevelPlayerController(playerFrame, initialModel));
		mainMenuBtn.addActionListener(new ReturnToPlayerMenuController(playerFrame));
		

	}

}
