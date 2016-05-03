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
	int column;
	int row;

	
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
	
	public int getRow(){
		return this.row;
	}
	
	public int getCol(){
		return this.column;
	}
}
