package Game;

public class LightningLevelModel extends LevelModel{
	
	int timeGiven;
	int timeUsed;
	
	public LightningLevelModel(Board b, BullPen bp, int ln, IScore s, int tg, int tu){
			super(b, bp, ln, s);
			this.timeGiven = tg;
			this.timeUsed = tu;
	}

}
