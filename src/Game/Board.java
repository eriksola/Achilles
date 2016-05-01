package Game;

import java.io.Serializable;
import java.util.HashMap;

import Boundary.Both.PieceView;

/**
 * Board will hold a number of pieces must be able to be filled with 6n pieces.
 * @author Achilles
 *
 */
public class Board implements Serializable{
	
	Tile[][] tiles;
	HashMap<Tile,Piece> pieces;
	int width;
	int height;
		
	/**
	 * Creates a Board with a two dimensional array of Tiles.
	 * @param t Matrix of tiles that will create the board.
	 */
	public Board(Tile[][] t){
		this.tiles = t;
		this.height = t.length;
		this.width = t[0].length;
		this.pieces = new HashMap<Tile,Piece>();
	}
	
	/**
	 * Add a piece to the board if it is valid.
	 * @param row <i> x </i> coordinate for the Piece.
	 * @param column <i> y </i> coordinate for the Piece.
	 * @param pv View of the Piece that is being added. 
	 * @return True if the piece was added successfully.
	 */
	public boolean addPiece(int row, int column, PieceView pv){
		
		Coordinate[] newOccCoords = new Coordinate[6];
		
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
		
		Coordinate anchor = new Coordinate(column, row);
		pv.getP().setAnchorOnBoard(anchor);
		
		for(int i = 0; i < 6; i++){
			int newX = newOccCoords[i].x;
			int newY = newOccCoords[i].y;
			Tile t = this.tiles[newY][newX];
			t.setOccupied(true);
			this.pieces.put(t, pv.getP());
		}
		
		return true;
	}
	
	/**
	 * Remove a piece to the board if it is valid.
	 * @param row <i> x </i> coordinate for the Piece.
	 * @param column <i> y </i> coordinate for the Piece.
	 * @param pv View of the Piece that is being removed. 
	 * @return True if the piece was removed successfully.
	 */
	public boolean removePiece(int row, int column, PieceView pv){
		
		Coordinate[] newUnoccCoords = new Coordinate[6];
		
		//get coordinates of the piece on the board
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			newUnoccCoords[i] = new Coordinate(column+c.x, row-c.y);
		}
		
		//if true then mark the tiles with those coordinates as unoccupied
		//first mark the tile that was clicked on
		//then mark the other tiles based on the coordinates of the Pieces squares
		//and remove the tile from the HashMap 
		for(int i = 0; i < 6; i++){
			int newX = newUnoccCoords[i].x;
			int newY = newUnoccCoords[i].y;
			Tile t = this.tiles[newY][newX];
			t.setOccupied(false);
			t.setSelected(false);
			this.pieces.remove(t);
		}
		
		return true;
	}
	
	/**
	 * Select a Piece from the board. 
	 * @param row <i> x </i> coordinate for the Piece.
	 * @param column <i> y </i> coordinate for the Piece.
	 * @param pv View of the Piece that is being selected. 
	 * @return True if piece was selected.
	 */
	public boolean selectPiece(int row, int column, PieceView pv){
		
		Coordinate[] newUnoccCoords = new Coordinate[6];
		
		//get coordinates of the piece on the board
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			newUnoccCoords[i] = new Coordinate(column+c.x, row-c.y);
		}
		
		//if true then mark those tiles as selected 
		//first mark the tile that was clicked on
		//then mark the other tiles based on the coordinates of the Pieces squares
		for(int i = 0; i < 6; i++){
			int newX = newUnoccCoords[i].x;
			int newY = newUnoccCoords[i].y;
			Tile t = this.tiles[newY][newX];
			t.setSelected(true);
		}
		
		return true;
	}
	

	public boolean deselectPiece(int row, int column, PieceView pv){
		
		Coordinate[] newUnoccCoords = new Coordinate[6];
		
		//get coordinates of the piece on the board
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			newUnoccCoords[i] = new Coordinate(column+c.x, row-c.y);
		}
		
		//if true then mark those tiles as selected 
		//first mark the tile that was clicked on
		//then mark the other tiles based on the coordinates of the Pieces squares
		for(int i = 0; i < 6; i++){
			int newX = newUnoccCoords[i].x;
			int newY = newUnoccCoords[i].y;
			Tile t = this.tiles[newY][newX];
			t.setSelected(false);
		}
		
		return true;
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
		//if the tile is occupied, invalid move
		if (this.tiles[row][col].isOccupied()){ return false;}

		//otherwise, valid move 
		return true;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}
	
	public HashMap<Tile, Piece> getPieces() {
		return this.pieces;
	}
	
	public void setTiles(Tile[][] tiles){
		this.tiles = tiles;
		this.height = tiles.length;
		this.width = tiles[0].length;
	}

	public void registerHintPiece(Piece p) {
		//get the piece from the board and set it's underlying tiles as hint tiles
		Coordinate anchor = p.getAnchorOnBoard();
		for (int i = 0; i < p.getCoordinates().length; i++) {
			int rowOffset = p.getCoordinates()[i].y;
			int colOffset = p.getCoordinates()[i].x;
			Tile t = this.tiles[anchor.y - rowOffset][anchor.x + colOffset];
			t.setHint(true);
		}
	}

	public boolean isValidToAdd(int row, int col, PieceView pv) {
		//makes sure every square in the Piece has a valid Tile
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			if (!isValid(row - c.y, col + c.x)){
				return false;
			}
		}
		return true;
	}
}
