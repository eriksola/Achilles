package Game;

import java.io.Serializable;
import java.util.ArrayList;

import Boundary.PieceView;

public class BullPen implements Serializable{
	
	LevelModel model;
	ArrayList<Piece> pieces;
	
	public Piece selectedPiece;


	public BullPen(LevelModel m, ArrayList<Piece> p){
		this.model = m;
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

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	public LevelModel getModel(){
		return this.model;
	}
	
	public void setModel(LevelModel m){
		this.model = m;
	}
	
}