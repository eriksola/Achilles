package Boundary;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuToBuiltController implements ActionListener{

	KabasujiFrame frame;
	
	public MenuToBuiltController(KabasujiFrame f) {
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		BuiltLevelPanel builtLvl = new BuiltLevelPanel(frame);
		frame.getContentPane().add(builtLvl, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
		// set controller for previous button
		builtLvl.getMenuButton().addActionListener(new ReturnToMenuController(frame));
		
	}

}
