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
}
