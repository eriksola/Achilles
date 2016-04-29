package Game;

public class LightningLevelModel extends LevelModel{
	
	int timeGiven;
	int timeUsed;
	
	public LightningLevelModel(Board b, BullPen bp, int ln, IScore s, int tg){
			super(b, bp, ln, s);
			this.timeGiven = tg;
			this.timeUsed = 0;
	}

	public LightningLevelModel(LightningLevelModel m) {
		super(m);
		this.timeGiven = m.timeGiven;
	}

	public int getTime(){
		return this.timeGiven;
	}
	

}
