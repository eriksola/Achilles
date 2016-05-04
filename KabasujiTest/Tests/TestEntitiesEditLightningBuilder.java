package Tests;

import java.util.ArrayList;

import Boundary.Both.Deserialization;
import Boundary.Both.PieceView;
import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.LevelBuilderFrame;
import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestEntitiesEditLightningBuilder extends TestCase {
	Tile[][] t = new Tile[6][6];
	Board board;
	Stock s = new Stock();
	LevelBuilderFrame frame = new LevelBuilderFrame(s);
	Deserialization d = new Deserialization();
	EditLightningLevelPanel view;

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
		if(d.Deserialize("./src/DefaultLevels/LightningLevels/1.txt", 1)){
			System.out.println("Level deserialized.");
		}
		else{
			System.err.println("Error in serialization importing process!");
		}
		view = new EditLightningLevelPanel(frame, d, 2);
		for (int i =0; i < 6; i++){
			for (int y = 0; y < 6; y++){
				t[i][y] = new Tile(i, y);
			}
		}
	}
	
	/////////////////////////////Board Tests////////////////////////////////


	

	
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
