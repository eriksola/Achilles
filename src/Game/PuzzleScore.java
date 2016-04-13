package Game;

public class PuzzleScore implements IScore{
	
	int totalPieces;
	int piecesUsed;
	
	PuzzleScore(int total){
		this.totalPieces = total;
		this.piecesUsed = 0;
	}
	
	public boolean hasWon(){
		return true;
	}

	public int scoreToStars(){
		return 1;
	}
}
