package Game;

import java.io.Serializable;

/**
 * 
 * @author Nan Zhang
 *
 */
public class Board implements Serializable{

	Tile[][] tiles;
	int width;
	int height;
		
	public Board(Tile[][] t){
		this.tiles = t;
		this.height = t.length;
		this.width = t[0].length;
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
		if(row < 0 || row > this.height || col < 0 || col > this.width){
			return false;
		}
		//if the tile is occupied, invalid move
		if (this.tiles[row][col].isOccupied()){ return false;}
		
		return true;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}
}
