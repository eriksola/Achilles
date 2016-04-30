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
 * Rules for the lightning level.
 * @author Paul-Henry
 *
 */
public class RulesLightning extends JPanel {

	/**
	 * Create the panel.
	 */
	public RulesLightning() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Back to Game");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("LIGHTNING RULES");
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		textPane.setEditable(false);
		textPane.setBackground(new Color(173, 216, 230));
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Randomly generated pieces\nPieces can overlap\nLimited amount of time\nTry to cover the entire board\nPieces can be rotated and flipped");
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(173, 216, 230));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(114)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 278, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}

}
