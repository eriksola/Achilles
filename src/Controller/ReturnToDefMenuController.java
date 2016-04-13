package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.DefaultLevelPanel;
import Boundary.KabasujiFrame;

public class ReturnToDefMenuController implements ActionListener{

	KabasujiFrame frame;

	
	public ReturnToDefMenuController(KabasujiFrame kf){
		this.frame = kf;
	}

	@Override
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
