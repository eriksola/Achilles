package Boundary.Player;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Boundary.Both.Deserialization;
import Controller.DefLevelMenuToPuzzleLevelController;
import Controller.ReturnToPlayerMenuController;
import Controller.TimerController;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.ReleaseScore;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JTextArea;

public class DefaultLevelPanel extends JPanel {

		KabasujiFrame mainframe;
		PuzzleLevelModel[] puzzleLevels;
		LightningLevelModel[] lightLevels;
		LevelModel[] releaseLevels;
		
		JButton menuBtn;
		JButton[] puzzleBtns = new JButton[5];
		JTextArea timerView;
		HashMap<String, JLabel> puzzleLevelsLabels = new HashMap<String, JLabel>();
		HashMap<String, JLabel> lightningLevelsLabels = new HashMap<String, JLabel>();
		HashMap<String, JLabel> releaseLevelsLabels = new HashMap<String, JLabel>();
		
	/**
	 * Create the panel.
	 */
	public DefaultLevelPanel(KabasujiFrame f) {
		setBackground(new Color(173, 216, 230));
		
		this.mainframe = f;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Main Menu");
		this.menuBtn = button;
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel label = new JLabel("Default Levels");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JButton button_1 = new JButton("1");
		this.puzzleBtns[0] = button_1;
		
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_6 = new JButton("1");
		button_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_7 = new JButton("2");
		button_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_8 = new JButton("3");
		button_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_9 = new JButton("4");
		button_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_10 = new JButton("5");
		button_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("Lightning:");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel label_2 = new JLabel("Puzzle:");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JButton button_11 = new JButton("1");
		button_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_12 = new JButton("2");
		button_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_13 = new JButton("3");
		button_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_14 = new JButton("4");
		button_14.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_15 = new JButton("5");
		button_15.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("Release:");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(115)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_2)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_15, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(422, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(648, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button)
									.addGap(40)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
								.addComponent(label))
							.addGap(18)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_15, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(258)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		//activate controllers for buttons
		
		File puzzlePath = new File("./src/DefaultLevels/PuzzleLevels");
		ArrayList<File> puzzleFiles = new ArrayList<File>(Arrays.asList(puzzlePath.listFiles()));
		
		File lightningPath = new File("./src/DefaultLevels/LightningLevels");
		ArrayList<File> lightningFiles = new ArrayList<File>(Arrays.asList(lightningPath.listFiles()));
		
		File releasePath = new File("./src/DefaultLevels/ReleaseLevels");
		ArrayList<File> releaseFiles = new ArrayList<File>(Arrays.asList(releasePath.listFiles()));
		
		for(int i = 0; i < 1; i++){
			Deserialization d = new Deserialization();
			if(d.Deserialize(puzzleFiles.get(i).getPath(), 1)){
				//fake movesGiven until deserialization edited
				int movesGiven = 10;
				puzzleLevels[i] = new PuzzleLevelModel(d.getBoard(), d.getBullPen(), i, new PuzzleScore(movesGiven), movesGiven);
			}
			else{
				System.err.println("Error in serialization importing process!");
			}
		}
		for(int i = 0; i < 0; i++){
			Deserialization d = new Deserialization();
			if(d.Deserialize(lightningFiles.get(i).getPath(), 2)){
				lightLevels[i] = new LightningLevelModel(d.getBoard(), d.getBullPen(), i, new LightningScore(d.getTimer()), d.getTimer());
			}
			else{
				System.err.println("Error in serialization importing process!");
			}
		}
		for(int i = 0; i < 0; i++){
			Deserialization d = new Deserialization();
			if(d.Deserialize(releaseFiles.get(i).getPath(), 3)){
				releaseLevels[i] = new LevelModel(d.getBoard(), d.getBullPen(), i, new ReleaseScore());
			}
			else{
				System.err.println("Error in serialization importing process!");
			}
		}
		System.out.println("Levels Loaded!");
		
		
		
		this.menuBtn.addActionListener(new ReturnToPlayerMenuController(mainframe));
		this.puzzleBtns[0].addActionListener(new DefLevelMenuToPuzzleLevelController(mainframe, puzzleLevels[0]));
		for (int i = 0; i < 5 ; i++){
			//puzzleBtns[i].addActionListener(new DefLevelMenuToPuzzleLevelController( (KabasujiFrame) mainframe, puzzleLevels[i]));
			//lightBtns[i].addActionListener(new DefLevelMenuToLightningLevelController( (KabasujiFrame) mainframe, lightLevels[i]));
			//releaseBtns[i].addActionListener(new DefLevelMenuToReleaseLevelController( (KabasujiFrame) mainframe, releaseLevels[i]));
		} 
	}
	
	public JButton getMenuButton(){
		return menuBtn;
	}
}