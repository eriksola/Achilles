package Game;

import java.io.Serializable;

import Game.Coordinate;

public class Piece implements Serializable{

	private Coordinate[] coords = new Coordinate[6];
	private Coordinate anchorOnBoard = null; /** Represents the location of the anchor if the piece is on the board **/
	int bpIndex;

	public Piece(Coordinate[] coords, int bp){
		for (int i = 0; i < coords.length; i++) {
			this.coords[i] = new Coordinate(coords[i]);
		}
		this.bpIndex = bp;
	}	
	
	
	/**
	 * getter for coordinates
	 * @return coords the Coordinates of this Piece
	 */
	public Coordinate[] getCoordinates(){
		return this.coords;
	}
	
	/**
	 * rotate the selected piece ninety degrees counterclockwise
	 */
	public void rotateLeft(){
		for(Coordinate c: coords){
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
		for(Coordinate c: coords){
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
		for(Coordinate c: coords){
			int oldY = c.y;
			c.y = (-1) * oldY;
		}
	}

	/**
	 * flip the selected piece over it's y-axis
	 */
	public void horizontalFlip(){
		for(Coordinate c: coords){
			int oldX = c.x;
			c.x = (-1) * oldX;
		}
	}

	public String toString () {
		String s = "";
		for (Coordinate c : coords) {
			s += c.toString() + " ";
		}
		
		return s;
	}
	
	public Coordinate getAnchorOnBoard(){
		return this.anchorOnBoard;
	}
	
	public void setAnchorOnBoard(Coordinate c){
		this.anchorOnBoard = c;
	}
}