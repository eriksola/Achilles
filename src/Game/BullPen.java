package Game;

import java.io.Serializable;

import Boundary.PieceView;

public class BullPen implements Serializable{
	
	Piece[] pieces;
	public Piece selectedPiece;

	public BullPen(Piece[] p){
		this.pieces = p;
	}

	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	public Piece[] getPieces(){
		return this.pieces;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}


	public Piece[] setPieces(Piece[] p){
		return this.pieces = p;
	}
	
	
	
}