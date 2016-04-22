package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.BullPen;
import Game.Stock;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class KabasujiFrame extends JFrame {
	
	JPanel contentPane;
	Stock stock;
	int builtPuzzles = 0;
	int builtLightning = 0;
	int builtRelease = 0;
	boolean builtLevels = false;
	

	public KabasujiFrame(Stock s){
		this.stock = s;
		initialize();
		builtLevels = hasBuiltLevels();
	}

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
	KabasujiFrame() {
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
	}
	
	void initialize(){
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
	 * 
	 * @return true if there are built levels, will also set number of built levels
	 */
	public boolean hasBuiltLevels() {
		
		this.builtPuzzles = new File("./src/BuiltLevels/PuzzleLevels").list().length;
		this.builtLightning = new File("./src/BuiltLevels/LightningLevels").list().length;
		this.builtRelease = new File("./src/BuiltLevels/ReleaseLevels").list().length;
		
		return builtPuzzles > 0 || builtLightning > 0 || builtRelease > 0;
	}
}
