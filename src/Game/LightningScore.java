package Game;

public class LightningScore implements IScore{
	int totalTiles;
	int totalMarked;
	
	LightningScore(int total){
		this.totalTiles = total;
		this.totalMarked = 0;
	}
	
	public boolean hasWon(){
		return true;
	}
	
	public int scoreToStars(){
		return 1;
	}
}

