package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Boundary.DefaultLevelPanel;
import Boundary.KabasujiFrame;
import Boundary.LevelBuilderFrame;
import Boundary.LevelBuilderMainMenuPanel;

public class ReturnToBuilderMenuController implements ActionListener{

	LevelBuilderFrame frame;

	
	public ReturnToBuilderMenuController(LevelBuilderFrame kf){
		this.frame = kf;
	}

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
