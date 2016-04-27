package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Boundary.Builder.EditDeletePopup;

public class EditDeletePopupListener extends MouseAdapter {

	EditDeletePopup e;
	
	public EditDeletePopupListener(EditDeletePopup editOrDelete){
		this.e = editOrDelete;
	}
	public void mousePressed(MouseEvent event){
        if (event.isPopupTrigger())
            doPop(event);
    }

    public void mouseReleased(MouseEvent event){
        if (event.isPopupTrigger())
            doPop(event);
    }

    public void doPop(MouseEvent event){
        e.show(event.getComponent(), event.getX(), event.getY());
    }
        
}
