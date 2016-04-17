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
		lblNewLabel.setIcon(new ImageIcon("Image/goodHammer.png"));
		
		JLabel lblLevelbuilder = new JLabel("LevelBuilder");
		lblLevelbuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelbuilder.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)
							.addGap(18)
							.addComponent(button_2)
							.addGap(237))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(lblLevelbuilder, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(505, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(248))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblLevelbuilder, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(18)
					.addComponent(label_1)
					.addGap(90))
		);
		setLayout(groupLayout);
		
		puzzle.addActionListener(new SwitchWindowController(mainFrame, new LevelBuilderPuzzlePanel(frame)));
		lightning.addActionListener(new SwitchWindowController(mainFrame, new LevelBuilderLightningPanel(frame)));
		release.addActionListener(new SwitchWindowController(mainFrame, new LevelBuilderReleasePanel(frame)));
	}
}
