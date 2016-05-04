package Game;

import java.io.Serializable;

import Game.Coordinate;

/**
 * 
 * Represents a playable Piece within the <b> Kabasuji</b> game.
 * @author Achilles
 *
 */
public class Piece implements Serializable{

	Coordinate[] coords = new Coordinate[6]; /** Array of coordinates that make up the piece **/
	Coordinate anchorOnBoard = null; /** Represents the location of the anchor coordinate (0,0) if the piece is on the board **/
	
	/**
	 * constructor for the piece
	 * @param coords array of coordinates
	 */
	public Piece(Coordinate[] coords){
		for (int i = 0; i < coords.length; i++) {
			this.coords[i] = new Coordinate(coords[i]);
		}
	}	
	
	/**
	 * Rotates the selected piece ninety degrees counterclockwise.
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
	 * Rotates the selected piece ninety degrees clockwise.
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
	 * Flips the selected piece over it's x-axis.
	 */
	public void verticalFlip(){
		for(Coordinate c: coords){
			int oldY = c.y;
			c.y = (-1) * oldY;
		}
	}

	/**
	 * Flips the selected piece over it's y-axis.
	 */
	public void horizontalFlip(){
		for(Coordinate c: coords){
			int oldX = c.x;
			c.x = (-1) * oldX;
		}
	}
	
	@Override
	public String toString () {
		String s = "";
		for (Coordinate c : coords) {
			s += c.toString() + " ";
		}
		
		return s;
	}
	
	/**
	 * Getter function for the array of coordinates
	 * @return the array of coordinates
	 */
	public Coordinate[] getCoordinates(){
		return this.coords;
	}
	
	/**
	 * getter function for the anchor coordinate of this piece (while on the board)
	 * @return
	 */
	public Coordinate getAnchorOnBoard(){
		return this.anchorOnBoard;
	}
	
	/**
	 * setter function for the anchor coordinate of this piece (while on the board)
	 * @param c Coordinate on the board of the anchor coordinate (0,0) of the piece
	 */
	public void setAnchorOnBoard(Coordinate c){
		this.anchorOnBoard = c;
	}

}
