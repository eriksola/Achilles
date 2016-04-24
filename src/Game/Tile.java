package Game;

import java.io.Serializable;

public class Tile implements Serializable{
	
	boolean isOccupied;
	int row;
	int column;
	
	public Tile(boolean isOcc, int r, int c){
		this.isOccupied = isOcc;
		this.row = r;
		this.column = c;
	}
	
	public boolean isOccupied(){
		return this.isOccupied;
	}
	
}
