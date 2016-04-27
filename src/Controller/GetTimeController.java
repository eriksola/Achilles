package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.LevelBuilderLightningPanel;

public class GetTimeController implements ActionListener {

	JTextField time;
	JPanel panel;
	int timeSet;
	
	public GetTimeController(JTextField t, JPanel p){
		this.time = t;
		this.panel = p;
		this.timeSet = 0;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.timeSet = Integer.parseInt(time.getText());
		
		if(panel instanceof LevelBuilderLightningPanel){
			((LevelBuilderLightningPanel) panel).addEntity(timeSet);	
		}
		else{
			((EditLightningLevelPanel) panel).addEntity(timeSet);
		}
		
	}
	
	
	/**
	 * Getter to return the time set by a user for a lightning level
	 * @return time as an int
	 */
	public int getTime(){
		return this.timeSet;
	}

}
