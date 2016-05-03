package Game;

/**
 * LevelModel is the superclass for any type of level in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LevelModel {
	Board board;
	BullPen bullpen;
	String name;	
	IScore score;
	
	/**
	 * Creates a LevelModel with all of the entities needed for a level.
	 * @param b Board for a level.
	 * @param bp Bullpen for a level.
	 * @param ln Level number for a level
	 * @param s Encapsulates the score associated with a LevelModel.
	 */
	public LevelModel(Board b, BullPen bp, String name, IScore s){
			
		this.board = b;
		this.bullpen = bp;
		this.name = name;
		this.score = s;
	}
	
	/**
	 * Creates a LevelModel copy of a given LevelModel.
	 * @param lm LevelModel given.
	 */
	public LevelModel(LevelModel lm){
		this.board = lm.board;
		this.bullpen = lm.bullpen;
		this.name = lm.name;
		this.score = lm.score;
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public BullPen getBullPen(){
		return this.bullpen;
	}
	
	public String getName(){
		return this.name;
	}
	
	public IScore getScore(){
		return this.score;
	}
	
	/**
	 * if the player earns a better score, save it as the new top score
	 * @param currentScore the new top score
	 */
	public void setScore(IScore currentScore) {
		this.score = currentScore;
	}
}
