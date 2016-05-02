
package Boundary.Both;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Top-level boundary object for both the builder and player.
 * @author bwolfson
 *
 */

public abstract class KabaSuji extends JPanel {
	
	PieceView selectedPiece; /** the one selected piece. **/
	
	/**
	 * start with no PieceView selected.
	 */
	public KabaSuji(){
		selectedPiece = null;
	}
	
	public abstract JScrollPane getScrollPane();
	public abstract BoardView getBoardView();
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