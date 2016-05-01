package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.DefaultLevelPanel;
import Boundary.Player.KabasujiFrame;

/**
 * Controller to return a player to the default menu.
 * @author Aguila
 *
 */
public class ReturnToDefMenuController implements ActionListener{

	KabasujiFrame frame;

	/**
	 * Creates a ReturnToDefMenuController that will change to the correct panel with a given frame.
	 * @param kf Frame where the game is currently held.
	 */	
	public ReturnToDefMenuController(KabasujiFrame kf){
		this.frame = kf;
	}

	/**
	 * Invoked when the button is pressed to return to the level.
	 */
	public void actionPerformed(ActionEvent e) {
		
		//remove the rules menu JPanel from the JFrame
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// return the main menu JPanel to the JFrame
		DefaultLevelPanel defLvl = new DefaultLevelPanel(frame);
		frame.getContentPane().add(defLvl, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}
}
