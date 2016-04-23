package Game;

public class Tile {
	
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
