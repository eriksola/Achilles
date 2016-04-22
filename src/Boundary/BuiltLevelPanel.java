package Boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.ReturnToPlayerMenuController;

public class BuiltLevelPanel extends JPanel {

	KabasujiFrame mainframe;
	Deserialization d = new Deserialization();
	JButton menuBtn;
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
		
		
		JButton puzzleLevelsButtons[] = new JButton[5];	
		JButton lightningLevelsButtons[] = new JButton[5];
		JButton releaseLevelsButtons[] = new JButton[5];
		
		JButton builtp1 = new JButton("1");
		builtp1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp1.setVisible(false);
		JButton builtp2 = new JButton("2");
		builtp2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp2.setVisible(false);
		JButton builtp3 = new JButton("3");
		builtp3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp3.setVisible(false);
		JButton builtp4 = new JButton("4");
		builtp4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp4.setVisible(false);
		JButton builtp5 = new JButton("5");
		builtp5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtp5.setVisible(false);
		puzzleLevelsButtons[0] = builtp1;
		puzzleLevelsButtons[1] = builtp2;
		puzzleLevelsButtons[2] = builtp3;
		puzzleLevelsButtons[3] = builtp4;
		puzzleLevelsButtons[4] = builtp5;
		
		JButton builtl1 = new JButton("1");
		builtl1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl1.setVisible(false);
		JButton builtl2 = new JButton("2");
		builtl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl2.setVisible(false);
		JButton builtl3 = new JButton("3");
		builtl3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl3.setVisible(false);
		JButton builtl4 = new JButton("4");
		builtl4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl4.setVisible(false);
		JButton builtl5 = new JButton("5");
		builtl5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtl5.setVisible(false);
		lightningLevelsButtons[0] = builtl1;
		lightningLevelsButtons[1] = builtl2;
		lightningLevelsButtons[2] = builtl3;
		lightningLevelsButtons[3] = builtl4;
		lightningLevelsButtons[4] = builtl5;
		
		JButton builtr1 = new JButton("1");
		builtr1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr1.setVisible(false);
		JButton builtr2 = new JButton("2");
		builtr2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr2.setVisible(false);
		JButton builtr3 = new JButton("3");
		builtr3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr3.setVisible(false);
		JButton builtr4 = new JButton("4");
		builtr4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr4.setVisible(false);
		JButton builtr5 = new JButton("5");
		builtr5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		builtr5.setVisible(false);
		releaseLevelsButtons[0] = builtr1;
		releaseLevelsButtons[1] = builtr2;
		releaseLevelsButtons[2] = builtr3;
		releaseLevelsButtons[3] = builtr4;
		releaseLevelsButtons[4] = builtr5;
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button)
									.addGap(127)
									.addComponent(title))
								.addComponent(puzzlelabel))
							.addContainerGap(365, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
							.addGap(556))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(684, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(builtl1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtl2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtl3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtl4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtl5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
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
									.addComponent(builtp1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(builtp2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtp3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtp4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(builtp5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 0, Short.MAX_VALUE)))
							.addGap(495))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(title)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(40)
							.addComponent(puzzlelabel)
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(builtp1)
								.addComponent(builtp2)
								.addComponent(builtp3)
								.addComponent(builtp4)
								.addComponent(builtp5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(builtl1)
								.addComponent(builtl2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(builtl3)
						.addComponent(builtl4)
						.addComponent(builtl5))
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
		menuBtn.addActionListener(new ReturnToPlayerMenuController(mainframe));
		if(mainframe.hasBuiltLevels()){			
			int puzzleLevels = mainframe.getBuiltPuzzles();
			int lightningLevels = mainframe.getBuiltLightning();
			int releaseLevels = mainframe.getBuiltRelease();
			
			for(int i = 0; i < puzzleLevels; i++){
				if(d.Deserialize("./src/BuiltLevels/PuzzleLevels/Level" + i + ".txt")){
					puzzleLevelsButtons[i].setVisible(true);									
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			for(int i = 0; i < lightningLevels; i++){
				if(d.Deserialize("./src/BuiltLevels/LightningLevels/Level" + i + ".txt")){
					lightningLevelsButtons[i].setVisible(true);
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			for(int i = 0; i < releaseLevels; i++){
				if(d.Deserialize("./src/BuiltLevels/ReleaseLevels/Level" + i + ".txt")){
					releaseLevelsButtons[i].setVisible(true);
				}
				else{
					System.err.println("Error in serialization importing process!");
				}
			}
			System.out.println("Levels Loaded!");
		}
	}
	
	public JButton getMenuButton(){
		return this.menuBtn;
	}
}
