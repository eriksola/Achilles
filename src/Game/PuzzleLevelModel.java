package Game;

import java.util.ArrayList;

/**
 * PuzzleLevelModel holds all the logic for a PuzzleLevel type in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class PuzzleLevelModel extends LevelModel{
	
	int movesGiven;
	int movesUsed;
	
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
		setScore((PuzzleScore) s);
		ArrayList<Piece> stockPieces = new ArrayList<Piece>();
		for (int i = 0; i < stock.getPieces().size(); i++){
			stockPieces.add(stock.getPiece(i));
		}
		this.stock = new Stock(stockPieces);
		this.movesGiven = mg;
		this.movesUsed = 0;
	}
	
	/**
	 * Creates a PuzzleLevelModel with given another PuzzleLevelModel.
	 * @param plm Given PuzzleLevelModel.
	 */
	public PuzzleLevelModel(PuzzleLevelModel plm){
		super(plm);
		this.movesGiven = plm.movesGiven;
		this.movesUsed = 0;
	}
	
	public int getMovesAllowed(){
		return this.movesGiven;
	}
	
	public void setScore(PuzzleScore score){
		/**Get the number of pieces on the board (because the HashMap is Tile,Piece there will be 6 copies of a piece, one for each tile) **/
		int used = board.getPieces().size()/6; 
		/**Get the number of pieces in the bullpen and add to pieces on the board to get the total **/
		int total = bullpen.getPieces().size() + used;
		this.score = new PuzzleScore(total, used);
	}
}
