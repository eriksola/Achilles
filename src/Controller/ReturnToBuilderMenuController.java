package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderMainMenuPanel;
import Boundary.Player.DefaultLevelPanel;
import Boundary.Player.KabasujiFrame;

/**
 * Controller to return a builder to the main menu.
 * @author Aguila
 *
 */
public class ReturnToBuilderMenuController implements ActionListener{

	LevelBuilderFrame frame;

	/**
	 * Creates a ReturnToBuilderMenuController that will change to the correct panel with a given frame.
	 * @param kf Frame where the game is currently held.
	 */
	public ReturnToBuilderMenuController(LevelBuilderFrame kf){
		this.frame = kf;
	}
	
	/**
	 * Invoked when the button is pressed to return to the main menu.
	 */
	public void actionPerformed(ActionEvent e) {
		
		//remove the rules menu JPanel from the JFrame
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// return the main menu JPanel to the JFrame
		LevelBuilderMainMenuPanel builderMenu = new LevelBuilderMainMenuPanel(frame);
		frame.getContentPane().add(builderMenu, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}

}
