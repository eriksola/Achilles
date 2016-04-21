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
	JButton puzzlebuiltLevel1;
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
		
		puzzlebuiltLevel1 = new JButton("1");
		puzzlebuiltLevel1.setVisible(false);
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button)
									.addGap(127)
									.addComponent(title))
								.addComponent(puzzlelabel))
							.addContainerGap(357, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(676, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(puzzlebuiltLevel1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
							.addGap(669))))
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
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(puzzlebuiltLevel1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(92)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(169, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers for buttons
		menuBtn.addActionListener(new ReturnToPlayerMenuController(mainframe));
		if(d.Deserialize()){
			puzzlebuiltLevel1.setVisible(true);
			System.out.println("Deserialize Successful!");
		}
	}
	
	public JButton getMenuButton(){
		return this.menuBtn;
	}
}
