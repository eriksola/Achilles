package Boundary.Player;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.BullPen;
import Game.IScore;
import Game.LevelModel;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.Stock;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

/**
 * JFrame to hold any panel in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class KabasujiFrame extends JFrame {
	
	JPanel contentPane;
	Stock stock;
	int builtPuzzles = 0;
	int builtLightning = 0;
	int builtRelease = 0;
	int defaultPuzzles = 0;
	int defaultLightning = 0;
	int defaultRelease = 0;
	boolean builtLevels = false;
	boolean defaultLevels = false;

	public int getBuiltPuzzles() {
		return this.builtPuzzles;
	}
	public int getBuiltLightning() {
		return this.builtLightning;
	}
	public int getBuiltRelease() {
		return this.builtRelease;
	}
	
	public boolean hasLevels(){
		return this.builtLevels;
	}
	/**
	 * Create the frame.
	 */
	public KabasujiFrame() {
		setBackground(new Color(173, 216, 230));
		setForeground(new Color(173, 216, 230));
		setTitle("Kabasuji");
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
		MainMenuPanel mainMenu = new MainMenuPanel(this);
		mainMenu.setBackground(new Color(173, 216, 230));
		mainMenu.setVisible(true);
		getContentPane().add(mainMenu);
		
		builtLevels = hasBuiltLevels();
		defaultLevels = hasDefaultLevels();
	}
	
	/**
	 * Initialize the game with the main menu panel.
	 */
	public void initialize(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KabasujiFrame frame = new KabasujiFrame();
					MainMenuPanel main = new MainMenuPanel(frame);
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
	 * Checks to see if there are any built levels to be imported.
	 * @return true if there are built levels, will also set number of built levels
	 */
	public boolean hasBuiltLevels() {
		
		this.builtPuzzles = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		this.builtLightning = new File("./src/BuiltLevels/LightningLevels").list().length;
		this.builtRelease = new File("./src/BuiltLevels/ReleaseLevels").list().length;
		boolean hasBuiltLvl = builtPuzzles > 0 || builtLightning > 0 || builtRelease > 0;
		return hasBuiltLvl;
	}
	
	public boolean hasDefaultLevels() {
		
		this.defaultPuzzles = new File("./src/DefaultLevels/PuzzleLevels").list().length;
		this.defaultLightning = new File("./src/DefaultLevels/LightningLevels").list().length;
		this.defaultRelease = new File("./src/DefaultLevels/ReleaseLevels").list().length;
		boolean hasDefaultLvl = defaultPuzzles > 0 || defaultLightning > 0 || defaultRelease > 0;
		return hasDefaultLvl;
	}

	public void endLevel(LevelModel initialModel, IScore score) {
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		LevelEndPanel levelEnd = new LevelEndPanel(this, initialModel, score);
		getContentPane().add(levelEnd, BorderLayout.CENTER);
		getContentPane().revalidate();
		
		
	}
}
