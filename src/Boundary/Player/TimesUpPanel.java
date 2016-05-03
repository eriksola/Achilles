package Boundary.Player;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.DefLevelMenuToLightningLevelController;
import Controller.ReturnToPlayerMenuController;
import Game.IScore;
import Game.LightningLevelModel;
import Game.LightningScore;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingConstants;

public class TimesUpPanel extends JPanel {
	
	KabasujiFrame playerFrame;
	LightningLevelModel initialModel;
	IScore currentScore;
	
	/**
	 * Create the panel.
	 */
	public TimesUpPanel(KabasujiFrame frame, LightningLevelModel llm, IScore score){
		
		this.playerFrame = frame;
		this.initialModel = llm;
		this.currentScore = score;
		
		int initStars = initialModel.getScore().scoreToStars();
		int currentStars = currentScore.scoreToStars();
		
		//if the new score is better, set is as the new top score
		if (currentStars > initStars){
			initialModel.setScore((LightningScore) currentScore);
			
			ArrayList<Object> entities = new ArrayList<Object>();
			entities.add(initialModel.getBullPen());
			entities.add(initialModel.getBoard());
			entities.add(initialModel.getScore());
			entities.add(initialModel.getTime());
			
			ArrayList<File> files = new ArrayList<File>();
			
			File builtLightningPath = new File("./src/BuiltLevels/LightningLevels");
			ArrayList<File> builtLightning = new ArrayList<File>(Arrays.asList(builtLightningPath.listFiles()));
			files.addAll(builtLightning);
			
			File defaultLightningPath = new File("./src/DefaultLevels/PuzzleLevels");
			ArrayList<File> defaultLightning = new ArrayList<File>(Arrays.asList(defaultLightningPath.listFiles()));
			files.addAll(defaultLightning);
			
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
		mainMenuBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton replayBtn = new JButton("Replay");
		replayBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel TimesUpLbl = new JLabel("Time Is Up!");
		TimesUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TimesUpLbl.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(313)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(replayBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(mainMenuBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(295)
							.addComponent(TimesUpLbl, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(323, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(TimesUpLbl, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
					.addComponent(replayBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(mainMenuBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(147))
		);
		setLayout(groupLayout);
		
		//activate controllers
		replayBtn.addActionListener(new DefLevelMenuToLightningLevelController(playerFrame, initialModel));
		mainMenuBtn.addActionListener(new ReturnToPlayerMenuController(playerFrame));
		

	}

}
