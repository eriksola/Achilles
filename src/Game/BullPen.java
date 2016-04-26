package Game;

import java.io.Serializable;
import java.util.ArrayList;

import Boundary.PieceView;

public class BullPen implements Serializable{
	
	ArrayList<Piece> pieces;
	public Piece selectedPiece;

	public BullPen(){
		this.pieces = new ArrayList<Piece>();
	}

	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	
	
}