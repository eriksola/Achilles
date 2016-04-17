package Boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.SwitchWindowController;

public class LevelBuilderMainMenuPanel extends JPanel {

	LevelBuilderFrame mainFrame;
	JButton lightning;
	JButton puzzle;
	JButton release;
	/**
	 * Create the panel.
	 */
	public LevelBuilderMainMenuPanel(LevelBuilderFrame frame) {
		setBackground(new Color(173, 216, 230));
		this.mainFrame = frame;
		
		JLabel label = new JLabel("LevelBuilder");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		
		JButton button = new JButton("Puzzle");
		this.puzzle = button;
		JButton button_1 = new JButton("Lightning");
		this.lightning = button_1;
		JButton button_2 = new JButton("Release");
		this.release = button_2;
		JLabel label_1 = new JLabel("Designed By: Nan Zhang, Barry Wolfson, Giovanni Aguila, Paul-Henry Schoehagen, Erik Sola");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Image/hammer.png"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(136)
										.addComponent(button)
										.addGap(18)
										.addComponent(button_1)
										.addGap(18)
										.addComponent(button_2))
									.addComponent(label_1))
								.addGap(87))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addGap(299)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(179))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(label)
					.addGap(44)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button)
						.addComponent(button_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addGap(31))
		);
		setLayout(groupLayout);
		
		puzzle.addActionListener(new SwitchWindowController(mainFrame, new LevelBuilderPuzzlePanel(frame)));
		lightning.addActionListener(new SwitchWindowController(mainFrame, new LevelBuilderLightningPanel(frame)));
		release.addActionListener(new SwitchWindowController(mainFrame, new LevelBuilderReleasePanel(frame)));
	}
}
