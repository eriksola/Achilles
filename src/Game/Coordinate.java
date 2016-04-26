package Game;

import java.io.Serializable;

public class Coordinate implements Serializable{
	public int x;
	public int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Coordinate(Coordinate coordinate) {
		this.x = coordinate.x;
		this.y = coordinate.y;
	}
	
	
	public String toString () {
		return "(" + x + "," + y + ")";
	}
}
