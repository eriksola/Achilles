package Game;

public class Piece {

	Coordinate[] coords = new Coordinate[6];
	int bpIndex;
	
	public Piece(Coordinate[] coords, int bp){
		this.coords = coords;
		this.bpIndex = bp;
	}	
}
