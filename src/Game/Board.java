package Game;

//testing git
public class Board {

	Tile[][] tiles;
		
	Board(Tile[][] t){
		
		this.tiles = t;
	}
	
	public Board addPiece(int row, int column, Piece piece){
		this.tiles[row][column] = new Tile(true, row, column);
		for (int i =1; i<6; i++){
			Coordinate c =piece.getCoordinates()[i];
			this.tiles[row+c.x][column+c.y] = new Tile(true, row+c.x, column+c.y);
		}
		return this;
	}
}
