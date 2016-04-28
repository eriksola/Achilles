package Game;

import java.io.Serializable;
import java.util.ArrayList;

import Boundary.Both.PieceView;

public class BullPen implements Serializable{
	
	ArrayList<Piece> pieces;
	
	public Piece selectedPiece;


	public BullPen(ArrayList<Piece> p){
		this.pieces = p;
	}
	
	public BullPen(){
		this.pieces = new ArrayList<Piece>();
	}

	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	public void addPiece(Piece p){
		this.pieces.add(p);
	}
	
	public boolean removePiece(Piece p){
		return this.pieces.remove(p);
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
}