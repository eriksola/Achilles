package Boundary.Player;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * Rules for the Release level.
 * @author Paul-Henry
 *
 */
public class RulesRelease extends JPanel {

	/**
	 * Create the panel.
	 */
	public RulesRelease() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Back to Game");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("RELEASE RULES");
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		textPane.setEditable(false);
		textPane.setBackground(new Color(173, 216, 230));
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Set amount of pieces to play\nMust cover every number in a color set for points\nCan be rotated or flipped\nArrangement of 6n squares\nPieces cannot overlap\nOnce played they cannot be moved\nGoal is to collect THREE SETS of SIX NUMBERS in DIFFERENT COLORS");
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(173, 216, 230));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 278, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addComponent(button))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}

}
