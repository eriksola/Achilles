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
		//right now basically a Lightning Level implementation
		
		Coordinate[] newOccCoords = new Coordinate[5];
		
		//makes sure every coordinate in the piece has a corresponding empty tile
		for (int i = 1; i < 6; i++){
			Coordinate c = piece.getCoordinates()[i];
			if(isValid(row - c.y, column + c.x)){
				newOccCoords[i-1] = new Coordinate(column+c.x, row-c.y);
			}
			else return false;
		}
		
		//if true then mark those tiles as occupied
		this.tiles[row][column] = new Tile(true, row, column);
		for(int i = 1; i < 6; i++){
			int newX = newOccCoords[i-1].x;
			int newY = newOccCoords[i-1].y;
			this.tiles[newY][newX] = new Tile(true, newY, newX);
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
