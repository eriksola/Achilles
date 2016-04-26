package Game;

public class ReleaseScore implements IScore{
	boolean[] red;
	boolean[] yellow;
	boolean[] green;
	
	public ReleaseScore(){
		this.red = new boolean[6];
		this.yellow = new boolean[6];
		this.green = new boolean[6];
	}
	
	//checks whether the score is the max
	public boolean hasWon(){
		
		
		//if at least one star is earned, the game is won
		if (scoreToStars() > 0) return true;
		
		//otherwise the game is incomplete/lost
		else return false;
	}
	
	//converts the score into the number of stars earned
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
	
	//check nums 1-6 of a certain color tile has been marked
	public boolean allNum(boolean[] nums){
		
		boolean result = true;
		
		//check if any of the nums has not been marked
		for(boolean b: nums){
			result = result & b;
		}
		
		return result;
	}
}
