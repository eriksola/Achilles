package Game;

import java.io.Serializable;

/**
 * A Tile is a what makes up board for a level. 
 * 
 * @author Achilles
 *
 */
public class Tile implements Serializable{
	
	boolean isOccupied;
	boolean isSelected;
	boolean isHint;
	int row;
	int column;
	
	/**
	 * Constructor for a Tile class. Creates a Tile where pieces will reside.
	 * @param r The specified row for a tile.
	 * @param c The specified column for a tile.
	 */
	public Tile(int r, int c){
		this.isOccupied = false;
		this.isSelected = false;
		this.isHint = false;
		this.row = r;
		this.column = c;
	}
	
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
	
	public boolean isHint(){
		return this.isHint;
	}
	
	public void setHint(boolean bool){
		this.isHint = bool;
	}
}
