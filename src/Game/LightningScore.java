package Game;

public class LightningScore implements IScore{
	int totalTiles;
	int totalMarked;
	
	public LightningScore(int total){
		this.totalTiles = total;
		this.totalMarked = 0;
	}
	
	public boolean hasWon(){
		
		//if at least one star is earned the game is won
		if (scoreToStars() > 0) return true;
		
		//otherwise the game is incomplete/lost
		else return false;
	}
	//converts the score into the number of stars
	public int scoreToStars(){
		int tilesLeft = totalTiles - totalMarked;
		
		//if all tiles are marked, 3 stars have been earned
		if (tilesLeft == 0) return 3;
		//if all but 6 tiles are marked, 2 stars have been earned
		if (tilesLeft <= 6) return 2;
		//if all but 12 tiles are marked, 1 star has been earned
		if (tilesLeft <= 12) return 1;
		//otherwise 0 stars earned
		else return 0;
	}
	
	public void updateScore(LevelModel lightLvl){
		
		int countMarked = 0;
		Tile[][] tile = lightLvl.getBoard().getTiles();
		
		for (int i = 0; i < tile.length; i++){
			for (int j = 0; j < tile[0].length; j++){
				if (tile[i][j].isOccupied){ countMarked++; }
			}
		}
		totalMarked = countMarked;
	}
}

