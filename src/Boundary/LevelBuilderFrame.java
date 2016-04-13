package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class LevelBuilderFrame extends JFrame {
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderFrame frame = new LevelBuilderFrame();
					LevelBuilderMainMenuPanel main = new LevelBuilderMainMenuPanel(frame);
					frame.setVisible(true);
					frame.getContentPane().setLayout(new BorderLayout());
					frame.getContentPane().add(main, BorderLayout.CENTER);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelBuilderFrame() {
		setBackground(new Color(173, 216, 230));
		setForeground(new Color(173, 216, 230));
		setTitle("LevelBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 741, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 428, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		LevelBuilderMainMenuPanel mainMenu = new LevelBuilderMainMenuPanel(this);
		mainMenu.setBackground(new Color(173, 216, 230));
		mainMenu.setVisible(true);
		getContentPane().add(mainMenu);
	}
	
	
}
