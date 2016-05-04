package Game;

import java.io.Serializable;

public class ReleaseTile extends Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ColorNumber colNum; /** the color and number of the release tile **/
	
	/**
	 * the constructor for the release tile
	 * @param c The column of the tile on the board
	 * @param r The row of the tile on the board
	 * @param cn The colorNumber of the release tile
	 */
	public ReleaseTile(int c, int r, ColorNumber cn){
		super(c, r);
		this.colNum = cn;
		this.isOccupied = false;
		this.isSelected = false;
		this.isHint = false;
	}
	
	/**
	 * Constructor for a release tile object detailing exact parameters
	 * @param row The row of the tile on the board
	 * @param col The column of the tile on the board
	 * @param isHint True if the tile is part of a hint
	 * @param isOccupied True if the tile is occupied by a piece
	 * @param isSelected True if the tile is selected by the player
	 * @param colorNum The color number for the release tile
	 */
	public ReleaseTile(int row, int col, boolean isHint, boolean isOccupied, boolean isSelected, ColorNumber colorNum){
		super(row, col, isHint, isOccupied, isSelected);
		this.colNum = colorNum;
	}
	/**
	 * Getter function for the colorNumber
	 * @return color and number of the release tile
	 */
	public ColorNumber getColNum(){
		return this.colNum;
	}
}
