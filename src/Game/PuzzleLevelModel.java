package Game;

public class PuzzleLevelModel extends LevelModel{
	
	int movesGiven;
	int movesUsed;
	
	public PuzzleLevelModel(Board b, BullPen bp, int ln, IScore s, int mg){
		super(b, bp, ln, s);
		this.movesGiven = mg;
		this.movesUsed = 0;
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
	
	public int getMovesAllowed(){
		return this.movesGiven;
	}
}
