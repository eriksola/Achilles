package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.MainMenuPanel;

/**
 * Controller to return a player to the player menu.
 * @author Aguila
 *
 */
public class ReturnToPlayerMenuController implements ActionListener{
	
	KabasujiFrame frame;

	/**
	 * Creates a ReturnToPlayerMenuController that will change to the correct panel with a given frame.
	 * @param kf Frame where the game is currently held.
	 */
	public ReturnToPlayerMenuController(KabasujiFrame kf){
		this.frame = kf;
	}

	/**
	 * Invoked when the button is pressed to return to the player menu.
	 */
	public void actionPerformed(ActionEvent e) {
		
		//remove the rules menu JPanel from the JFrame
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// return the main menu JPanel to the JFrame
		MainMenuPanel main = new MainMenuPanel(frame);
		frame.getContentPane().add(main, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
	}
}
