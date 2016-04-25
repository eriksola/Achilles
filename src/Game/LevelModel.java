package Game;

public class LevelModel {
	Board board;
	BullPen bullpen;
	int levelNum;
	IScore score;
	
	public LevelModel(Board b, BullPen bp, int ln, IScore s){
		
		this.board = b;
		this.bullpen = bp;
		this.levelNum = ln;
		this.score = s;
	}
}
