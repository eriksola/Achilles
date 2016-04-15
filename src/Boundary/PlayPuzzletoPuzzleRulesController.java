package Boundary;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPuzzletoPuzzleRulesController implements ActionListener{
KabasujiFrame frame;
	
	public PlayPuzzletoPuzzleRulesController(KabasujiFrame f) {
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// create rules screen
		RulesPuzzle rules = new RulesPuzzle(frame);
		frame.getContentPane().add(rules, BorderLayout.CENTER);
		frame.getContentPane().revalidate();
		
		// set controller for previous button
		rules.getGameButton().addActionListener(new ReturnToLevelController(frame));
	}	
}
