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
import Game.Tile;

/**
 * 
 * Controller to specify actions for when a piece is clicked in the bullpen.
 * @author Wolfson
 *
 */
public class BullPenController extends java.awt.event.MouseAdapter{
	
	KabaSuji view; /** the panel being displayed by the app **/
	BullPenView bpv; /** The bull pen boundary object **/
	BoardView bv; /** the board boundary object **/
	
	/**
	 * Constructor.
	 */
	public BullPenController(KabaSuji view, BullPenView bpv, BoardView bv){
		this.view = view;
		this.bpv = bpv;
		this.bv = bv;
	}
	
	/**
	 * When a piece is clicked select it.
	 */
	public void mouseClicked(MouseEvent me){
		System.out.println("mouse clicked from bullpen");
		
		//if there is a selected Piece
		if(view.getSelectedPiece() != null){
			
			//add the piece to the bullpen
			bpv.addPiece(new PieceView(view.getSelectedPiece().getP(), view));
			view.getScrollPane().setViewportView(bpv);
			
			//if its from the board, remove it from the board
			HashMap<Tile,Piece> piecesOnBoard = bv.getBoard().getPieces();
			if (piecesOnBoard.containsValue(view.getSelectedPiece().getP())){
				
				//get info for removing piece from board -
				//location of the anchor point of the piece
				Tile c = bv.getSelectedTile();
				Piece piece = piecesOnBoard.get(c);
				Coordinate pieceAnchor = piece.getAnchorOnBoard();
				int col = pieceAnchor.x;
				int row = pieceAnchor.y;
				Board board = bv.getBoard();
				board.removePiece(row, col, view.getSelectedPiece());
				bv.draw();
			}
			//make the piece unselected
			view.removeSelected();
		}
	}

}
