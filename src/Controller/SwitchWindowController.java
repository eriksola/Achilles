package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Boundary.Builder.LevelBuilderBuiltLevelPanel;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderLightningPanel;
import Boundary.Builder.LevelBuilderMainMenuPanel;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Builder.LevelBuilderReleasePanel;
import Boundary.Player.BuiltLevelPanel;
import Boundary.Player.DefaultLevelPanel;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.RulesMenuPanel;

/**
 * 
 * Controller to switch a panel on one frame from one panel to another.
 * @author Sola
 *
 */
public class SwitchWindowController implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	
	/**
	 * Creates a SwitchWindowController to switch a window from one panel to another.
	 * @param mainFrame Current frame the previous panel is in.
	 * @param levelBuilderPanel Panel that we want to switch to.
	 */
	public SwitchWindowController(JFrame mainFrame, JPanel levelBuilderPanel) {
		this.frame = mainFrame;
		this.panel = levelBuilderPanel;
	}

	/**
	 * Invoked when a button is pressed that is meant to go from one panel to another.
	 */
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		if(panel instanceof LevelBuilderPuzzlePanel){
			LevelBuilderPuzzlePanel p = new LevelBuilderPuzzlePanel(frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof LevelBuilderLightningPanel){
			LevelBuilderLightningPanel p = new LevelBuilderLightningPanel(frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof LevelBuilderReleasePanel){
			LevelBuilderReleasePanel p = new LevelBuilderReleasePanel(frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof DefaultLevelPanel){
			DefaultLevelPanel p = new DefaultLevelPanel((KabasujiFrame)frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof RulesMenuPanel){
			RulesMenuPanel p = new RulesMenuPanel((KabasujiFrame)frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof BuiltLevelPanel){
			BuiltLevelPanel p = new BuiltLevelPanel((KabasujiFrame)frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof LevelBuilderMainMenuPanel){
			LevelBuilderMainMenuPanel p = new LevelBuilderMainMenuPanel((LevelBuilderFrame)frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		else if(panel instanceof LevelBuilderBuiltLevelPanel){
			LevelBuilderBuiltLevelPanel p = new LevelBuilderBuiltLevelPanel((LevelBuilderFrame)frame);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
	}

}
