import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class LightningRules extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningRules frame = new LightningRules();
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
	public LightningRules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBackToGame = new JButton("Back to Game");
		
		JTextPane txtpnLightningRules = new JTextPane();
		txtpnLightningRules.setEditable(false);
		txtpnLightningRules.setForeground(Color.WHITE);
		txtpnLightningRules.setBackground(Color.BLUE);
		txtpnLightningRules.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		txtpnLightningRules.setText("LIGHTNING RULES");
		
		JTextPane txtpnRandomlyGeneratedPieces = new JTextPane();
		txtpnRandomlyGeneratedPieces.setEditable(false);
		txtpnRandomlyGeneratedPieces.setForeground(Color.WHITE);
		txtpnRandomlyGeneratedPieces.setBackground(Color.BLUE);
		txtpnRandomlyGeneratedPieces.setText("Randomly generated pieces\nPieces can overlap\nLimited amount of time\nTry to cover the entire board\nPieces can be rotated and flipped");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBackToGame)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addComponent(txtpnLightningRules, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(txtpnRandomlyGeneratedPieces, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBackToGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnLightningRules, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnRandomlyGeneratedPieces, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
