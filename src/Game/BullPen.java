package Game;

import java.io.Serializable;

import Boundary.PieceView;

public class BullPen implements Serializable{
	
	LevelModel model;
	Piece[] pieces;
	public Piece selectedPiece;

	public BullPen(LevelModel m, Piece[] p){
		this.model = m;
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
	
	public LevelModel getModel(){
		return this.model;
	}
	
	public void setModel(LevelModel m){
		this.model = m;
	}
	
}