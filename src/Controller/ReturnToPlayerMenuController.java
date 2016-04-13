package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.KabasujiFrame;
import Boundary.MainMenuPanel;

public class ReturnToPlayerMenuController implements ActionListener{
	
	KabasujiFrame frame;

	
	public ReturnToPlayerMenuController(KabasujiFrame kf){
		this.frame = kf;
	}

	@Override
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
