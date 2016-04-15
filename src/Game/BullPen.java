package Game;

public class BullPen {
	
	Piece[] pieces;
	Piece selectedPiece;
	
	public BullPen(Piece[] p){
		this.pieces = p;
	}
	
	/**
	 * rotate the selected piece ninety degrees counterclockwise
	 */
	public void rotateLeft(){
		for(Coordinate c: selectedPiece.coords){
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
		for(Coordinate c: selectedPiece.coords){
			int oldX = c.x;
			int oldY = c.y;
			c.x = (1) * oldY;
			c.y = (1) * oldX;
		}
	}
	
	/**
	 * flip the selected piece over it's x-axis
	 */
	public void verticalFlip(){
		for(Coordinate c: selectedPiece.coords){
			int oldY = c.y;
			c.y = (-1) * oldY;
		}
	}
	
	/**
	 * flip the selected piece over it's y-axis
	 */
	public void horizontalFlip(){
		for(Coordinate c: selectedPiece.coords){
			int oldX = c.x;
			c.x = (-1) * oldX;
		}
	}
}
