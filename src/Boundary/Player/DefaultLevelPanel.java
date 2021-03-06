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
import Controller.DefLevelMenuToLightningLevelController;
import Controller.DefLevelMenuToPuzzleLevelController;
import Controller.DefLevelMenuToReleaseLevelController;
import Controller.LevelPlayerController;
import Controller.ReturnToPlayerMenuController;
import Controller.TimerController;
import Game.Board;
import Game.BullPen;
import Game.LevelModel;
import Game.LightningBoard;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.ReleaseScore;
import Game.Stock;
import Game.Tile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JTextArea;

/**
 * Panel for the default levels in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class DefaultLevelPanel extends JPanel {
		
		KabasujiFrame mainframe; /** main frame **/
		PuzzleLevelModel[] puzzleLevels; /** puzzle levels available **/
		LightningLevelModel[] lightLevels; /** lightning levels available **/
		LevelModel[] releaseLevels; /** release levels available **/
		
		JButton menuBtn; /** main menu button **/
		JButton[] puzzleBtns = new JButton[5]; /** five buttons for Puzzle levels **/
		JButton[] lightBtns = new JButton[5];	/** five buttons for Lightning levels **/
		JButton[] releaseBtns = new JButton[5]; /** five buttons for Release Levels **/
		
		JTextArea timerView; /** view of the timer **/
		HashMap<String, JLabel> puzzleLevelsLabels = new HashMap<String, JLabel>(); /** labels for puzzle levels **/
		HashMap<String, JLabel> lightningLevelsLabels = new HashMap<String, JLabel>(); /** labels for lightning levels **/
		HashMap<String, JLabel> releaseLevelsLabels = new HashMap<String, JLabel>(); /** labels for release levels **/
		
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
		
		JButton puzzle1 = new JButton("1");
		puzzle1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.puzzleBtns[0] = puzzle1;
		
		JButton puzzle2 = new JButton("2");
		puzzle2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.puzzleBtns[1] = puzzle2;
		
		JButton puzzle3 = new JButton("3");
		puzzle3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.puzzleBtns[2] = puzzle3;
		
		JButton puzzle4 = new JButton("4");
		puzzle4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.puzzleBtns[3] = puzzle4;
		
		JButton puzzle5 = new JButton("5");
		puzzle5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.puzzleBtns[4] = puzzle5;
		
		JButton lightning1 = new JButton("1");
		lightning1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lightBtns[0] = lightning1;
		
		JButton lightning2 = new JButton("2");
		lightning2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lightBtns[1] = lightning2;
		
		JButton lightning3 = new JButton("3");
		lightning3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lightBtns[2] = lightning3;
		
		JButton lightning4 = new JButton("4");
		lightning4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lightBtns[3] = lightning4;
		
		JButton lightning5 = new JButton("5");
		lightning5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lightBtns[4] = lightning5;
		
		JLabel lightningLbl = new JLabel("Lightning:");
		lightningLbl.setForeground(new Color(0, 0, 0));
		lightningLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel puzzleLbl = new JLabel("Puzzle:");
		puzzleLbl.setForeground(new Color(0, 0, 0));
		puzzleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JButton release1 = new JButton("1");
		release1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.releaseBtns[0] = release1;
		
		JButton release2 = new JButton("2");
		release2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.releaseBtns[1] = release2;
		
		JButton release3 = new JButton("3");
		release3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.releaseBtns[2] = release3;
		
		JButton release4 = new JButton("4");
		release4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.releaseBtns[3] = release4;
		
		JButton release5 = new JButton("5");
		release5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.releaseBtns[4] = release5;
		
		for (int i = 0; i < 5 ; i++){
			this.puzzleBtns[i].setEnabled(false);
			this.lightBtns[i].setEnabled(false);
			this.releaseBtns[i].setEnabled(false);
		}
		JLabel releaseLbl = new JLabel("Release:");
		releaseLbl.setForeground(new Color(0, 0, 0));
		releaseLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
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
							.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lightning1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(puzzleLbl)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(release1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(lightningLbl, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(releaseLbl, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(40)
							.addComponent(puzzleLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label))
					.addGap(18)
					.addComponent(lightningLbl, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lightning1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(releaseLbl, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(release1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
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
		
		if (puzzleFiles.size() > 0){
			this.puzzleLevels = new PuzzleLevelModel[puzzleFiles.size()];
		}
		if (lightningFiles.size() > 0){
			this.lightLevels = new LightningLevelModel[lightningFiles.size()];
		}
		if (releaseFiles.size() > 0){
			this.releaseLevels = new LevelModel[releaseFiles.size()];
		}
		
		//load puzzle levels (and check if next level is unlocked)
		for(int i = 0; i < puzzleFiles.size(); i++){
			Deserialization d = new Deserialization();
			if(d.Deserialize(puzzleFiles.get(i).getPath(), 1)){
				//deserialize puzzle level and activate controller for playing it
				puzzleLevels[i] = new PuzzleLevelModel(d.getBoard(), d.getBullPen(), puzzleFiles.get(i).getName(),(PuzzleScore) d.getScore(), new Stock(), d.getNumMoves());
				puzzleBtns[i].addActionListener(new LevelPlayerController( (KabasujiFrame) mainframe, puzzleLevels[i]));
				//if this isnt the last level, check if it unlocks the next level
				if (i < puzzleFiles.size() - 1){
					//if at least one star has been earned, next level unlocked
					if (((PuzzleScore) d.getScore()).scoreToStars() > 0){
						puzzleBtns[i + 1].setEnabled(true);
					}
				}
			}
			else{
				System.err.println("Error in serialization importing process!");
			}
		}
		
		//load lightning levels (and check if next level is unlocked)
		for(int i = 0; i < lightningFiles.size(); i++){
			Deserialization d = new Deserialization();
			if(d.Deserialize(lightningFiles.get(i).getPath(), 2)){
				//deserialize lightning level and activate controller for playing it
				lightLevels[i] = new LightningLevelModel(d.getBoard(), d.getBullPen(), lightningFiles.get(i).getName(), (LightningScore) d.getScore(), new Stock(), d.getTime());
				lightBtns[i].addActionListener(new LevelPlayerController( (KabasujiFrame) mainframe, lightLevels[i]));
				//if this isnt the last level, check if it unlocks the next level
				if (i < lightningFiles.size() - 1){
					//if at least one star has been earned, next level unlocked
					if (((LightningScore) d.getScore()).scoreToStars() > 0){
						lightBtns[i + 1].setEnabled(true);
					}
				}
			}
			else{
				System.err.println("Error in serialization importing process!");
			}
		}
		
		//load release levels (and check if next level is unlocked)
		for(int i = 0; i < releaseFiles.size(); i++){
			Deserialization d = new Deserialization();
			if(d.Deserialize(releaseFiles.get(i).getPath(), 3)){
				//deserialize release level and activate controller for playing it
				releaseLevels[i] = new LevelModel(d.getBoard(), d.getBullPen(), releaseFiles.get(i).getName(), (ReleaseScore) d.getScore(), new Stock());
				releaseBtns[i].addActionListener(new LevelPlayerController( (KabasujiFrame) mainframe, releaseLevels[i]));
				//if this isnt the last level, check if it unlocks the next level
				if (i < releaseFiles.size() - 1){
					//if one star has been earned, the next level is unlocked
					if (d.getScore().scoreToStars() > 0){
						releaseBtns[i + 1].setEnabled(true);
					}
				}
			}
			else{
				System.err.println("Error in serialization importing process!");
			}
		}
		
		//first level always unlocked
		puzzleBtns[0].setEnabled(true);
		lightBtns[0].setEnabled(true);
		releaseBtns[0].setEnabled(true);
		
		System.out.println("Default Levels Loaded!");
		
		
		this.menuBtn.addActionListener(new ReturnToPlayerMenuController(mainframe));
	}
	
}
