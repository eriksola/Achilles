package Game;

import java.util.ArrayList;

/**
 * LightningLevelModel holds all the logic for a LightningLevel type in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LightningLevelModel extends LevelModel{
	
	//LightningBoard lightBoard;
	int timeGiven;
	int timeUsed;
	LightningBoard lightBoard;
	
	/**
	 * Creates a LightningLevelModel with all the entity objects needed to complete a LightningLevel.
	 * @param b Board within a LightningLevel.
	 * @param bp Bullpen within a LightningLevel.
	 * @param ln Number of the level.
	 * @param s Encapsulates the type of score associated with this level.
	 * @param tg Time given to complete this LightningLevel Level.
	 */
	public LightningLevelModel(Board lightningBoard, BullPen bp, String name, IScore s, Stock stock, int tg){
			super();

			Tile[][] tiles = new Tile[lightningBoard.getHeight()][lightningBoard.getWidth()];
			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles[0].length; j++) {
					Tile t = lightningBoard.tiles[i][j];
					tiles[i][j] = new Tile(t.row, t.column, t.isHint, t.isOccupied, t.isSelected);
				}
			}
			//this.lightningBoard = new LightningBoard(tiles);
			this.lightBoard = new LightningBoard(tiles);
			
			//construct bullpen with current state of bullpen
			ArrayList<Piece> pieces = new ArrayList<Piece>();
			for (int i = 0; i < bp.pieces.size(); i++) {
				pieces.add(bp.pieces.get(i));
			}
			this.bullpen = new BullPen(pieces);
			this.name = name;
			int totalTiles = 0;
			for (int i = 0; i < tiles.length; i++){
				for (int j = 0; j < tiles[0].length; j++){
					if (tiles[i][j] != null) {totalTiles++;}
				}
			}
			this.score = new LightningScore(totalTiles);
			ArrayList<Piece> stockPieces = new ArrayList<Piece>();
			for (int i = 0; i < stock.getPieces().size(); i++){
				stockPieces.add(stock.getPiece(i));
			}
			this.stock = new Stock(stockPieces);
			this.timeGiven = tg;
			this.timeUsed = 0;
	}

	/**
	 * Creates a LightningLevelModel with given another LightningLevelModel.
	 * @param plm Given LightningLevelModel
	 */
	public LightningLevelModel(LightningLevelModel m) {
		super(m);
		this.timeGiven = m.timeGiven;
	}

	public int getTime(){
		return this.timeGiven;
	}
	
	public LightningBoard getLightningBoard(){
		return lightBoard;
	}
	
	public void setScore(LightningScore currentScore) {
		this.score = currentScore;
	}
}
