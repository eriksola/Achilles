package Boundary.Builder;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import Boundary.Both.Deserialization;
import Controller.EditDeletePopupListener;
import Controller.ReturnToBuilderMenuController;
import Controller.ReturnToPlayerMenuController;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JScrollPane;

import java.awt.GridLayout;


public class LevelBuilderBuiltLevelPanel extends JPanel {

	LevelBuilderFrame mainframe;
	JButton menuBtn;

	HashMap<String, JLabel> puzzleLevelsLabels = new HashMap<String, JLabel>();
	HashMap<String, JLabel> lightningLevelsLabels = new HashMap<String, JLabel>();
	HashMap<String, JLabel> releaseLevelsLabels = new HashMap<String, JLabel>();
	/**
	 * Create the panel.
	 */
	public LevelBuilderBuiltLevelPanel(LevelBuilderFrame f) {
		setBackground(new Color(173, 216, 230));
		this.mainframe = f;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Main Menu");
		this.menuBtn = button;
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel title = new JLabel("Built Levels");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(0, 0, 0));
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JLabel puzzlelabel = new JLabel("Puzzle:");
		puzzlelabel.setForeground(new Color(0, 0, 0));
		puzzlelabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel label_2 = new JLabel("Lightning:");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel label_3 = new JLabel("Release:");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JScrollPane puzzleScroll = new JScrollPane();
		
		JScrollPane lightningScroll = new JScrollPane();
		
		JScrollPane releaseScroll = new JScrollPane();
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(127)
							.addComponent(title))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(puzzlelabel)
							.addContainerGap(703, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
							.addGap(556))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(puzzleScroll, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(84, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(684, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lightningScroll, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(84, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(releaseScroll, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(84, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(40)
							.addComponent(puzzlelabel))
						.addComponent(title))
					.addGap(10)
					.addComponent(puzzleScroll, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lightningScroll, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(releaseScroll, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(434, Short.MAX_VALUE))
		);
		
		JPanel releasePanel = new JPanel();
		releasePanel.setBackground(Color.WHITE);
		releaseScroll.setViewportView(releasePanel);
		releasePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel lightningPanel = new JPanel();
		lightningPanel.setBackground(Color.WHITE);
		lightningScroll.setViewportView(lightningPanel);
		lightningPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel puzzlePanel = new JPanel();
		puzzleScroll.setViewportView(puzzlePanel);
		puzzlePanel.setBackground(Color.WHITE);
		puzzlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.setLayout(gl_panel);
		
		//activate controllers for buttons
		menuBtn.addActionListener(new ReturnToBuilderMenuController(mainframe));
		
		if(mainframe.hasBuiltLevels()){			
			int puzzleLevels = mainframe.getPuzzleLevelCount();
			File puzzlePath = new File("./src/BuiltLevels/PuzzleLevels");
			ArrayList<File> puzzleFiles = new ArrayList<File>(Arrays.asList(puzzlePath.listFiles()));
					
			int lightningLevels = mainframe.getLightningLevelCount();
			File lightningPath = new File("./src/BuiltLevels/LightningLevels");
			ArrayList<File> lightningFiles = new ArrayList<File>(Arrays.asList(lightningPath.listFiles()));
			
			int releaseLevels = mainframe.getReleaseLevelCount();
			File releasePath = new File("./src/BuiltLevels/ReleaseLevels");
			ArrayList<File> releaseFiles = new ArrayList<File>(Arrays.asList(releasePath.listFiles()));
			
			for(int i = 0; i < puzzleLevels; i++){
				Deserialization d = new Deserialization();
				String levelName;
				if(d.Deserialize(puzzleFiles.get(i).getPath(), 1)){
					levelName = puzzleFiles.get(i).getName();
					//Removes the file extension
					if (levelName.indexOf(".") > 0){
						levelName = levelName.substring(0, levelName.lastIndexOf("."));
					}
					puzzleLevelsLabels.put(levelName, new JLabel(levelName));
					puzzleLevelsLabels.get(levelName).setVisible(true);	
					puzzlePanel.add(puzzleLevelsLabels.get(levelName));
					puzzleLevelsLabels.get(levelName).addMouseListener(new EditDeletePopupListener(new EditDeletePopup("./src/BuiltLevels/PuzzleLevels/" + levelName + ".txt", this, i, 1, d)));
					puzzlePanel.revalidate();
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			for(int i = 0; i < lightningLevels; i++){
				Deserialization d = new Deserialization();
				String levelName;
				if(d.Deserialize(lightningFiles.get(i).getPath(), 2)){
					levelName = lightningFiles.get(i).getName();
					//Removes the file extension
					if (levelName.indexOf(".") > 0){
						levelName = levelName.substring(0, levelName.lastIndexOf("."));
					}
					lightningLevelsLabels.put(levelName, new JLabel(levelName));
					lightningLevelsLabels.get(levelName).setVisible(true);	
					lightningPanel.add(lightningLevelsLabels.get(levelName));
					lightningLevelsLabels.get(levelName).addMouseListener(new EditDeletePopupListener(new EditDeletePopup("./src/BuiltLevels/LightningLevels/" + levelName + ".txt", this, i, 2, d)));
					lightningPanel.revalidate();
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			for(int i = 0; i < releaseLevels; i++){
				Deserialization d = new Deserialization();
				String levelName;
				if(d.Deserialize(releaseFiles.get(i).getPath(), 3)){
					levelName = releaseFiles.get(i).getName();
					//Removes the file extension
					if (levelName.indexOf(".") > 0){
						levelName = levelName.substring(0, levelName.lastIndexOf("."));
					}
					releaseLevelsLabels.put(levelName, new JLabel(levelName));
					releaseLevelsLabels.get(levelName).setVisible(true);	
					releasePanel.add(releaseLevelsLabels.get(levelName));
					releaseLevelsLabels.get(levelName).addMouseListener(new EditDeletePopupListener(new EditDeletePopup("./src/BuiltLevels/ReleaseLevels/" + levelName + ".txt", this, i, 3, d)));
					releasePanel.revalidate();
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			System.out.println("Levels Loaded!");
		}
	}
	
	public void removeLevel(String levelName, int levelType) {
		if(levelType == 1){
			puzzleLevelsLabels.get(levelName).setVisible(false);
			puzzleLevelsLabels.remove(levelName);
			
		}
		else if(levelType == 2){
			lightningLevelsLabels.get(levelName).setVisible(false);
			lightningLevelsLabels.remove(levelName);
		}
		else if(levelType == 3){
			releaseLevelsLabels.get(levelName).setVisible(false);
			releaseLevelsLabels.remove(levelName);
		}
		else{
			System.err.println("Error, no such " + levelType + "level type!");
		}
	}
	
	public JButton getMenuButton(){
		return this.menuBtn;
	}

	public LevelBuilderFrame getMainFrame(){
		return this.mainframe;
	}
}
