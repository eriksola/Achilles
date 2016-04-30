package test;

import javax.swing.JFrame;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestBoard extends TestCase {
	Tile[][] t = new Tile[6][6];
	Board board = new Board(t);
	Stock s = new Stock();
	LevelBuilderFrame frame = new LevelBuilderFrame(s);
	LevelBuilderPuzzlePanel view = new LevelBuilderPuzzlePanel(frame);

	Coordinate c1 = new Coordinate(0,0);
	Coordinate c2 = new Coordinate(1,0);
	Coordinate c3 = new Coordinate(0,1);
	Coordinate c4 = new Coordinate(-1,0);
	Coordinate c5 = new Coordinate(0,-1);
	Coordinate c6 = new Coordinate(0,-2);

	Piece p1 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c6},0);
	/*
	 *    #  
	 *  # # #
	 *    # 
	 *    #
	 */
	PieceView pv = new PieceView(p1, view);
	
	public void setUp(){
		for (int i =0; i < 6; i++){
			for (int y = 0; y < 6; y++){
				t[i][y] = new Tile(i, y);
			}
		}
	}

	public void testIsValid(){
		assertFalse(board.isValid(7, 6));
		assertTrue(board.isValid(5, 5));
		assertFalse(board.isValid(-1, 1));

		t[5][5].setOccupied(true);
		assertFalse(board.isValid(5, 5));
		t[5][5].setOccupied(false);

	}

	public void testAddPiece(){
		assertTrue(board.addPiece(2, 3, pv));
	}
	
	
	public void testRemovePiece(){
		assertTrue(board.removePiece(2, 3, pv));
	}
	
	
	public void testSelectPiece(){
		board.addPiece(1, 1, pv);
		assertTrue(board.selectPiece(1, 1, pv));
	}
	
	
}
