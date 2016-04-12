package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BuiltLevels extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuiltLevels frame = new BuiltLevels();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuiltLevels() {
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton MainMenuButton = new JButton("Main Menu");
		MainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MainMenuButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel BuiltLevelsTitle = new JLabel("Built Levels");
		BuiltLevelsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		BuiltLevelsTitle.setForeground(Color.WHITE);
		BuiltLevelsTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JLabel lblPuzzle = new JLabel("Puzzle:");
		lblPuzzle.setForeground(Color.WHITE);
		lblPuzzle.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblLightning = new JLabel("Lightning:");
		lblLightning.setForeground(Color.WHITE);
		lblLightning.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblRelease = new JLabel("Release:");
		lblRelease.setForeground(Color.WHITE);
		lblRelease.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JButton puzzle1 = new JButton("1");
		puzzle1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton lightning1 = new JButton("1");
		lightning1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton release1 = new JButton("1");
		release1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(MainMenuButton)
									.addGap(127)
									.addComponent(BuiltLevelsTitle))
								.addComponent(lblPuzzle)
								.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(347, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLightning, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(669))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lightning1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(679, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(release1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(679, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(666, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(BuiltLevelsTitle)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(MainMenuButton)
							.addGap(40)
							.addComponent(lblPuzzle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lightning1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(release1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
