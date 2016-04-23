package Boundary;

import javax.swing.JPanel;

/**
 * Top-level boundary object for both the builder and player.
 * @author bwolfson
 *
 */

public class KabaSuji extends JPanel {
	
	PieceView selectedPiece; /** the one selected piece. **/
	
	/**
	 * start with no PieceView selected.
	 */
	public KabaSuji(){
		selectedPiece = null;
	}

	/**
	 * set a selected PieceView.
	 * @param pv the PieceView to select
	 */
	public void setSelected(PieceView pv){
		pv.drawSelected();
		this.selectedPiece = pv;
	}
	
	/**
	 * set a PieceView unselected.
	 * @param pv
	 */
	public void setUnselected(PieceView pv){
		selectedPiece.drawUnselected();
		this.selectedPiece = pv;
	}

	/**
	 * get the selected PieceView
	 * @return
	 */
	public PieceView getSelectedPiece(){
		return this.selectedPiece;
	}
}
