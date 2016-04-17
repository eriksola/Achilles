package Game;

public class Tile {
	
	boolean isOccupied;
	int row;
	int column;
	//Added change
	
	public Tile(boolean isOcc, int r, int c){
		
		this.isOccupied = isOcc;
		this.row = r;
		this.column = c;
	}
}
