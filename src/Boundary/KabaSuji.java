
package Boundary;

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

	/**
	 * set a selected PieceView.
	 * @param pv the PieceView to select
	 */
	public void setSelected(PieceView pv){
		if(selectedPiece != null){
			selectedPiece.drawUnselected();
		}
		selectedPiece = pv;
		if(pv != null){
			selectedPiece.drawSelected();
		}
	}
	
	/**
	 * get the selected PieceView
	 * @return
	 */
	public PieceView getSelectedPiece(){
		return this.selectedPiece;
	}
}