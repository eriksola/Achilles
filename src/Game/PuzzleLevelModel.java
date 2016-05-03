package Game;

/**
 * PuzzleLevelModel holds all the logic for a PuzzleLevel type in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class PuzzleLevelModel extends LevelModel{
	
	int movesGiven;
	int movesUsed;
	
	/**
	 * Creates a PuzzleLevelModel with all the entity objects needed to complete a PuzzleLevel.
	 * @param b Board within a PuzzleLevel.
	 * @param bp Bullpen within a PuzzleLevel.
	 * @param ln Number of the level.
	 * @param s Encapsulates the type of score associated with this level.
	 * @param mg Number of moves given for this Puzzle Level.
	 */
	public PuzzleLevelModel(Board b, BullPen bp, String name, IScore s, int mg){
		super(b, bp, name, s);
		this.movesGiven = mg;
		this.movesUsed = 0;
	}
	
	/**
	 * Creates a PuzzleLevelModel with given another PuzzleLevelModel.
	 * @param plm Given PuzzleLevelModel.
	 */
	public PuzzleLevelModel(PuzzleLevelModel plm){
		super(plm);
		this.movesGiven = plm.movesGiven;
		this.movesUsed = 0;
	}
	
	public int getMovesAllowed(){
		return this.movesGiven;
	}
}
