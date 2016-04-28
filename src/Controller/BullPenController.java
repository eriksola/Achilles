package Controller;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;

public class BullPenController extends java.awt.event.MouseAdapter{
	
	KabaSuji view;
	BullPenView bpv;
	BoardView bv;
	
	public BullPenController(KabaSuji view, BullPenView bpv, BoardView bv){
		this.view = view;
		this.bpv = bpv;
		this.bv = bv;
	}
	
	public void mouseClicked(MouseEvent me){
		System.out.println("mouse clicked from bullpen");
		
		//if there is a selected Piece
		if(view.getSelectedPiece() != null){
			
			//add the piece to the bullpen
			bpv.addPiece(new PieceView(view.getSelectedPiece().getP(), view));
			view.getScrollPane().setViewportView(bpv);
			
			//if its from the board, remove it from the board
			Board board = bv.getBoard();
			HashMap<Coordinate,PieceView> piecesOnBoard = bv.getBoard().getPieces();
			if (piecesOnBoard.containsValue(view.getSelectedPiece())){
				//how to remove piece?
			}
			//make the piece unselected
			view.removeSelected();
		}
	}

}
