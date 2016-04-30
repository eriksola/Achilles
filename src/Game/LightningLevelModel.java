package Game;

/**
 * LightningLevelModel holds all the logic for a LightningLevel type in the <b> Kabasuji </b> game.
 * @author Aguila
 *
 */
public class LightningLevelModel extends LevelModel{
	
	int timeGiven;
	int timeUsed;
	
	/**
	 * Creates a LightningLevelModel with all the entity objects needed to complete a LightningLevel.
	 * @param b Board within a LightningLevel.
	 * @param bp Bullpen within a LightningLevel.
	 * @param ln Number of the level.
	 * @param s Encapsulates the type of score associated with this level.
	 * @param tg Time given to complete this LightningLevel Level.
	 */
	public LightningLevelModel(Board b, BullPen bp, int ln, IScore s, int tg){
			super(b, bp, ln, s);
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
	

}
