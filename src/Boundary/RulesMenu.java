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
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class RulesMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesMenu frame = new RulesMenu();
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
	public RulesMenu() {
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.setForeground(Color.WHITE);
		lblRules.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JLabel lblForAllLevels = new JLabel("For All Levels:");
		lblForAllLevels.setForeground(Color.WHITE);
		lblForAllLevels.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel lblPuzzle = new JLabel("Puzzle:");
		lblPuzzle.setForeground(Color.WHITE);
		lblPuzzle.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel lblLightning = new JLabel("Lightning:");
		lblLightning.setForeground(Color.WHITE);
		lblLightning.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel label = new JLabel("");
		
		JLabel lblRelease = new JLabel("Release:");
		lblRelease.setForeground(Color.WHITE);
		lblRelease.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JTextArea txtForAllLevels = new JTextArea();
		txtForAllLevels.setEditable(false);
		txtForAllLevels.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtForAllLevels.setText("Pieces in Bullpen can be rotated and flipped");
		
		JTextArea txtPuzzle = new JTextArea();
		txtPuzzle.setEditable(false);
		txtPuzzle.setText("Pieces placed with no restrictions within the board\r\nPieces CANNOT overlap other pieces\r\nEach level has a limit on the number of moves\r\n");
		txtPuzzle.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JTextArea txtLightning = new JTextArea();
		txtLightning.setEditable(false);
		txtLightning.setText("Pieces placed with no restrictions within the board\r\nPieces can overlap other pieces\r\nOnce a piece is played it CANNOT be moved\r\nEach level has a time limit\r\n");
		txtLightning.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JTextArea txtRelease = new JTextArea();
		txtRelease.setEditable(false);
		txtRelease.setText("Pieces placed with no restrictions within the board\r\nPieces CANNOT overlap other pieces\r\nOnce a piece is played it CANNOT be removed\r\nEach level contains 3 sets of colored number tiles (1-6)\r\nCan contain multiples of the same number\r\n\"Release\" as many complete sets of colors (1-6) as possible");
		txtRelease.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMainMenu)
							.addGap(175)
							.addComponent(lblRules))
						.addComponent(label)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblForAllLevels)
								.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtForAllLevels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLightning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPuzzle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPuzzle))))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMainMenu)
						.addComponent(lblRules))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblForAllLevels, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuzzle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPuzzle, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtForAllLevels, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(502)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLightning, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
