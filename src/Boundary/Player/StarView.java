package Boundary.Player;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * StarView is a Jpanel that holds all of the stars that can be obtained by playing a level.
 * @author Sola
 *
 */
public class StarView extends JPanel {

	JLabel stars[] = new JLabel[3];
	int currentStars = 0;

	/**
	 * Constructor. Adds three star labels and initializes them to not visible since they are not yet achieved.
	 */
	public StarView(){	
		this.setBackground(new Color(173, 216, 230));
		for(int i = 0; i < stars.length; i++){
			stars[i] = new JLabel(new ImageIcon("Image/star.png"));
			this.add(stars[i]);
			stars[i].setVisible(false);
		}		
	}
	
	/**
	 * Depending on how many stars we have add that many.
	 */
	public void addStar(){
		
		if(currentStars >= 0 && currentStars < 3){
			currentStars++;
		}
		switch(currentStars){
			case 1:
				this.stars[0].setVisible(true);
				repaint();
				break;
			case 2:
				this.stars[0].setVisible(true);
				this.stars[1].setVisible(true);
				repaint();
				break;
			
			case 3:
				this.stars[0].setVisible(true);
				this.stars[1].setVisible(true);
				this.stars[2].setVisible(true);
				repaint();
				break;
		}
	}
	
	/**
	 * Depending on the score of the level remove a star.
	 */
	public void removeStar(){
		switch(currentStars){
			case 1:
				this.stars[0].setVisible(false);
				repaint();
				break;
			case 2:
				this.stars[1].setVisible(false);
				repaint();
				break;
			
			case 3:
				this.stars[2].setVisible(false);
				repaint();
				break;
		}
		if(currentStars > 0 && currentStars <= 3){
			currentStars--;
		}
		
	}
	
	public int getStars(){
		return currentStars;
	}
}
