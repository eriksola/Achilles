package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Game.Piece;

/**
 * Controller to flip a piece vertically.
 * @author Wolfson
 *
 */
public class VflipController implements ActionListener{

	KabaSuji view;
	
	/**
	 * Creates a Vertical flip controller for a piece. 
	 * Will allow a player to flip a piece when the action is called.
	 * @param view Kabasuji panel where game resides.
	 */
	public VflipController(KabaSuji view){
		this.view = view;
	}
	
	/**
	 * Invoked when the vertical flip button is called.
	 */
	public void actionPerformed(ActionEvent e){
		//check if selected piece is in bullpen (otherwise moves not allowed)
		PieceView selected = view.getSelectedPiece();
		if (selected != null){
			view.addLevelModel();
			Piece p = selected.getP();
			p.verticalFlip();
			selected.drawSelected();
		}
	}
	
}