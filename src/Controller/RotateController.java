package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Game.Piece;

/**
 * Controller to rotate a piece 90 degrees.
 * @author Wolfson
 *
 */
public class RotateController implements ActionListener{

	KabaSuji view;
	
	/**
	 * Creates a rotate controller.
	 * @param view Kabasuji panel that the rotate controller will be used.
	 */
	public RotateController(KabaSuji view){
		this.view = view;
	}
	
	/**
	 * Invoked when the 90 degree button is pressed.
	 * Once invoked the piece will be rotated 90 degrees.
	 */
	public void actionPerformed(ActionEvent e){
		//check if selected piece is in bullpen (otherwise moves not allowed)
		PieceView selected = view.getSelectedPiece();
		if(selected != null){
			view.addLevelModel();
			Piece p = selected.getP();
			p.rotateRight();
			selected.drawSelected();
		}
	}
	
}