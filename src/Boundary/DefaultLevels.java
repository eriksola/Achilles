package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class DefaultLevels extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultLevels frame = new DefaultLevels();
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
	public DefaultLevels() {
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JButton puzzle1 = new JButton("1");
		puzzle1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		puzzle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton puzzle2 = new JButton("2");
		puzzle2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton puzzle3 = new JButton("3");
		puzzle3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton puzzle4 = new JButton("4");
		puzzle4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton puzzle5 = new JButton("5");
		puzzle5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton lightning1 = new JButton("1");
		lightning1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton lightning2 = new JButton("2");
		lightning2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton lightning3 = new JButton("3");
		lightning3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton lightning4 = new JButton("4");
		lightning4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton lightning5 = new JButton("5");
		lightning5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton release1 = new JButton("1");
		release1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton release2 = new JButton("2");
		release2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton release3 = new JButton("3");
		release3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton release4 = new JButton("4");
		release4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JButton release5 = new JButton("5");
		release5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		JLabel DefaultLevelsTitle = new JLabel("Default Levels");
		DefaultLevelsTitle.setForeground(Color.WHITE);
		DefaultLevelsTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JLabel lblPuzzle = new JLabel("Puzzle:");
		lblPuzzle.setForeground(Color.WHITE);
		lblPuzzle.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblLightning = new JLabel("Lightning:");
		lblLightning.setForeground(Color.WHITE);
		lblLightning.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblRelease = new JLabel("Release:");
		lblRelease.setForeground(Color.WHITE);
		lblRelease.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(mainMenu)
							.addGap(115)
							.addComponent(DefaultLevelsTitle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(puzzle5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lightning1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lightning5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuzzle)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(release1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(release5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(320, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(mainMenu)
							.addGap(40)
							.addComponent(lblPuzzle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(puzzle3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
						.addComponent(DefaultLevelsTitle))
					.addGap(40)
					.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lightning1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lightning5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(release1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(release5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
