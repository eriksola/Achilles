package Game;

import java.util.HashMap;

public class LightningBoard extends Board{
	
	HashMap<Tile,Piece> pieces;
	Tile selectedPieceAnchor; /** the anchor of the selected piece on the board **/
	int width;
	int height;
	
	public LightningBoard(Tile[][] t){
		super(t);
		this.height = t.length;
		this.width = t[0].length;
		this.pieces = new HashMap<Tile,Piece>();
		this.selectedPieceAnchor = null;
	}
	
	/**
	 * If the tile extends off the coordinates of the board, invalid move.
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
