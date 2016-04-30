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
 * Rules for the Puzzle Level.
 * @author Paul-Henry
 *
 */
public class RulesPuzzle extends JPanel {

	KabasujiFrame mainframe;
	JButton gameBtn;
	/**
	 * Create the panel.
	 */
	public RulesPuzzle(KabasujiFrame f) {
		
		this.mainframe = f;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Back to Game");
		this.gameBtn = button;
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Pieces can be placed\nCan be rotated or flipped\nArrangement of 6n squares\nPieces can be placed anywhere within the bounds of the board\nLimited amount of moves\nPieces cannot overlap");
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setEditable(false);
		textPane.setBackground(new Color(173, 216, 230));
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("PUZZLE RULES");
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(173, 216, 230));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(140, Short.MAX_VALUE)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 278, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		panel.setLayout(gl_panel);

	}
	public JButton getGameButton(){
		return gameBtn;
	}
}
