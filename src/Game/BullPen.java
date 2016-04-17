package Game;

import View.PieceView;

public class BullPen {
	
	Piece[] pieces;
	private PieceView[] pvs;
	public Piece selectedPiece;

	public BullPen(Piece[] p, PieceView[] pvs){
		this.pieces = p;
		this.setPvs(pvs);
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
		//look for corresponding PieceView and update BufferedImage
		PieceView pv = null;
		for(PieceView view: getPvs()){
			if(view.getP() == getSelectedPiece()){
				pv = view;
			}
		}
		pv.draw();
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
		//look for corresponding PieceView and update BufferedImage
		PieceView pv = null;
		for(PieceView view: getPvs()){
			if(view.getP() == getSelectedPiece()){
				pv = view;
			}
		}
		pv.draw();
	}
	
	/**
	 * flip the selected piece over it's x-axis
	 */
	public void verticalFlip(){
		for(Coordinate c: getSelectedPiece().getCoordinates()){
			int oldY = c.y;
			c.y = (-1) * oldY;
		}
		//look for corresponding PieceView and update BufferedImage
		PieceView pv = null;
		for(PieceView view: getPvs()){
			if(view.getP() == getSelectedPiece()){
				pv = view;
			}
		}
		pv.draw();
	}

	/**
	 * flip the selected piece over it's y-axis
	 */
	public void horizontalFlip(){
		for(Coordinate c: getSelectedPiece().getCoordinates()){
			int oldX = c.x;
			c.x = (-1) * oldX;
		}
		//look for corresponding PieceView and update BufferedImage
		PieceView pv = null;
		for(PieceView view: getPvs()){
			if(view.getP() == getSelectedPiece()){
				pv = view;
			}
		}
		pv.draw();
	}


	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}


	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}


	public PieceView[] getPvs() {
		return pvs;
	}

	
	public void setPvs(PieceView[] pvs) {
		this.pvs = pvs;
	}
	
}