package Game;

public class PuzzleLevelModel extends LevelModel{
	
	int movesGiven;
	int movesUsed;
	Board b;
	BullPen bp;
	int moves;
	public PuzzleLevelModel(Board b, BullPen bp, int ln, IScore s, int mg){
		super(b, bp, ln, s);
		this.movesGiven = mg;
		this.b = b;
		this.bp = bp;
		this.movesUsed = 0;
	}
	public Board getBoard() {
		return b;
	}
	
	public BullPen getBullPen() {
		return bp;
	}

	public int getMoves() {
		return moves;
	}


}
