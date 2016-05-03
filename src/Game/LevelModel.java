package Game;

import java.util.ArrayList;

/**
 * LevelModel is the superclass for any type of level in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LevelModel {
	Board board;
	BullPen bullpen;
	int levelNum;
	IScore score;
	
	/**
	 * Creates a LevelModel with all of the entities needed for a level.
	 * @param b Board for a level.
	 * @param bp Bullpen for a level.
	 * @param ln Level number for a level
	 * @param s Encapsulates the score associated with a LevelModel.
	 */
	public LevelModel(Board b, BullPen bp, int ln, IScore s){
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
		this.levelNum = ln;
		this.score = s;
	}
	
	/**
	 * Creates a LevelModel given a LevelModel.
	 * @param lm LevelModel given.
	 */
	public LevelModel(LevelModel lm){
		this.board = lm.board;
		this.bullpen = lm.bullpen;
		this.levelNum = lm.levelNum;
		this.score = lm.score;
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
