package Game;

import Boundary.Player.KabasujiFrame;

/**
 * A ReleaseScore will have the logic for how to win a release level type in the <b> Kabasuji</b> game.
 * @author Aguila
 *
 */
public class ReleaseScore implements IScore{
	/** Arrays of booleans for colors for a Release Level */
	boolean[] red = new boolean[6];
	boolean[] yellow = new boolean[6];
	boolean[] green = new boolean[6];
	
	/**
	 * Constructs a release score with the Color on the tiles are all initialized to false.
	 */
	public ReleaseScore(){
		
	}
	
	public ReleaseScore(boolean red, boolean yellow, boolean green){
		if (red) { 
			for (int i = 0; i < 6; i++){
				this.red[i] = true;
			}
		}
		if (yellow) { 
			for (int i = 0; i < 6; i++){
				this.yellow[i] = true;
			}
		}
		if (green) { 
			for (int i = 0; i < 6; i++){
				this.green[i] = true;
			}
		}
	}
	/**
	 * Checks to see if a player has won a release level.
	 * A player has won when if at least one star is earned, otherwise they lose.
	 */
	public boolean hasWon(){
		if (scoreToStars() > 0) return true;
		else return false;
	}
	
	
	/**
	 * Will convert the score into the number of stars earned for a level.
	 * @return The number of stars that the score corresponds to.
	 */
	public int scoreToStars(){
		int stars = 0;
		
		//check if all red nums have been marked
		boolean complete = allNum(red);
		//if true, add 1 star
		if (complete == true) stars += 1;
		
		//check if all yellow nums have been marked
		complete = allNum(yellow);
		//if true, add 1 star
		if (complete == true) stars += 1;
		
		//check if all green nums have been marked
		complete = allNum(green);
		//if true, add 1 star
		if (complete == true) stars += 1;
		
		//return the number of stars earned
		return stars;
	}
	
	/**
	 * Check an array of booleans to see if a 1-6 of a certain color tile has been marked.
	 * @param nums array of booleans that represents a color.
	 * @return True if all of the colors have been marked for a color.
	 */
	public boolean allNum(boolean[] nums){
		
		boolean result = true;
		
		//check if any of the nums has not been marked
		for(boolean b: nums){
			result = result & b;
		}
		
		return result;
	}
	/**
	 * Updates the score of a level.
	 * @param releaseLvl LevelModel that describes the current level 
	 */
	public void updateScore(LevelModel releaseLvl){
		Tile[][] tiles = releaseLvl.getBoard().getTiles();
		int height = tiles.length;
		int width = tiles[0].length;
		
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				//if the tile is a release tile and is occupied
				if (tiles[i][j] instanceof ReleaseTile){
					if (tiles[i][j].isOccupied()){
						ReleaseTile relTile = (ReleaseTile) tiles[i][j];
						int color = relTile.getColNum().getColor();
						int num = relTile.getColNum().getNum();
							//add to score
							if (color == 1){
								this.red[num - 1] = true;
							}
							if (color == 2){
								this.yellow[num - 1] = true;
							}
							if (color == 3){
								this.green[num - 1] = true;
							}
					}
				}
			}
		}
	}	
	public boolean getRed(){
		return allNum(this.red);
	}
	
	public boolean getYellow(){
		return allNum(this.yellow);
	}
	
	public boolean getGreen(){
		return allNum(this.green);
	}

}
