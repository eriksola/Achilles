package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;

public class KabasujiMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KabasujiMainMenu frame = new KabasujiMainMenu();
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
	public KabasujiMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 485);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblDesignedByNan = new JLabel("Designed by: Nan Zhang, Giovanni Aguila, Barry Wolfson, "
				+ "Paul-Henry Schoehagen, & Erik Sola");
		lblDesignedByNan.setForeground(Color.WHITE);
		
		JButton btnOurLevels = new JButton("Our Levels");
		
		JButton btnYourLevels = new JButton("Your Levels");
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblKabasuji.setForeground(Color.WHITE);
		
		JButton btnRules = new JButton("Rules");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(133, Short.MAX_VALUE)
					.addComponent(lblDesignedByNan)
					.addGap(71))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(241)
					.addComponent(btnOurLevels)
					.addGap(70)
					.addComponent(btnYourLevels)
					.addContainerGap(240, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(330)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRules)
						.addComponent(lblKabasuji))
					.addContainerGap(342, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(btnRules)
					.addGap(35)
					.addComponent(lblKabasuji)
					.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOurLevels)
						.addComponent(btnYourLevels))
					.addGap(27)
					.addComponent(lblDesignedByNan)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
