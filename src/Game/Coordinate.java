package Game;

import java.io.Serializable;

/**
 * A Coordinate will be used in order to specify the locate of a Piece.
 * Also used to create pieces.
 * @author Achilles
 *
 */
public class Coordinate implements Serializable{
	
	public int x;
	public int y;
	
	/**
	 * Creates a Coordinate
	 * @param x The <i> X </i> coordinate.
	 * @param y The <i> Y </i> coordinate.
	 */
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copies a Coordinate
	 * @param coordinate The coordinate to be copied
	 */
	public Coordinate(Coordinate coordinate) {
		this.x = coordinate.x;
		this.y = coordinate.y;
	}
	
	@Override
	public String toString () {
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * getter function for the x param
	 * @return x coord
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * getter function for the y param
	 * @return y coord
	 */
	public int getY(){
		return this.y;
	}
}
