package Game;

import Game.Coordinate;

public class Piece {

	private Coordinate[] coords = new Coordinate[6];
	int bpIndex;

	public Piece(Coordinate[] coords, int bp){
		this.setCoordinates(coords);
		this.bpIndex = bp;
	}	
	
	public Coordinate[] getCoordinates(){
		return this.coords;
	}

	public void setCoordinates(Coordinate[] coords) {
		this.coords = coords;
	}
}