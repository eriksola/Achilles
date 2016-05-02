package Controller;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Boundary.Both.KabaSuji;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.LevelEndPanel;
import Boundary.Player.LightningLevelPanel;
import Boundary.Player.TimesUpPanel;
import Game.IScore;

/**
 * 
 * Allows the functionality of a timer for a lightning level.
 * @author gaguila
 *
 */
public class TimerController implements ActionListener{
	
	KabasujiFrame frame; /** the frame for the entire app **/
	LightningLevelPanel view; /** the top level boundary panel **/
	JTextArea timerView; /** the swing element displaying the time left **/
	int timeLeft; /** time left on the timer  **/
	Timer t; /** The swing entity which triggers the controller **/
	
	/**
	 * Creates a timer controller that will set a countdown time for a lightning level.
	 * @param frame Frame that the level is currently in.
	 * @param view LightningLevelPanel the timer is in.
	 * @param tp Text where timer will be.
	 * @param tg Amount of time given for a timer.
	 */
	public TimerController(KabasujiFrame frame, LightningLevelPanel view, JTextArea tp, int tg){
		this.frame = frame;
		this.view = view;
		this.timerView = tp;
		this.timeLeft = tg;
		
		//set the swing element to display the time given
		timerView.invalidate();
		String stringTime = Integer.toString(timeLeft);
		timerView.setText("Time Left: " + stringTime);
		timerView.revalidate();
		
		t = new Timer(1000, this);
		t.start();
	}

	@Override
	/**
	 * Sets a selected PieceView.
	 * @param arg0 the actionEvent that triggers the method (in this case a swing Timer)
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		--timeLeft;
		
		//if there is time left, update the timer view
		if (timeLeft >= 0){
			
			timerView.invalidate();
			
			//if less than 20 seconds left, change color of numbers to red
			if (timeLeft < 20) { timerView.setForeground( new Color(255,0,0)); }
		
			//update timeLeft and print to JTextArea
			String stringTimeLeft = Integer.toString(timeLeft);
			timerView.setText("Time Left: " + stringTimeLeft);
		
			timerView.revalidate();
		}
		
		//if there is no time left, stop play and switch to the "Times Up" screen
		else {
			
			t.stop();
			IScore currentScore = view.getCurrent().getScore();
			LevelEndPanel levelEnd = new LevelEndPanel(frame, view.getInitial(), currentScore);
			
			frame.getContentPane().removeAll();
			frame.getContentPane().invalidate();
			
			frame.getContentPane().add(levelEnd, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
	}
}
