package Game;

public class PuzzleScore implements IScore{
	
	int totalPieces;
	int piecesUsed;
	
	public PuzzleScore(int total){
		this.totalPieces = total;
		this.piecesUsed = 0;
	}
	
	public boolean hasWon(){
		
		//if at least one star is earned the game is won
		if (scoreToStars() > 0) return true;
		
		//otherwise the game is incomplete/lost
		else return false;
	}
	//converts the score into the number of stars earned
	public int scoreToStars(){
		int piecesLeft = totalPieces - piecesUsed;
		
		if (piecesLeft == 2) return 1;
		if (piecesLeft == 1) return 2;
		if (piecesLeft == 0) return 3;
		else return 0;
	}
	
	public void updateScore(LevelModel puzzleLvl){
		
		//counts the number of pieces left in the BullPen
		int piecesInBullPen = puzzleLvl.getBullPen().getPieces().size();
		//difference between pieces left and total pieces is the amount used
		piecesUsed = totalPieces - piecesInBullPen;
		
	}
	
}
