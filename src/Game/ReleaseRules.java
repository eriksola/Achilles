package Game;

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

public class ReleaseRules extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReleaseRules frame = new ReleaseRules();
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
	public ReleaseRules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBackToGame = new JButton("Back to Game");
		
		JTextPane txtpnReleaseRules = new JTextPane();
		txtpnReleaseRules.setEditable(false);
		txtpnReleaseRules.setForeground(Color.WHITE);
		txtpnReleaseRules.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		txtpnReleaseRules.setBackground(Color.BLUE);
		txtpnReleaseRules.setText("RELEASE RULES");
		
		JTextPane txtpnAdsad = new JTextPane();
		txtpnAdsad.setEditable(false);
		txtpnAdsad.setBackground(Color.BLUE);
		txtpnAdsad.setForeground(Color.WHITE);
		txtpnAdsad.setText("Set amount of pieces to play\nMust cover every number in a color set for points\nCan be rotated or flipped\nArrangement of 6n squares\nPieces cannot overlap\nOnce played they cannot be moved\nGoal is to collect THREE SETS of SIX NUMBERS in DIFFERENT COLORS");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBackToGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnReleaseRules, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(txtpnAdsad, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(btnBackToGame))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(txtpnReleaseRules, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnAdsad, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
