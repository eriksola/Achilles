package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.Board;
import Game.Stock;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class LevelBuilderFrame extends JFrame {
	
	JPanel contentPane;
	int puzzleLevelCount = 0;
	int lightningLevelCount = 0;
	int releaseLevelCount = 0;
	boolean builtLevels = false;
	Stock stock;
	
	/**
	 * Launch the application.
	 */
	
	public LevelBuilderFrame(Stock s){
		this.stock = s;
		initialize();
		builtLevels = hasBuiltLevels();	
	}
	
	public int getPuzzleLevelCount() {
		return this.puzzleLevelCount;
	}
	public int getLightningLevelCount() {
		return this.lightningLevelCount;
	}
	public int getReleaseLevelCount() {
		return this.releaseLevelCount;
	}
	
	public void setPuzzleLevelCount(int puzzleLevelCount) {
		this.puzzleLevelCount = puzzleLevelCount;
	}

	public void setLightningLevelCount(int lightningLevelCount) {
		this.lightningLevelCount = lightningLevelCount;
	}

	public void setReleaseLevelCount(int releaseLevelCount) {
		this.releaseLevelCount = releaseLevelCount;
	}
	
	/**
	 * Create the frame.
	 */
	LevelBuilderFrame() {
		setBackground(new Color(173, 216, 230));
		setForeground(new Color(173, 216, 230));
		setTitle("LevelBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 579);
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
	
	void initialize(){
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
	 * 
	 * @return true if there are built levels, will also set number of built levels
	 */
	public boolean hasBuiltLevels() {
		
		this.puzzleLevelCount = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		this.lightningLevelCount = new File("./src/BuiltLevels/LightningLevels").list().length;
		this.releaseLevelCount = new File("./src/BuiltLevels/ReleaseLevels").list().length;
		
		return puzzleLevelCount > 0 || lightningLevelCount > 0 || releaseLevelCount > 0;
	}
}
