package Game;

import java.io.Serializable;
import java.util.ArrayList;

import Boundary.Both.PieceView;

/**
 * A BullPen will hold all of the available pieces for a level and change dynamically according to gameplay.
 * @author Achilles
 *
 */
public class BullPen implements Serializable{
	
	ArrayList<Piece> pieces; /** Set of all pieces in a Bullpen **/
	public Piece selectedPiece; /** the piece in the bullpen that is selected (if there is one)**/

	/**
	 * Creates a Bullpen with an array of Pieces.
	 * @param p Given array of pieces.
	 */
	public BullPen(ArrayList<Piece> p){
		this.pieces = p;
		selectedPiece = null;
	}
	
	/**
	 * Creates a BullPen with no pieces inside.
	 */
	public BullPen(){
		this.pieces = new ArrayList<Piece>();
	}
	
	/**
	 * getter function for the selected piece
	 * @return returns the piece in the bullpen thats selected
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}
	/**
	 * getter function for the pieces
	 * @return returns the pieces in the bullpen
	 */
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	/**
	 * Adds a piece to this BullPen. 
	 * @param p Piece given to be added to the BullPen.
	 */
	public void addPiece(Piece p){
		this.pieces.add(p);
	}
	
	/**
	 * Removes a piece from the BullPen.
	 * @param p Piece to be removed from the BullPen.
	 * @return True if piece was removed. 
	 */
	public boolean removePiece(Piece p){
		return this.pieces.remove(p);
	}
	
	/**
	 * sets the selected piece
	 * @param selectedPiece the piece in the bullpen that selected
	 */
	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
}