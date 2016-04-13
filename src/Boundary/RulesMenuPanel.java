package Boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;


public class RulesMenuPanel extends JPanel {
	
	KabasujiFrame mainFrame;
	JButton menuBtn;
	/**
	 * Create the panel.
	 */
	public RulesMenuPanel(KabasujiFrame frame) {
		setBackground(new Color(173, 216, 230));
		this.mainFrame = frame;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Main Menu");
		this.menuBtn = button;
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel label = new JLabel("Rules");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("For All Levels:");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel label_3 = new JLabel("Lightning:");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Pieces in Bullpen can be rotated and flipped");
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textArea.setEditable(false);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("Pieces placed with no restrictions within the board\r\nPieces can overlap other pieces\r\nOnce a piece is played it CANNOT be moved\r\nEach level has a time limit\r\n");
		textArea_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textArea_1.setEditable(false);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("Pieces placed with no restrictions within the board\r\nPieces CANNOT overlap other pieces\r\nEach level has a limit on the number of moves\r\n");
		textArea_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textArea_2.setEditable(false);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("Pieces placed with no restrictions within the board\r\nPieces CANNOT overlap other pieces\r\nOnce a piece is played it CANNOT be removed\r\nEach level contains 3 sets of colored number tiles (1-6)\r\nCan contain multiples of the same number\r\n\"Release\" as many complete sets of colors (1-6) as possible");
		textArea_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textArea_3.setEditable(false);
		
		JLabel label_4 = new JLabel("Release:");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel label_5 = new JLabel("Puzzle:");
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 751, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(175)
							.addComponent(label))
						.addComponent(label_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(502)
							.addComponent(label_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
	public JButton getMenuButton() {
		return menuBtn;
	}
}
