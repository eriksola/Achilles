package Boundary.Player;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import Controller.DefLevelMenuToLightningLevelController;
import Controller.LevelPlayerController;
import Controller.ReturnToPlayerMenuController;
import Game.IScore;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.PuzzleLevelModel;

public class LevelEndPanel extends JPanel{

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
		
		//if the new score is better, set it as the new top score
		System.out.println("Current stars: " + currentStars);
		System.out.println("Initial stars: " + initStars);
		if (currentStars > initStars){
			System.out.println("new highscore!");
			initialModel.setScore(currentScore);
			
			ArrayList<Object> entities = new ArrayList<Object>();
			entities.add(initialModel.getBullPen());
			entities.add(initialModel.getBoard());
			entities.add(initialModel.getScore());
			
			if (initialModel instanceof PuzzleLevelModel){
				entities.add(((PuzzleLevelModel)initialModel).getMovesAllowed());
			}
			
			if (initialModel instanceof LightningLevelModel){
				entities.add(((LightningLevelModel)initialModel).getTime());
			}
			
			//TEST
			System.out.println("Level name: " + level.getName());
			
			ArrayList<File> files = new ArrayList<File>();
			
			File builtPuzzlePath = new File("./src/BuiltLevels/PuzzleLevels");
			ArrayList<File> builtPuzzles = new ArrayList<File>(Arrays.asList(builtPuzzlePath.listFiles()));
			files.addAll(builtPuzzles);
			
			File builtLightningPath = new File("./src/BuiltLevels/LightningLevels");
			ArrayList<File> builtLightning = new ArrayList<File>(Arrays.asList(builtLightningPath.listFiles()));
			files.addAll(builtLightning);
			
			File builtReleasePath = new File("./src/BuiltLevels/ReleaseLevels");
			ArrayList<File> builtRelease = new ArrayList<File>(Arrays.asList(builtReleasePath.listFiles()));
			files.addAll(builtRelease);
			
			File defaultPuzzlePath = new File("./src/DefaultLevels/PuzzleLevels");
			ArrayList<File> defaultPuzzles = new ArrayList<File>(Arrays.asList(defaultPuzzlePath.listFiles()));
			files.addAll(defaultPuzzles);
			
			File defaultLightningPath = new File("./src/DefaultLevels/PuzzleLevels");
			ArrayList<File> defaultLightning = new ArrayList<File>(Arrays.asList(defaultLightningPath.listFiles()));
			files.addAll(defaultLightning);
			
			File defaultReleasePath = new File("./src/DefaultLevels/PuzzleLevels");
			ArrayList<File> defaultRelease = new ArrayList<File>(Arrays.asList(defaultReleasePath.listFiles()));
			files.addAll(defaultRelease);
			
			for(int i = 0; i < files.size(); i++){
				if (files.get(i).getName().equals(initialModel.getName())){
					try{
						String filepath = files.get(i).getAbsolutePath();
						File levelFile = new File(filepath);
						FileOutputStream fileOut = new FileOutputStream(filepath);
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						
						System.out.println("Serialized data is saved in " + filepath + " file");
						for(Object j: entities){
							out.writeObject(j);
						}
						
						out.close();
						fileOut.close();
						break;
					}catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}

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
					.addGap(309)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainMenuBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(replayBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
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
					.addGap(147))
		);
		setLayout(groupLayout);
		
		//activate controllers
		replayBtn.addActionListener(new LevelPlayerController(playerFrame, initialModel));
		mainMenuBtn.addActionListener(new ReturnToPlayerMenuController(playerFrame));
		

	}

}
