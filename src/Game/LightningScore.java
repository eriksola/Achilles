package Game;

import Boundary.Player.KabasujiFrame;

/**
 * A LightningScore will have the logic for how to win a lightning level type in the <b> Kabasuji</b> game.
 * @author Aguila
 *
 */
public class LightningScore implements IScore{
	int totalTiles;
	int totalMarked;
	
	/**
	 * Creates a LightningScore.
	 * @param total The total number of pieces that are not used yet.
	 */
	public LightningScore(int total){
		this.totalTiles = total;
		this.totalMarked = 0;
	}
	
	/**
	 * Checks to see if a player has won a lightning level.
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
	
	/**
	 * Updates the score of a lightning level.
	 * @param lightLvl LevelModel that describes the current level.
	 */
	public void updateScore(LevelModel lightLvl){
			
		int countMarked = 0;
		Tile[][] tiles = lightLvl.getBoard().getTiles();
		
		for (int i = 0; i < tiles.length; i++){
			for (int j = 0; j < tiles[0].length; j++){
				if (tiles[i][j] != null){
					if (tiles[i][j].isOccupied){ countMarked++; }
				}
			}
		}
		totalMarked = countMarked;
	}
}

