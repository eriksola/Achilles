package Game;

/**
 * Way to encapsulate the method of scoring for any level.
 * @author Aguila
 *
 */
public interface IScore {
	/** Method contracts for any score type. */
	public boolean hasWon();
	public int scoreToStars();

}
