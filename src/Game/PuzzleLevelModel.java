package Game;

import java.util.ArrayList;

/**
 * PuzzleLevelModel holds all the logic for a PuzzleLevel type in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class PuzzleLevelModel extends LevelModel{
	
	int movesGiven; /** the number of moves allowed **/
	
	/**
	 * Creates a PuzzleLevelModel with all the entity objects needed to complete a PuzzleLevel.
	 * @param b Board within a PuzzleLevel.
	 * @param bp Bullpen within a PuzzleLevel.
	 * @param ln Number of the level.
	 * @param s Encapsulates the type of score associated with this level.
	 * @param mg Number of moves given for this Puzzle Level.
	 */
	public PuzzleLevelModel(Board b, BullPen bp, String name, PuzzleScore s, Stock stock, int mg){
		//construct board with current state of Board
		Tile[][] tiles = new Tile[b.height][b.width];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				Tile t = b.tiles[i][j];
				tiles[i][j] = new Tile(t.row, t.column, t.isHint, t.isOccupied, t.isSelected);
			}
		}
		this.board = new Board(tiles);
				
		//construct bullpen with current state of bullpen
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		for (int i = 0; i < bp.pieces.size(); i++) {
				pieces.add(bp.pieces.get(i));
		}
		this.bullpen = new BullPen(pieces);
		this.score = new PuzzleScore(mg);
		this.name = name;
		ArrayList<Piece> stockPieces = new ArrayList<Piece>();
		for (int i = 0; i < stock.getPieces().size(); i++){
			stockPieces.add(stock.getPiece(i));
		}
		this.stock = new Stock(stockPieces);
		this.movesGiven = mg;
	}
	
	/**
	 * Creates a PuzzleLevelModel with given another PuzzleLevelModel.
	 * @param plm Given PuzzleLevelModel.
	 */
	public PuzzleLevelModel(PuzzleLevelModel plm){
		super(plm);
		this.movesGiven = plm.movesGiven;
	}
	
	/**
	 * getter function for the moves
	 * @return the number of moves allowed
	 */
	public int getMovesAllowed(){
		return this.movesGiven;
	}
	
	/**
	 * setter function for the score
	 * @param score New score
	 */
	public void setScore(PuzzleScore score){
		this.score = score;
	}
}
