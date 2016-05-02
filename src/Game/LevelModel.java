package Game;

/**
 * LevelModel is the superclass for any type of level in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LevelModel {
	Board board;
	BullPen bullpen;
	int levelNum;
	IScore score;
	
	/**
	 * Creates a LevelModel with all of the entities needed for a level.
	 * @param b Board for a level.
	 * @param bp Bullpen for a level.
	 * @param ln Level number for a level
	 * @param s Encapsulates the score associated with a LevelModel.
	 */
	public LevelModel(Board b, BullPen bp, int ln, IScore s){
		
		this.board = b;
		this.bullpen = bp;
		this.levelNum = ln;
		this.score = s;
	}
	
	/**
	 * Creates a LevelModel copy of a given LevelModel.
	 * @param lm LevelModel given.
	 */
	public LevelModel(LevelModel lm){
		this.board = lm.board;
		this.bullpen = lm.bullpen;
		this.levelNum = lm.levelNum;
		this.score = lm.score;
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public BullPen getBullPen(){
		return this.bullpen;
	}
	
	public int getLevelNum(){
		return this.levelNum;
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
