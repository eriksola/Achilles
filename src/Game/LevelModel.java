package Game;

import java.util.ArrayList;
import java.util.List;

/**
 * LevelModel is the superclass for any type of level in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LevelModel {
	
	Board board; /** The board of the level **/
	BullPen bullpen; /** The bullpen of the level **/
	String name; /** The name of the level **/
	IScore score; /** the score of the level **/
	Stock stock; /** the stock left for the level **/
	
	/**
	 * Creates a LevelModel with all of the entities needed for a level.
	 * @param b Board for a level.
	 * @param bp Bullpen for a level.		
	 * @param ln Level number for a level
	 * @param s Encapsulates the score associated with a LevelModel.
	 */
	public LevelModel(Board b, BullPen bp, String name, ReleaseScore s, Stock stock){
		//construct board with current state of Board
		Tile[][] tiles = new Tile[b.getHeight()][b.getWidth()];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (b.tiles[i][j] != null){
					Tile t = b.tiles[i][j];
					if (t instanceof ReleaseTile){
						ReleaseTile rt = (ReleaseTile) t;
						tiles[i][j] = new ReleaseTile(t.row, t.column, t.isHint, t.isOccupied, t.isSelected, rt.getColNum());
					}
					else{
						tiles[i][j] = new Tile(t.row, t.column, t.isHint, t.isOccupied, t.isSelected);
					}
				}
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
		this.score = new ReleaseScore();
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
	
	/**
	 * Constructor to override super() for extended classes
	 */
	public LevelModel() {
	}
	
	/**
	 * getter function for the board
	 * @return the board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	/**
	 * getter function for the bullpen
	 * @return the bullpen
	 */
	public BullPen getBullPen(){
		return this.bullpen;
	}
	
	/**
	 * getter function for the name of the level
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * getter function for the score of the level
	 * @return the score
	 */
	public IScore getScore(){
		return this.score;
	}
	
	/**
	 * getter function for the stock left for the level
	 * @return remaining stock
	 */
	public Stock getStock(){
		return this.stock;
	}
	
	/**
	 * if the player earns a better score, save it as the new top score
	 * @param currentScore the new top score
	 */
	public void setScore(IScore currentScore) {
		this.score = currentScore;
	}
}
