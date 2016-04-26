package Controller;


import java.awt.Point;
import java.awt.event.MouseEvent;

import Boundary.BullPenView;
import Boundary.KabaSuji;
import Boundary.LevelBuilderPuzzlePanel;
import Boundary.PieceView;
import Game.Board;
import Game.Piece;

public class BullPenController extends java.awt.event.MouseAdapter{
	
	KabaSuji view;
	BullPenView bpv;
	
	public BullPenController(KabaSuji view, BullPenView bpv){
		this.view = view;
		this.bpv = bpv;
	}
	
	public void mouseClicked(MouseEvent me){
		Point p = me.getPoint();
		System.out.println("mouse clicked from bullpen");
		if(view.getSelectedPiece() != null){
			bpv.addPiece(new PieceView(view.getSelectedPiece().getP(), view));
			view.getScrollPane().setViewportView(bpv);
		}
	}

}
