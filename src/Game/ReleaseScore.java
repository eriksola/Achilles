package Game;

public class ReleaseScore implements IScore{
	boolean[] red;
	boolean[] yellow;
	boolean[] green;
	
	ReleaseScore(){
		this.red = new boolean[6];
		this.yellow = new boolean[6];
		this.green = new boolean[6];
	}
	
	//checks whether the score is the max
	public boolean hasWon(){
		//stub, edit later
		return true;
	}
	
	//converts the score into the number of stars earned
	public int scoreToStars(){
		//stub, edit later
		return 1;
	}
}
