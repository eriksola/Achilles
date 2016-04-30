package Game;

/**
 * A PuzzleScore will have the logic for how to win a puzzle level type in the <b> Kabasuji</b> game.
 * @author Aguila
 *
 */
public class PuzzleScore implements IScore{
	
	int totalPieces;
	int piecesUsed;
	
	/**
	 * Creates a PuzzleScore.
	 * @param total The total number of pieces that are not used yet.
	 */
	public PuzzleScore(int total){
		this.totalPieces = total;
		this.piecesUsed = 0;
	}
	
	/**
	 * Checks to see if a player has won a puzzle level.
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
		int piecesLeft = totalPieces - piecesUsed;
		
		if (piecesLeft == 2) return 1;
		if (piecesLeft == 1) return 2;
		if (piecesLeft == 0) return 3;
		else return 0;
	}
	
	/**
	 * Updates the score of a puzzle level.
	 * @param puzzleLvl LevelModel that describes the current level.
	 */
	public void updateScore(LevelModel puzzleLvl){
		
		//counts the number of pieces left in the BullPen
		int piecesInBullPen = puzzleLvl.getBullPen().getPieces().size();
		//difference between pieces left and total pieces is the amount used
		piecesUsed = totalPieces - piecesInBullPen;
		
	}
	
}
