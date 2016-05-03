package Tests;

import java.util.ArrayList;

import Boundary.Both.PieceView;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.LightningLevelPanel;
import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.IScore;
import Game.LightningBoard;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestEntitiesLightningPlayer extends TestCase {
	Tile[][] tiles;
	LightningBoard board;
	Stock s = new Stock();
	KabasujiFrame frame = new KabasujiFrame();

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
	
	BullPen bp;
	IScore lScore;
	
	LightningLevelModel lLevelModel;
	LightningLevelPanel view;
	
	
	
	/*
	 *    #  
	 *  # # #
	 *    # 
	 *    #
	 */
	PieceView pv;
	
	@Override
	public void setUp(){
		tiles = new Tile[6][6];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				Tile t = tiles[i][j];
				tiles[i][j] = new Tile(i, j, false, false, false);
			}
		}
		this.board = new LightningBoard(tiles);
		
		bp = new BullPen();
		lScore = new LightningScore(7);
		lLevelModel = new LightningLevelModel(board, bp, "lightning", (LightningScore) lScore, new Stock(), 100);
		view = new LightningLevelPanel(frame, lLevelModel);
		pv = new PieceView(p1, view);
	}
	
	/////////////////////////////Board Tests////////////////////////////////

	public void testIsValid(){
		assertFalse(board.isValid(7, 6));
		assertTrue(board.isValid(5, 5));
		assertFalse(board.isValid(-1, 1));

		tiles[5][5].setOccupied(true);
		assertFalse(board.isValid(5, 5));
		tiles[5][5].setOccupied(false);

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


