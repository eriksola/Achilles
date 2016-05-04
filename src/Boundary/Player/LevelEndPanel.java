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
import Game.LightningScore;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.ReleaseScore;

/**
 * Panel for a level that has ended 
 * @author gaguila
 *
 */
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
		
		if (currentStars > initStars){
			System.out.println("new highscore!");
			
			ArrayList<Object> entities = new ArrayList<Object>();
			entities.add(initialModel.getBullPen());
			
			if (currentScore instanceof LightningScore){
				LightningLevelModel lightModel = (LightningLevelModel) initialModel;
				lightModel.setScore((LightningScore) currentScore);
				entities.add(lightModel.getLightningBoard());
				entities.add(lightModel.getScore());
				entities.add(lightModel.getTime());
			}
			
			if (currentScore instanceof PuzzleScore){
				PuzzleLevelModel puzzleModel = (PuzzleLevelModel) initialModel;
				puzzleModel.setScore((PuzzleScore) currentScore);
				entities.add(puzzleModel.getBoard());
				entities.add(puzzleModel.getScore());
				entities.add(puzzleModel.getMovesAllowed());
			}
			
			if (currentScore instanceof ReleaseScore){
				initialModel.setScore((ReleaseScore) currentScore);
				entities.add(initialModel.getBoard());
				entities.add(initialModel.getScore());
			}
			
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
			
			File defaultLightningPath = new File("./src/DefaultLevels/LightningLevels");
			ArrayList<File> defaultLightning = new ArrayList<File>(Arrays.asList(defaultLightningPath.listFiles()));
			files.addAll(defaultLightning);
			
			File defaultReleasePath = new File("./src/DefaultLevels/ReleaseLevels");
			ArrayList<File> defaultRelease = new ArrayList<File>(Arrays.asList(defaultReleasePath.listFiles()));
			files.addAll(defaultRelease);
			
			System.out.println(initialModel.getName());
			for(int i = 0; i < files.size(); i++){
				if (files.get(i).getName().equals(initialModel.getName())){
					try{
						String filepath = files.get(i).getAbsolutePath();
						FileOutputStream fileOut = new FileOutputStream(filepath);
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						
						for(Object j: entities){
							System.out.println("Writing to file: " + j);
							out.writeObject(j);
						}
						
						out.close();
						fileOut.close();
						System.out.println("Serialized data is saved in " + filepath + " file");
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
