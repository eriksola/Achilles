package Game;

import java.io.Serializable;
import java.util.HashMap;

public class LightningBoard extends Board implements Serializable{

	/**
	 * Constructor for the lightning board
	 * @param t array of tiles
	 */
	public LightningBoard(Tile[][] t){
		super(t);
	}
	
	/**
	 * If the tile extends off the coordinates of the board or is null it is an invalid move.
	 * @param row <i> x </i> coordinate for the Piece.
	 * @param column <i> y </i> coordinate for the Piece.
	 * @return True if piece is valid.
	 */
	public boolean isValid(int row, int col){
		
		//if the tile extends off the coordinates of the board, invalid move
		if(row < 0 || row > this.height - 1|| col < 0 || col > this.width - 1){
			return false;
		}
		//if this tile is null, invalid move
		if (this.tiles[row][col] == null) { return false;}
		//otherwise, valid move 
		return true;
	}
}
