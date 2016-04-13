package Boundary;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuToDefaultController implements ActionListener{

	KabasujiFrame frame;
	
	public MenuToDefaultController(KabasujiFrame f) {
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		DefaultLevelPanel defLvl = new DefaultLevelPanel(frame);
		frame.getContentPane().add(defLvl, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
		// set controller for previous button
		defLvl.getMenuButton().addActionListener(new ReturnToMenuController(frame));
		
	}

}
