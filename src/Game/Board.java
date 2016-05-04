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
	
	Tile[][] tiles; /** double array of tiles which represents the board **/
	HashMap<Tile,Piece> pieces; /** mapping of pieces on the board by the tiles they occupy **/
	Tile selectedPieceAnchor; /** the anchor of the selected piece on the board **/
	int width; /** width of the board **/
	int height; /** height of the board **/
		
	/**
	 * Creates a Board with a two dimensional array of Tiles.
	 * @param t Matrix of tiles that will create the board.
	 */
	public Board(Tile[][] t){
		this.tiles = t;
		this.height = t.length;
		this.width = t[0].length;
		this.pieces = new HashMap<Tile,Piece>();	
		this.selectedPieceAnchor = null;
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
		System.out.println("Pieces on Board: " + this.pieces.values().size()/6);
		System.out.println("Occupied tiles: " + this.pieces.keySet().size());
		return true;
	}
	
	/**
	 * Remove a piece from the board if it is valid.
	 * @param row <i> x </i> coordinate for the Piece.
	 * @param column <i> y </i> coordinate for the Piece.
	 * @param pv View of the Piece that is being removed. 
	 * @return True if the piece was removed successfully.
	 */
	public boolean removePiece(int row, int column, PieceView pv){
		
		Coordinate[] newUnoccCoords = new Coordinate[6];
		boolean correctRemoval = true;
		//get coordinates of the piece on the board
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			if (!tiles[row-c.y][column+c.x].isOccupied()){ correctRemoval = false; }
			newUnoccCoords[i] = new Coordinate(column+c.x, row-c.y);
		}
		
		//if true then mark the tiles with those coordinates as unoccupied and unselected
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
		System.out.println("Correct Removal? " + correctRemoval);
		return correctRemoval;
	}
	
	/**
	 * Select a Piece from the board. 
	 * @param row <i> x </i> coordinate for the Piece.
	 * @param column <i> y </i> coordinate for the Piece.
	 * @param pv View of the Piece that is being selected. 
	 * @return True if piece was selected.
	 */
	public boolean selectPiece(int row, int column, PieceView pv){
		
		Coordinate[] newSelectCoords = new Coordinate[6];
		
		//get coordinates of the piece on the board
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			newSelectCoords[i] = new Coordinate(column+c.x, row-c.y);
		}
		
		//if true then mark those tiles as selected 
		//first mark the tile that was clicked on (and set as anchor)
		//then mark the other tiles based on the coordinates of the Pieces squares
		
		int anchorX = newSelectCoords[0].x;
		int anchorY = newSelectCoords[0].y;
		setSelectedPieceAnchor(this.tiles[anchorY][anchorX]);
		
		for(int i = 0; i < 6; i++){
			int newX = newSelectCoords[i].x;
			int newY = newSelectCoords[i].y;
			Tile t = this.tiles[newY][newX];
			t.setSelected(true);
		}
		
		return true;
	}
	
	/**
	 * Deselects the piece located on the tile given
	 * @param row The row of the tile 
	 * @param column The column of the tile
	 * @param pv The piece to be removed
	 * @return
	 */
	public boolean deselectPiece(int row, int column, PieceView pv){
		
		Coordinate[] newUnselCoords = new Coordinate[6];
		
		//get coordinates of the piece on the board
		for (int i = 0; i < 6; i++){
			Coordinate c = pv.getP().getCoordinates()[i];
			newUnselCoords[i] = new Coordinate(column+c.x, row-c.y);
		}
		
		//if true then mark those tiles as unselected 
		//first mark the tile that was clicked on
		//then mark the other tiles based on the coordinates of the Pieces squares
		
		deselectPieceAnchor();
		
		for(int i = 0; i < 6; i++){
			int newX = newUnselCoords[i].x;
			int newY = newUnselCoords[i].y;
			Tile t = this.tiles[newY][newX];
			t.setSelected(false);
		}
		
		return true;
	}

	/**
	 * If the tile extends off the coordinates off the board, is null, or overlaps another piece it is an invalid move.
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
		
		//if the tile is occupied, invalid move
		if (this.tiles[row][col].isOccupied()){ return false;}

		//otherwise, valid move 
		return true;
	}

	/**
	 * sets the piece as a hint and removes it from the board
	 * @param p The piece to be set as a hint
	 */
	public void registerHintPiece(Piece p) {
		
		//get the piece from the board and set it's underlying tiles as hint tiles
		Coordinate anchor = p.getAnchorOnBoard();
		for (int i = 0; i < p.getCoordinates().length; i++) {
			int rowOffset = p.getCoordinates()[i].y;
			int colOffset = p.getCoordinates()[i].x;
			Tile t = this.tiles[anchor.y - rowOffset][anchor.x + colOffset];
			t.setHint(true);
			t.setOccupied(false);
			t.setSelected(false);
			pieces.remove(t);
		}
	}
	
	/**
	 * Checks if a piece is valid (BEFORE ADDING THE PIECE TO THE BOARD)
	 * @param row row of the tile selected
	 * @param col column of the tile selected
	 * @param pv pieceview of the piece to be added
	 * @return true if a piece is valid to add to the board
	 */
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
	
	/**
	 * getter function for the tile array
	 * @return array of tiles
	 */
	public Tile[][] getTiles() {
		return this.tiles;
	}
	/**
	 * getter function for map of pieces
	 * @return map of pieces
	 */
	public HashMap<Tile, Piece> getPieces() {
		return this.pieces;
	}
	
	/**
	 * getter function for the anchor tile of the selected piece
	 * @return anchor tile
	 */
	public Tile getSelectedPieceAnchor(){
		return this.selectedPieceAnchor;
	}
	
	/**
	 * sets the array of tiles
	 * @param tiles new array of tiles
	 */
	public void setTiles(Tile[][] tiles){
		this.tiles = tiles;
		this.height = tiles.length;
		this.width = tiles[0].length;
	}
	
	/**
	 * Sets the anchor of the selected piece
	 * @param t
	 */
	public void setSelectedPieceAnchor(Tile t){
		this.selectedPieceAnchor = t;
	}
	
	/**
	 * Deselects the anchor of the selected piece
	 */
	public void deselectPieceAnchor(){
		this.selectedPieceAnchor = null;
	}	
	
	/**
	 * getter function for the height
	 * @return height of the board
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * getter function for the width
	 * @return width of the board
	 */
	public int getWidth(){
		return this.width;
	}
}
