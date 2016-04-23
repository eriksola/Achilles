package Game;

import java.io.Serializable;

import Boundary.PieceView;

public class BullPen implements Serializable{
	
	Piece[] pieces;
	public Piece selectedPiece;

	public BullPen(Piece[] p){
		this.pieces = p;
	}

	
	/**
	 * rotate the selected piece ninety degrees counterclockwise
	 */
	public void rotateLeft(){
		for(Coordinate c: getSelectedPiece().getCoordinates()){
			int oldX = c.x;
			int oldY = c.y;
			c.x = (-1) * oldY;
			c.y = (1) * oldX;
		}
	}

	/**
	 * rotate the selected piece ninety degrees clockwise
	 */
	public void rotateRight(){
		for(Coordinate c: getSelectedPiece().getCoordinates()){
			int oldX = c.x;
			int oldY = c.y;
			c.x = (1) * oldY;
			c.y = (-1) * oldX;
		}
	}
	
	/**
	 * flip the selected piece over it's x-axis
	 */
	public void verticalFlip(){
		for(Coordinate c: getSelectedPiece().getCoordinates()){
			int oldY = c.y;
			c.y = (-1) * oldY;
		}
	}

	/**
	 * flip the selected piece over it's y-axis
	 */
	public void horizontalFlip(){
		for(Coordinate c: getSelectedPiece().getCoordinates()){
			int oldX = c.x;
			c.x = (-1) * oldX;
		}
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