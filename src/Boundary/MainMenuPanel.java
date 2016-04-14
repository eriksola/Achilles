package Boundary;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.SwitchWindowController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainMenuPanel extends JPanel {
	
	KabasujiFrame mainFrame;
	JButton builtBtn;
	JButton defaultBtn;
	JButton rulesBtn;
	
	/**
	 * Create the panel.
	 */
	public MainMenuPanel(KabasujiFrame frame) {
		
		this.mainFrame = frame;
		setBackground(new Color(173, 216, 230));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel Title = new JLabel("Kabasuji");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		
		JButton BuiltLevelsButton = new JButton("Your Levels");
		this.builtBtn = BuiltLevelsButton;
		
		JButton RulesButton = new JButton("Rules");
		this.rulesBtn = RulesButton;
		
		JButton DefaultLevelsButton = new JButton("Our Levels");
		this.defaultBtn = DefaultLevelsButton;
		
		JLabel DesignedBy = new JLabel("Designed By: Nan Zhang, Barry Wolfson, Giovanni Aguila, Paul-Henry Schoehagen, Erik Sola");
		DesignedBy.setHorizontalAlignment(SwingConstants.CENTER);
		DesignedBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Image/rsz_1rsz_1rsz_1rhino.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(Title, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(226)
							.addComponent(BuiltLevelsButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(RulesButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(DefaultLevelsButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(DesignedBy, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(290, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(285))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(Title)
					.addGap(75)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(139)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BuiltLevelsButton)
						.addComponent(DefaultLevelsButton)
						.addComponent(RulesButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(DesignedBy, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		panel.setLayout(gl_panel);

		//activate controllers for buttons
		rulesBtn.addActionListener(new SwitchWindowController(mainFrame, new RulesMenuPanel(mainFrame)));
		defaultBtn.addActionListener(new SwitchWindowController(mainFrame, new DefaultLevelPanel(mainFrame)));
		builtBtn.addActionListener(new SwitchWindowController(mainFrame, new BuiltLevelPanel(mainFrame)));

	}
	
}
