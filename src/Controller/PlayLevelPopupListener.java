package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Boundary.Builder.EditDeletePopup;
import Boundary.Player.PlayLevelPopup;

public class PlayLevelPopupListener extends MouseAdapter{
	
	PlayLevelPopup play;
	
	public PlayLevelPopupListener(PlayLevelPopup playLevel){
		this.play = playLevel;
	}
	
	/**
	 * When the mouse is pressed. 
	 */
	public void mousePressed(MouseEvent event){
        if (event.isPopupTrigger())
            doPop(event);
    }

	/**	
	 * When the mouse is released.
	 */
    public void mouseReleased(MouseEvent event){
        if (event.isPopupTrigger())
            doPop(event);
    }

    /**
     * The actual pop up that is displayed.
     * @param event
     */
    public void doPop(MouseEvent event){
        play.show(event.getComponent(), event.getX(), event.getY());
    }
}
