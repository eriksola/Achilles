package Game;

/**
 * A ReleaseScore will have the logic for how to win a release level type in the <b> Kabasuji</b> game.
 * @author Aguila
 *
 */
public class ReleaseScore implements IScore{
	/** Arrays of booleans for colors for a Release Level */
	boolean[] red;
	boolean[] yellow;
	boolean[] green;
	
	/**
	 * Constructs a release score with the Color on the tiles are all initialized to false.
	 */
	public ReleaseScore(){
		this.red = new boolean[6];
		this.yellow = new boolean[6];
		this.green = new boolean[6];
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
		//TO-DO
	}
}
