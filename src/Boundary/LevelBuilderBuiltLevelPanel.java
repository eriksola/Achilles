package Boundary;

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

import Controller.EditDeletePopupListener;
import Controller.ReturnToBuilderMenuController;
import Controller.ReturnToPlayerMenuController;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelBuilderBuiltLevelPanel extends JPanel {

	LevelBuilderFrame mainframe;
	JButton menuBtn;
	JLabel puzzleLevelsLabels[] = new JLabel[5];	
	JLabel lightningLevelsLabels[] = new JLabel[5];
	JLabel releaseLevelsLabels[] = new JLabel[5];
	
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
		
		
	
		JLabel builtp1 = new JLabel("1");
		builtp1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp1.setVisible(false);
		JLabel builtp2 = new JLabel("2");
		builtp2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp2.setVisible(false);
		JLabel builtp3 = new JLabel("3");
		builtp3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp3.setVisible(false);
		JLabel builtp4 = new JLabel("4");
		builtp4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp4.setVisible(false);
		JLabel builtp5 = new JLabel("5");
		builtp5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp5.setVisible(false);
		puzzleLevelsLabels[0] = builtp1;
		puzzleLevelsLabels[1] = builtp2;
		puzzleLevelsLabels[2] = builtp3;
		puzzleLevelsLabels[3] = builtp4;
		puzzleLevelsLabels[4] = builtp5;
		
		JLabel builtl1 = new JLabel("1");
		builtl1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl1.setVisible(false);
		JLabel builtl2 = new JLabel("2");
		builtl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl2.setVisible(false);
		JLabel builtl3 = new JLabel("3");
		builtl3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl3.setVisible(false);
		JLabel builtl4 = new JLabel("4");
		builtl4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl4.setVisible(false);
		JLabel builtl5 = new JLabel("5");
		builtl5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl5.setVisible(false);
		lightningLevelsLabels[0] = builtl1;
		lightningLevelsLabels[1] = builtl2;
		lightningLevelsLabels[2] = builtl3;
		lightningLevelsLabels[3] = builtl4;
		lightningLevelsLabels[4] = builtl5;
		
		JLabel builtr1 = new JLabel("1");
		builtr1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr1.setVisible(false);
		JLabel builtr2 = new JLabel("2");
		builtr2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr2.setVisible(false);
		JLabel builtr3 = new JLabel("3");
		builtr3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr3.setVisible(false);
		JLabel builtr4 = new JLabel("4");
		builtr4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr4.setVisible(false);
		JLabel builtr5 = new JLabel("5");
		builtr5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr5.setVisible(false);
		releaseLevelsLabels[0] = builtr1;
		releaseLevelsLabels[1] = builtr2;
		releaseLevelsLabels[2] = builtr3;
		releaseLevelsLabels[3] = builtr4;
		releaseLevelsLabels[4] = builtr5;
		
		
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
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(684, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(builtr1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtr2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtr3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtr4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtr5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(builtl1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(builtp1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(builtp2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(builtp3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(builtp4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(builtp5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(builtl2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(builtl3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(builtl4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(builtl5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))))
							.addGap(495))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(40)
							.addComponent(puzzlelabel)
							.addGap(12)
							.addComponent(builtp1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(title)
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(builtp2)
								.addComponent(builtp3)
								.addComponent(builtp4)
								.addComponent(builtp5))
							.addGap(44)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(builtl1)
						.addComponent(builtl2)
						.addComponent(builtl3)
						.addComponent(builtl4)
						.addComponent(builtl5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(builtr1)
						.addComponent(builtr2)
						.addComponent(builtr3)
						.addComponent(builtr4)
						.addComponent(builtr5))
					.addContainerGap(572, Short.MAX_VALUE))
		);
		
		panel.setLayout(gl_panel);
		
		//activate controllers for buttons
		menuBtn.addActionListener(new ReturnToBuilderMenuController(mainframe));
		if(mainframe.hasBuiltLevels()){			
			int puzzleLevels = mainframe.getPuzzleLevelCount();
			int lightningLevels = mainframe.getLightningLevelCount();
			int releaseLevels = mainframe.getReleaseLevelCount();
			
			for(int i = 0; i < puzzleLevels; i++){
				Deserialization d = new Deserialization();
				if(d.Deserialize("./src/BuiltLevels/PuzzleLevels/Level" + (i + 1) + ".txt")){
					puzzleLevelsLabels[i].setVisible(true);	
					puzzleLevelsLabels[i].addMouseListener(new EditDeletePopupListener(new EditDeletePopup("./src/BuiltLevels/PuzzleLevels/Level" + (i + 1) + ".txt",this, i, 1, d)));
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			for(int i = 0; i < lightningLevels; i++){
				Deserialization d = new Deserialization();
				if(d.Deserialize("./src/BuiltLevels/LightningLevels/Level" + (i + 1) + ".txt")){
					lightningLevelsLabels[i].setVisible(true);
					lightningLevelsLabels[i].addMouseListener(new EditDeletePopupListener(new EditDeletePopup("./src/BuiltLevels/LightningLevels/Level" + (i + 1) + ".txt",this, i,2, d)));
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			for(int i = 0; i < releaseLevels; i++){
				Deserialization d = new Deserialization();
				if(d.Deserialize("./src/BuiltLevels/ReleaseLevels/Level" + (i + 1) + ".txt")){
					releaseLevelsLabels[i].setVisible(true);
					releaseLevelsLabels[i].addMouseListener(new EditDeletePopupListener(new EditDeletePopup("./src/BuiltLevels/ReleaseLevels/Level" + (i + 1) + ".txt", this, i,3,d)));
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			System.out.println("Levels Loaded!");
		}
	}
	
	public void removeLevel(int levelNum, int levelType) {
		if(levelType == 1){
			puzzleLevelsLabels[levelNum].setVisible(false);
			
		}
		else if(levelType == 2){
			lightningLevelsLabels[levelNum].setVisible(false);
		}
		else if(levelType == 3){
			releaseLevelsLabels[levelNum].setVisible(false);
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
