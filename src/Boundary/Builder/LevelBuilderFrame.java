package Boundary.Builder;

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

/**
 * Frame that holds any panel that may be used in the <b> LevelBuilder. </b>
 * @author Achilles
 *
 */
public class LevelBuilderFrame extends JFrame {
	
	JPanel contentPane; /** boundary shown in the frame of the app **/
	int puzzleLevelCount = 0; /** number of puzzle levels built, initialized to 0 **/
	int lightningLevelCount = 0; /** number of lightning levels built, initialized to 0 **/
	int releaseLevelCount = 0;  /** number of release levels built, initialized to 0 **/
	boolean builtLevels = false; /** true if there is at least one built level **/
	Stock stock;
	
	/**
	 * Launch the application.
	 */
	public LevelBuilderFrame(Stock s){
		this.stock = s;
		initialize();
		builtLevels = hasBuiltLevels();	
	}
	
	/**
	 * getter function for puzzleLevelCount
	 * @return the number of saved puzzle levels
	 */
	public int getPuzzleLevelCount() {
		return this.puzzleLevelCount;
	}
	/**
	 * getter function of lightningLevelCount
	 * @return the number of saved puzzle levels
	 */
	public int getLightningLevelCount() {
		return this.lightningLevelCount;
	}
	
	/**
	 * getter function of releaseLevelCount
	 * @return the number of saved release levels
	 */
	public int getReleaseLevelCount() {
		return this.releaseLevelCount;
	}
	
	/**
	 * Sets the number of saved puzzle levels
	 * @param puzzleLevelCount number of levels
	 */
	public void setPuzzleLevelCount(int puzzleLevelCount) {
		this.puzzleLevelCount = puzzleLevelCount;
	}
	
	/**
	 * Sets the number of saved lightning levels
	 * @param lightningLevelCount number of levels
	 */
	public void setLightningLevelCount(int lightningLevelCount) {
		this.lightningLevelCount = lightningLevelCount;
	}

	/**
	 * Sets the number of saved release levels
	 * @param releaseLevelCount number of levels
	 */
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
	
	/**
	 * initializes the LevelBuilder frame and the main menu panel
	 */
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
	 * Checks if there are any built levels in the directories.
	 * @return true if there are built levels, will also set number of built levels.
	 */
	public boolean hasBuiltLevels() {
		
		this.puzzleLevelCount = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		this.lightningLevelCount = new File("./src/BuiltLevels/LightningLevels").list().length;
		this.releaseLevelCount = new File("./src/BuiltLevels/ReleaseLevels").list().length;
		
		return puzzleLevelCount > 0 || lightningLevelCount > 0 || releaseLevelCount > 0;
	}
}
