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
	public boolean hasWon(); /** checks if the level has been won **/
	public int scoreToStars(); /** converts the score into the number of stars earned **/
	public void updateScore(LevelModel level); /** updates the score of the given level **/

}
