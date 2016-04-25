package Controller;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Boundary.KabaSuji;
import Boundary.LevelBuilderPuzzlePanel;
import Boundary.PieceView;

/**
 * Controller class for Pieces - main function is highlighting a selected Piece.
 * @author bwolfson
 *
 */
public class PieceController extends java.awt.event.MouseAdapter{
	
	KabaSuji view; /** the main KabaSuji view. **/
	PieceView pv; /** the view of the Piece being controlled. **/
	
	/**
	 * Constructor.
	 * @param view
	 * @param pv
	 */
	public PieceController(KabaSuji view, PieceView pv){
		this.view = view;
		this.pv = pv;
	}
	
	/**
	 * highlight the clicked PieceView, unmark previously selected PieceView if present.
	 */
	public void mouseClicked(MouseEvent me){
		System.out.println("mouse clicked");
		System.out.println(pv);
		view.setSelected(pv);
	}
}