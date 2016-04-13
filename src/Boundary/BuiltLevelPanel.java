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
		
		JLabel label = new JLabel("Built Levels");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JLabel label_1 = new JLabel("Puzzle:");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("Lightning:");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JButton button_2 = new JButton("1");
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton button_3 = new JButton("1");
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("Release:");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 750, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button)
									.addGap(127)
									.addComponent(label))
								.addComponent(label_1)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(347, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(669))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(679, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(679, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(666, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(40)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//activate controllers for buttons
		menuBtn.addActionListener(new ReturnToPlayerMenuController(mainframe));

	}
	
	public JButton getMenuButton(){
		return this.menuBtn;
	}
}
