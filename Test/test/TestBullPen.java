package test;

import java.util.ArrayList;

import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import junit.framework.TestCase;

public class TestBullPen extends TestCase {

	Coordinate c1 = new Coordinate(0,0);
	Coordinate c2 = new Coordinate(1,0);
	Coordinate c3 = new Coordinate(0,1);
	Coordinate c4 = new Coordinate(-1,0);
	Coordinate c5 = new Coordinate(0,-1);
	Coordinate c6 = new Coordinate(0,-2);
	Coordinate c7 = new Coordinate(-2,0);
	Coordinate c8 = new Coordinate(2,0);


	Piece p1 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c6},0);
	Piece p2 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c7},0);
	Piece p3 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c8},0);
	Piece p4 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c6},0);
	

	


	public void testGetSelectedPiece(){
		ArrayList<Piece> a = new ArrayList<Piece>();
		a.add(p1);
		a.add(p2);
		
		BullPen b1 = new BullPen(a);
		
		b1.setSelectedPiece(p2);
		assertTrue(b1.selectedPiece == p2);
	}
}
