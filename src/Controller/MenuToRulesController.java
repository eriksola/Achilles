package Boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


public class MenuToRulesController implements ActionListener{
	
	KabasujiFrame frame;
	
	public MenuToRulesController(KabasujiFrame f) {
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		RulesMenuPanel rules = new RulesMenuPanel(frame);
		frame.getContentPane().add(rules, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
		// set controller for previous button
		rules.getMenuButton().addActionListener(new ReturnToPlayerMenuController(frame));
		
	}

}
