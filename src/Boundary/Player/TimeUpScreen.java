package Boundary.Player;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Controller.DefLevelMenuToLightningLevelController;
import Game.LightningLevelModel;
import Game.Stock;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Frame to be displayed when the time is up for a lightning level.
 * @author Wolfson
 *
 */
public class TimeUpScreen extends JFrame {

	private JPanel contentPane;
	KabasujiFrame playerFrame;
	LightningLevelModel levelModel;

	/**
	 * Launch the application.
	 */
	void initialize() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeUpScreen frame = new TimeUpScreen();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor.
	 */
	public TimeUpScreen(KabasujiFrame frame, LightningLevelModel llm){
		this.playerFrame = frame;
		this.levelModel = llm;
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	public TimeUpScreen() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTimeIsUp = new JLabel("Time Is Up!");
		
		JButton replayBtn = new JButton("Replay");
		
		JButton mainMenuBtn = new JButton("Main Menu");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(151)
							.addComponent(mainMenuBtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(162)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(replayBtn)
								.addComponent(lblTimeIsUp))))
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblTimeIsUp)
					.addGap(87)
					.addComponent(replayBtn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainMenuBtn)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//activate controllers
		//replayBtn.addActionListener(new DefLevelMenuToLightningLevelController(playerFrame, levelModel));
	}
	public KabasujiFrame getFrame(){
		return this.playerFrame;
	}
}
