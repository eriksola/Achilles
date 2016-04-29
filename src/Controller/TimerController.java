package Controller;


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
import Boundary.Player.LightningLevelPanel;
import Boundary.Player.TimeUpScreen;

/**
 * 
 * @author gaguila
 *
 */
public class TimerController implements ActionListener{
	
	KabasujiFrame frame;
	LightningLevelPanel view; /** the top level boundary object **/
	JTextArea timerView; /** the swing element displaying the time left **/
	int timeLeft; /** time left on the timer CURRENTLY **/
	Timer t;
	
	public TimerController(KabasujiFrame frame, LightningLevelPanel view, JTextArea tp, int tg){
		this.frame = frame;
		this.view = view;
		this.timerView = tp;
		this.timeLeft = tg;
		
		//set the swing element to display the time given
		timerView.invalidate();
		String stringTime = Integer.toString(timeLeft);
		timerView.setText(stringTime);
		timerView.revalidate();
		
		t = new Timer(1000, this);
		t.start();
	}

	@Override
	/**
	 * set a selected PieceView.
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
			timerView.setText(stringTimeLeft);
		
			timerView.revalidate();
		}
		//if there is no time left, open a new window and stop play
		else {
			t.stop();
			TimeUpScreen timeUp = new TimeUpScreen(frame, view.getInitial());
			timeUp.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frame.dispose();
				}      
			});
		}
	}
}
