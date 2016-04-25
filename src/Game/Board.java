package Game;

/**
 * 
 * @author Nan Zhang
 *
 */
public class Board {

	Tile[][] tiles;
		
	public Board(Tile[][] t){
		this.tiles = t;
	}
	
	public boolean addPiece(int row, int column, Piece piece){
		this.tiles[row][column] = new Tile(true, row, column);
		//right now basically a Lightning Level implementation
		for (int i = 1; i < 6; i++){
			Coordinate c = piece.getCoordinates()[i];
			if(isValid(row - c.y, column + c.x)){
				this.tiles[row - c.y][column + c.x] = new Tile(true, row - c.y, column + c.x);
			}
			else return false;
		}
		return true;
	}
	
	public boolean isValid(int row, int col){
		if(row < 0 || row > tiles.length || col < 0 || col > tiles[0].length){
			return false;
		}
		return true;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}
}
