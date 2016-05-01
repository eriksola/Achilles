package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Boundary.Builder.EditDeletePopup;

/**
 * Listener to show a right click on a level so a builder can then edit or delete it.
 * @author Sola
 *
 */
public class EditDeletePopupListener extends MouseAdapter {

	EditDeletePopup e;
	
	/**
	 * Constructor.
	 * @param editOrDelete EditDeletePopup class that holds logic for actions.
	 */
	public EditDeletePopupListener(EditDeletePopup editOrDelete){
		this.e = editOrDelete;
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
        e.show(event.getComponent(), event.getX(), event.getY());
    }
        
}
