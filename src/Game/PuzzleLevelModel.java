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
	public PuzzleLevelModel(Board b, BullPen bp, String name, IScore s, Stock stock, int mg){
		super();
		Tile[][] tiles = new Tile[board.height][board.width];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				Tile t = board.tiles[i][j];
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
		this.name = name;
		this.score = s;
		this.stock = stock;
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
}
