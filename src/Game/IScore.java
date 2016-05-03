package Game;

import java.io.Serializable;

import Boundary.Player.KabasujiFrame;

/**
 * Way to encapsulate the method of scoring for any level.
 * @author Aguila
 *
 */
public interface IScore extends Serializable{
	
	/** Method contracts for any score type. */
	public boolean hasWon();
	public int scoreToStars();
	public void updateScore(LevelModel level);

}
