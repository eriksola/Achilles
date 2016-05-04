
package Boundary.Both;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Game.BullPen;
import Game.LevelModel;


/**
 * Top-level boundary object for both the builder and player.
 * @author bwolfson
 *
 */
public abstract class KabaSuji extends JPanel {
	
	protected PieceView selectedPiece; /** the one selected piece. **/

	
	/**
	 * get the scroll pane for the BullPen.
	 * @return scroll pane for BullPen.
	 */
	public abstract JScrollPane getScrollPane();
	
	/**
	 * get the BoardView.
	 * @return the BoardView.
	 */
	public abstract BoardView getBoardView();
	
	/**
	 * get the BullPenView.
	 * @return the BullPenView.
	 */
	public abstract BullPenView getBullPenView();
	
	/**
	 * set a selected PieceView.
	 * @param pv the PieceView to select
	 */
	public void setSelected(PieceView pv){
		if (pv != null){
			if(selectedPiece == pv){
				removeSelected();
			}
			if(selectedPiece != null){
				selectedPiece.drawUnselected();
				selectedPiece = pv;
				selectedPiece.drawSelected();
			}
			else{
				selectedPiece = pv;
				selectedPiece.drawSelected();
			}
		}
	}
	
	/**
	 * remove the currently selected piece.
	 */
	public void removeSelected(){
		selectedPiece.drawUnselected();
		selectedPiece = null;
	}
	/**
	 * get the selected PieceView
	 * @return
	 */
	public PieceView getSelectedPiece(){
		return this.selectedPiece;
	}
	

}