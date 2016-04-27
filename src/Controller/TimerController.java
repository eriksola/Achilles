package Controller;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Boundary.Player.KabasujiFrame;

/**
 * 
 * @author gaguila
 *
 */
public class TimerController implements ActionListener{
	
	KabasujiFrame mainframe; /** the top level boundary object **/
	JTextArea timerView; /** the swing element displaying the time left **/
	int timeGiven; /** total time given **/
	int timeLeft; /** time left on the timer CURRENTLY **/
	
	public TimerController(KabasujiFrame mf, JTextArea tp, int tg){
		this.mainframe = mf;
		this.timerView = tp;
		this.timeGiven = tg;
		this.timeLeft = this.timeGiven;
		
		//set the swing element to display the time given
		mainframe.getContentPane().invalidate();
		String stringTime = Integer.toString(timeGiven);
		timerView.setText(stringTime);
		mainframe.getContentPane().revalidate();
	}

	@Override
	/**
	 * set a selected PieceView.
	 * @param arg0 the actionEvent that triggers the method (in this case a swing Timer)
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		--timeLeft;
		
		mainframe.getContentPane().invalidate();
		
		//if less than 20 seconds left, change color of numbers to red
		if (timeLeft < 20) { timerView.setForeground( new Color(255,0,0)); }
		
		//update timeLeft and print to JTextArea
		String stringTimeLeft = Integer.toString(timeLeft);
		timerView.setText(stringTimeLeft);
		
		mainframe.getContentPane().revalidate();
		
	}
}
