package Tests;

import java.util.ArrayList;

import javax.swing.JFrame;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestEntitiesBuilder extends TestCase {
	
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
	Coordinate c7 = new Coordinate(-2,0);
	Coordinate c8 = new Coordinate(2,0);

	Piece p1 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c6});
	Piece p2 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c7});
	Piece p3 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c8});
	Piece p4 = new Piece(new Coordinate[]{c1,c2,c3,c4,c5,c6});
	
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
		view.setSelected(pv);
		view.removeSelected();
	}
	
	/////////////////////////////Board Tests////////////////////////////////


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
	
	//////////////////////////////Piece Tests////////////////////////////////
	
	public void testRotation(){
		Coordinate[] originals = p1.getCoordinates();
		p1.rotateRight();
		p1.rotateLeft();
		for (int i = 0; i < originals.length; i++) {
			assertEquals(originals[i].x, p1.getCoordinates()[i].x);
			assertEquals(originals[i].y, p1.getCoordinates()[i].y);
		}
		
	}
	
	public void testFlips(){
		String pString = p1.toString();
		Coordinate[] originals = p1.getCoordinates();
		p1.verticalFlip();
		p1.verticalFlip();
		p1.horizontalFlip();
		p1.horizontalFlip();
		for (int i = 0; i < originals.length; i++) {
			assertEquals(originals[i].x, p1.getCoordinates()[i].x);
			assertEquals(originals[i].y, p1.getCoordinates()[i].y);
		}
		
	}
	
	///////////////////////////BullPen Tests///////////////////////////////

	public void testGetSelectedPiece(){
		ArrayList<Piece> a = new ArrayList<Piece>();
		a.add(p1);
		a.add(p2);
		
		BullPen b1 = new BullPen(a);
		b1.addPiece(p3);
		
		b1.setSelectedPiece(p2);
		assertTrue(b1.selectedPiece == p2);
		assertEquals(b1.getSelectedPiece(),p2);
	}
	
}
