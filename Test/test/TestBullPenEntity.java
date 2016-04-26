package test;

import junit.framework.TestCase;

import Game.Stock;
import Game.Piece;
import Game.BullPen;
import Game.Coordinate;

public class TestBullPenEntity extends TestCase{
	
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

	

	
	BullPen b1 = new BullPen(new Piece[]{p1,p2});
	
	
	public void testSetSelectedPiece(){
		
		b1.setSelectedPiece(p1);
		assertTrue(b1.getSelectedPiece() == p1);
		assertFalse(b1.getSelectedPiece() == p2);


	}
	
//	public void testRotateLeft(){
//
//		b1.setSelectedPiece(p4);
//		
//		assertFalse(b1.rotateLeft().getCoordinates() != b1.rotateRight().getCoordinates());
//	}


}
