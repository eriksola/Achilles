package Game;

public class PuzzleLevelModel extends LevelModel{
	
	int movesGiven;
	int movesUsed;
	
	public PuzzleLevelModel(Board b, BullPen bp, int ln, IScore s, int mg){
		super(b, bp, ln, s);
		this.movesGiven = mg;
		this.movesUsed = 0;
	}

}
