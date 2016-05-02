package Game;

public class ReleaseTile extends Tile{
	
	ColorNumber colNum;
	
	ReleaseTile(boolean isOccupied, int row, int column, ColorNumber cn){
		super(row, column);
		this.colNum = cn;
	}
	
	public ColorNumber getColNum(){
		return this.colNum;
	}
}
