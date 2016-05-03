package Game;

public class ReleaseTile extends Tile{
	
	ColorNumber colNum;
	
	public ReleaseTile(int c, int r, ColorNumber cn){
		super(c, r);
		this.colNum = cn;
		this.isOccupied = false;
		this.isSelected = false;
		this.isHint = false;
	}
	
	public ColorNumber getColNum(){
		return this.colNum;
	}
}
