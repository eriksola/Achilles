package Game;

import java.io.Serializable;

import Game.Coordinate;

public class Piece implements Serializable{

	private Coordinate[] coords = new Coordinate[6];
	int bpIndex;

	public Piece(Coordinate[] coords, int bp){
		this.setCoordinates(coords);
		this.bpIndex = bp;
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

	
	public Coordinate[] getCoordinates(){
		return this.coords;
	}

	public void setCoordinates(Coordinate[] coords) {
		this.coords = coords;
	}
}