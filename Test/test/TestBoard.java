package test;

import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Tile;
import junit.framework.TestCase;

public class TestBoard extends TestCase {
	Tile[][] t = new Tile[6][6];
	Board board = new Board(t);

	Coordinate c1 = new Coordinate(0,0);
	Coordinate c2 = new Coordinate(1,0);
	Coordinate c3 = new Coordinate(0,1);
	Coordinate c4 = new Coordinate(-1,0);
	Coordinate c5 = new Coordinate(0,-1);
	Coordinate c6 = new Coordinate(0,-2);

	Piece p1 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c6},0);


	public void testIsValid(){
		for (int i =0; i < 6; i++){
			for (int y = 0; y < 6; y++){
				t[i][y] = new Tile(false, i, y);
			}
		}
		assertFalse(board.isValid(7, 6));
		assertTrue(board.isValid(5, 5));
		assertFalse(board.isValid(-1, 1));

		t[5][5] = new Tile(true,5, 5);
		assertFalse(board.isValid(5, 5));

	}

//	public void testAddPiece(){
//
//	}
}
