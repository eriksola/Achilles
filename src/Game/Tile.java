package Game;

import java.io.Serializable;

public class Tile implements Serializable{
	
	boolean isOccupied;
	boolean isSelected;
	int row;
	int column;
	
	public Tile(int r, int c){
		this.isOccupied = false;
		this.isSelected = false;
		this.row = r;
		this.column = c;
	}
	
	public boolean isOccupied(){
		return this.isOccupied;
	}
	
	public void setOccupied(boolean bool){
		this.isOccupied = bool;
	}
	public boolean isSelected(){
		return this.isSelected;
	}
	
	public void setSelected(boolean bool){
		this.isSelected = bool;
	}
}
//>>>>>>> refs/remotes/origin/master