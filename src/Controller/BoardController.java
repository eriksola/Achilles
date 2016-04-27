package Controller;

import Game.Board;
import Game.Piece;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Builder.LevelBuilderPuzzlePanel;

/**
 * Controller for the Board entity class.
 * @author bwolfson
 *
 */
public class BoardController extends java.awt.event.MouseAdapter{
	
	KabaSuji view; /** the main KabaSuji view. **/
	BoardView bv; /** the view of the Piece being controlled. **/
	BullPenView bpv; /** the view of the BullPen that the Piece possibly came from **/
	
	/**
	 * Constructor for a BoardController.
	 * @param view
	 * @param bv
	 * @param bpv
	 */
	public BoardController(KabaSuji view, BoardView bv, BullPenView bpv){
		this.view = view;
		this.bv = bv;
		this.bpv = bpv;
	}

	/**
	 * depicts adding a PieceView to the board if one was selected prior.
	 */
	public void mouseClicked(MouseEvent me){
		Point p = me.getPoint();
		System.out.println(p.x);
		System.out.println(p.y);
		int row = -1;
		int col = -1;
		for(int i = 0; i < bv.getBoard().getTiles().length; i++){
			for(int j = 0; j < bv.getBoard().getTiles()[0].length; j++){
				int leftX = j * 10;
				int rightX = j * 10 + 10;
				int topY = i * 10;
				int botY = i * 10 + 10;
				if(p.x >= leftX && p.x <= rightX && p.y >= topY && p.y <= botY){
					row = i;
					col = j;
				}
			}
		}
		if (view.getSelectedPiece().getP() != null){
			Piece piece = view.getSelectedPiece().getP();
			PieceView pv = view.getSelectedPiece();
			Board brd = bv.getBoard();
			if(brd.addPiece(row,col,piece)){
				
				//remove piece from bullpen
				bpv.remove(pv);
				bpv.getBullPen().removePiece(piece);
				
				//update view
				view.getScrollPane().setViewportView(bpv);
				bv.draw();
				view.setSelected(null);
			}
		}
	}
}
