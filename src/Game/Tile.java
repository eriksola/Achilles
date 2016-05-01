package Game;

import java.io.Serializable;

public class Tile implements Serializable{
	
	boolean isOccupied;
	boolean isSelected;
	boolean isHint;
	int row;
	int column;
	
	public Tile(int r, int c){
		this.isOccupied = false;
		this.isSelected = false;
		this.isHint = false;
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
	
	public boolean isHint(){
		return this.isHint;
	}
	
	public void setHint(boolean bool){
		this.isHint = bool;
	}
}
