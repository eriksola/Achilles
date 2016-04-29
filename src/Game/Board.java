package Game;

import java.io.Serializable;
import java.util.HashMap;

import Boundary.Both.PieceView;

/**
 * 
 * @author Nan Zhang
 *
 */
public class Board implements Serializable{
	
	Tile[][] tiles;
	HashMap<Coordinate,PieceView> pieces;
	int width;
	int height;
		
	public Board(Tile[][] t){
		this.tiles = t;
		this.height = t.length;
		this.width = t[0].length;
		this.pieces = new HashMap<Coordinate,PieceView>();
	}
	
	public boolean addPiece(int row, int column, PieceView pv){
		
		Coordinate[] newOccCoords = new Coordinate[6];
		Coordinate anchor = new Coordinate(column, row);
		pv.getP().setAnchorOnBoard(anchor);
		
		//makes sure every square in the Piece has a valid Tile
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			if (isValid(row - c.y, column + c.x)){
				newOccCoords[i] = new Coordinate(column+c.x, row-c.y);
			}
			else return false;
		}
		
		//if true then mark those tiles as occupied
		//first mark the tile that was clicked on
		//then mark the other tiles based on the coordinates of the Pieces squares
		for(int i = 0; i < 6; i++){
			int newX = newOccCoords[i].x;
			int newY = newOccCoords[i].y;
			this.tiles[newY][newX].setOccupied(true);
			this.pieces.put(new Coordinate(newX,newY), pv);
		}
		
		return true;
	}
	
	public boolean removePiece(int row, int column, PieceView pv){
		
		Coordinate[] newUnoccCoords = new Coordinate[6];
		
		//makes sure every square in the Piece has a valid Tile
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			if (isValid(row - c.y, column + c.x)){
				newUnoccCoords[i] = new Coordinate(column+c.x, row-c.y);
			}
			else return false;
		}
		
		//if true then mark those tiles as occupied
		//first mark the tile that was clicked on
		//then mark the other tiles based on the coordinates of the Pieces squares
		for(int i = 0; i < 6; i++){
			int newX = newUnoccCoords[i].x;
			int newY = newUnoccCoords[i].y;
			this.tiles[newY][newX].setOccupied(false);
			this.pieces.remove(new Coordinate(newX,newY));
		}
		
		return true;
	}
	public boolean isValid(int row, int col){
		//if the tile extends off the coordinates of the board, invalid move
		if(row < 0 || row > this.height || col < 0 || col > this.width){
			return false;
		}
		
		//if the tile is occupied, invalid move
		if (this.tiles[row][col].isOccupied()){ return false;}
		
		//otherwise, valid move 
		return true;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}
	
	public HashMap<Coordinate, PieceView> getPieces() {
		return this.pieces;
	}
	
	public void setTiles(Tile[][] tiles){
		this.tiles = tiles;
		this.height = tiles.length;
		this.width = tiles[0].length;
	}
}
