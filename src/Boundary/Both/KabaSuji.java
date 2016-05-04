
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
	 * start with no PieceView selected.
	 */
	
	public abstract BoardView getBoardView(); /** the BoardView for the builder/player **/
	public abstract BullPenView getBullPenView(); /** the BullPenView for the builder/player **/
	public abstract JScrollPane getScrollPane(); /** the scrollpane for the BullPenView **/
	
	/**
	 * set a selected PieceView.
	 * @param pv the PieceView to select
	 */
	public void setSelected(PieceView pv){
		if (pv != null){

			System.out.println(pv.getP().getCoordinates());

			if(selectedPiece == pv){
				removeSelected();
			}
			else if(selectedPiece != null){
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
	 * removes the selected PieceView
	 */
	public void removeSelected(){
		selectedPiece.drawUnselected();
		selectedPiece = null;
	}
	/**
	 * get the selected PieceView
	 * @return the pieceview
	 */
	public PieceView getSelectedPiece(){
		return this.selectedPiece;
	}
	

}