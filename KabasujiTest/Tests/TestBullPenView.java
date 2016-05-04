package Tests;

import Boundary.Both.BullPenView;
import Boundary.Both.PieceView;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import junit.framework.TestCase;

public class TestBullPenView extends TestCase {
	Stock s = new Stock();
	LevelBuilderFrame lf = new LevelBuilderFrame(s);
	LevelBuilderPuzzlePanel p = new LevelBuilderPuzzlePanel(lf);
	
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
	
	BullPen bp = new BullPen();
	PieceView pv1;
	PieceView pv2;
	PieceView pv3;
	PieceView pv4;
	BullPenView bpv;
	
	public void setUp(){
		bp.addPiece(p1);
		bp.addPiece(p2);
		bp.addPiece(p3);
		bp.addPiece(p4);
		
		p = new LevelBuilderPuzzlePanel(lf);
		pv1 = new PieceView(p1, p);
		pv2 = new PieceView(p2, p);
		pv3 = new PieceView(p3, p);
		pv4 = new PieceView(p4, p);

		bpv = new BullPenView(lf, bp, p);
		bpv.addPiece(pv1);
		bpv.addPiece(pv2);
		bpv.addPiece(pv3);
		bpv.addPiece(pv4);
		//bpv.draw();
			
	}
	
	
	public void testRemovePiece(){
		bpv.remove(pv2);
		
		//Make sure the piece view is not there afterwards
		
		assertFalse(bpv.getPieceViews().contains(pv2));
	}
	
}
