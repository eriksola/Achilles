package Game;

import java.io.Serializable;

/**
 * A Tile is a what makes up board for a level. 
 * 
 * @author Achilles
 *
 */
public class Tile implements Serializable{
	
	boolean isOccupied; //true if the tile is occupied by a piece
	boolean isSelected; //true if the tile is selected by the player
	boolean isHint; //true if the tile is part of a hint 
	int column; //column of the tile on the board
	int row; //row of the tile on the board

	
	/**
	 * Constructor for a Tile class. Creates a Tile where pieces will reside.
	 * @param r The specified row for a tile.
	 * @param c The specified column for a tile.
	 */
	public Tile(int c, int r){
		this.isOccupied = false;
		this.isSelected = false;
		this.isHint = false;
		this.column = c;
		this.row = r;
	}
	
	/**
	 * Constructor for a tile object detailing exact parameters
	 * @param row The row of the tile on the board
	 * @param col The column of the tile on the board
	 * @param isHint True if the tile is part of a hint
	 * @param isOccupied True if the tile is occupied by a piece
	 * @param isSelected True if the tile is selected by the player
	 */
	public Tile(int row, int col, boolean isHint, boolean isOccupied, boolean isSelected){
		this.row = row;
		this.column = col;
		this.isHint = isHint;
		this.isOccupied = isOccupied;
		this.isSelected = isSelected;
	}
	
	/**
	 * Will check if a Tile is currently occupied.
	 * @return True if the Tile is currently occupied by a piece.
	 */
	public boolean isOccupied(){
		return this.isOccupied;
	}
	
	/**
	 * Sets a Tile to being occupied by a piece.
	 * @param bool Flag stating whether or not the tile is occupied by a piece.
	 */
	public void setOccupied(boolean bool){
		this.isOccupied = bool;
	}
	
	/**
	 * Checks if the tile is currently selected.
	 * @return True if the Tile is selected
	 */
	public boolean isSelected(){
		return this.isSelected;
	}
	
	/**
	 * Sets the Tile to being selected by a piece.
	 * @param bool Flag stating whether or not the tile is now selected.
	 */
	public void setSelected(boolean bool){
		this.isSelected = bool;
	}
	
	/**
	 * getter function for isHint
	 * @return true if the tile is part of a hint
	 */
	public boolean isHint(){
		return this.isHint;
	}
	
	/**
	 * sets flag for the tile as part of a hint
	 * @param bool True if the tile is part of a hint
	 */
	public void setHint(boolean bool){
		this.isHint = bool;
	}
	
	/**
	 * Getter function for the row of the tile
	 * @return Row of the tile on the board
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Getter function for the column of the tile
	 * @return Column of the tile on the board
	 */
	public int getCol(){
		return this.column;
	}
}
