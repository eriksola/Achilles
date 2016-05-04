package Boundary.Player;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import Boundary.Both.Deserialization;
import Boundary.Builder.EditDeletePopup;
import Boundary.Builder.LevelBuilderFrame;
import Controller.EditDeletePopupListener;
import Controller.PlayLevelPopupListener;
import Controller.ReturnToPlayerMenuController;

import javax.swing.JScrollPane;

/**
 * Panel for the built static levels in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class BuiltLevelPanel extends JPanel {

	KabasujiFrame mainframe; /** main frame **/
	JButton menuBtn; /** main menu button **/
	HashMap<String, JLabel> puzzleLevelsLabels = new HashMap<String, JLabel>(); /** labels for the puzzle levels **/
	HashMap<String, JLabel> lightningLevelsLabels = new HashMap<String, JLabel>(); /** labels for the lightning levels **/
	HashMap<String, JLabel> releaseLevelsLabels = new HashMap<String, JLabel>(); /** labels for the release levels **/

	/**
	 * Create the panel.
	 */
	public BuiltLevelPanel(KabasujiFrame f) {
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
							.addComponent(puzzleScroll, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(127)
							.addComponent(title)
							.addContainerGap(365, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(puzzlelabel)
							.addContainerGap(703, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
							.addGap(556))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lightningScroll, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(114, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(684, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(releaseScroll, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(114, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(title)
						.addComponent(button))
					.addGap(13)
					.addComponent(puzzlelabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(puzzleScroll, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lightningScroll, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(releaseScroll, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(470, Short.MAX_VALUE))
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
		menuBtn.addActionListener(new ReturnToPlayerMenuController(mainframe));
		
		//if there are levels from the builder
		if(mainframe.hasBuiltLevels()){			
			
			//Load array of puzzle level files
			int puzzleLevels = mainframe.getBuiltPuzzles();
			File puzzlePath = new File("./src/BuiltLevels/PuzzleLevels");
			ArrayList<File> puzzleFiles = new ArrayList<File>(Arrays.asList(puzzlePath.listFiles()));
			
			//Load array of lightning level files
			int lightningLevels = mainframe.getBuiltLightning();
			File lightningPath = new File("./src/BuiltLevels/LightningLevels");
			ArrayList<File> lightningFiles = new ArrayList<File>(Arrays.asList(lightningPath.listFiles()));
			
			//Load array of release level files
			int releaseLevels = mainframe.getBuiltRelease();
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
					puzzleLevelsLabels.get(levelName).addMouseListener(new PlayLevelPopupListener(new PlayLevelPopup(levelName, this, 1, d)));
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
					lightningLevelsLabels.get(levelName).addMouseListener(new PlayLevelPopupListener(new PlayLevelPopup(levelName, this, 2, d)));
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
					releaseLevelsLabels.get(levelName).addMouseListener(new PlayLevelPopupListener(new PlayLevelPopup(levelName, this, 3, d)));
					releasePanel.revalidate();
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			System.out.println(" Built Levels Loaded!");
		}
	}
	
	public JButton getMenuButton(){
		return this.menuBtn;
	}
	
	public KabasujiFrame getMainFrame(){
		return this.mainframe;
	}
}
