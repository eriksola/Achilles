package Game;

import java.util.ArrayList;
import java.util.List;

/**
 * LevelModel is the superclass for any type of level in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LevelModel {
	Board board;
	BullPen bullpen;
	String name;
	IScore score;
	Stock stock;
	
	/**
	 * Creates a LevelModel with all of the entities needed for a level.
	 * @param b Board for a level.
	 * @param bp Bullpen for a level.		
	 * @param ln Level number for a level
	 * @param s Encapsulates the score associated with a LevelModel.
	 */
	public LevelModel(Board b, BullPen bp, String name, ReleaseScore s, Stock stock){
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
		this.name = name;
		setScore((ReleaseScore) s);
		ArrayList<Piece> stockPieces = new ArrayList<Piece>();
		for (int i = 0; i < stock.getPieces().size(); i++){
			stockPieces.add(stock.getPiece(i));
		}
		this.stock = new Stock(stockPieces);
	}
	
	/**
	 * Creates a LevelModel copy of a given LevelModel.
	 * @param lm LevelModel given.
	 */
	public LevelModel(LevelModel lm){
		this.board = lm.board;
		this.bullpen = lm.bullpen;
		this.name = lm.name;
		this.score = lm.score;
	}
	
	public LevelModel() {
	}

	public Board getBoard(){
		return this.board;
	}
	
	public BullPen getBullPen(){
		return this.bullpen;
	}
	
	public String getName(){
		return this.name;
	}
	
	public IScore getScore(){
		return this.score;
	}
	
	public Stock getStock(){
		return this.stock;
	}
	
	/**
	 * if the player earns a better score, save it as the new top score
	 * @param currentScore the new top score
	 */
	public void setScore(ReleaseScore currentScore) {
		/**check if any colors were completed and pass the score along **/
		this.score = new ReleaseScore(currentScore.getRed(), currentScore.getYellow(), currentScore.getGreen());
	}
}
