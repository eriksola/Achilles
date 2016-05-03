package Tests;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Builder.EditPuzzleLevelPanel;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Builder.LevelBuilderReleasePanel;
import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.IScore;
import Game.LevelModel;
import Game.Piece;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.Stock;
import Game.Tile;
import junit.framework.TestCase;

public class TestEditPuzzleUndo extends TestCase {
	
	Tile[][] t = new Tile[6][6];
	Board board;
	Stock s = new Stock();
	BullPen bp = new BullPen();
	IScore score = new PuzzleScore(1);
	LevelBuilderFrame frame = new LevelBuilderFrame(s);
	PuzzleLevelModel model;
	Stack<PuzzleLevelModel> levelModels;
	Stack<PuzzleLevelModel> redoModels;
	EditPuzzleLevelPanel view;
	
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
				t[i][y] = new Tile(i, y, false,false,false);
			}
		}
		board = new Board(t);

		model = new PuzzleLevelModel(board, bp, "test", score, 10);
		levelModels = new Stack<PuzzleLevelModel>();
		redoModels = new Stack<PuzzleLevelModel>();
		view = new EditPuzzleLevelPanel(frame, model, levelModels, redoModels);
		view.setSelected(pv);
		view.removeSelected();
	}
	
	public void test(){
		assertTrue(1 == 1);
	}
	
}