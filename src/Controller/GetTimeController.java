package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Boundary.Both.KabaSuji;
import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.LevelBuilderLightningPanel;

/**
 * Controller to get the time that is set in the level builder for a lightning level.
 * @author Sola
 *
 */
public class GetTimeController implements ActionListener {

	JTextField time;
	JPanel panel;
	int timeSet;
	KabaSuji view;
	
	/**
	 * Creates a GetTimeController.
	 * @param t JTextField where time is entered.
	 * @param p JPanel where that holds the text field.
	 */
	public GetTimeController(JTextField t, JPanel p, KabaSuji view){
		this.time = t;
		this.panel = p;
		this.view = view;
		
	}
	
	@Override
	/**
	 * Invoked when the set time button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		view.addLevelModel();
		this.timeSet = Integer.parseInt(time.getText());
		
		
		if(panel instanceof LevelBuilderLightningPanel){
			((LevelBuilderLightningPanel)panel).setTime(timeSet);
			((LevelBuilderLightningPanel) panel).addEntity(timeSet);	
		}
		else{
			((EditLightningLevelPanel)panel).setTime(timeSet);
			((EditLightningLevelPanel) panel).addEntity(timeSet);
		}

	}
	
	
	/**
	 * Getter to return the time set by a user for a lightning level
	 * @return time as an int
	 */
	public boolean hasTime(){
		return this.timeSet > 0;
	}
	public int getTime(){
		return this.timeSet;
	}

}
