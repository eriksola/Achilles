package Controller;

import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JLabel;

import Boundary.Both.BoardView;
import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Player.PuzzleLevelPanel;
import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Tile;

/**
 * Controller class for Pieces - main function is highlighting a selected Piece.
 * @author bwolfson
 *
 */
public class PieceController extends java.awt.event.MouseAdapter{
	
	KabaSuji view; /** the main KabaSuji view. **/
	PieceView pv; /** the view of the Piece being controlled. **/
	
	/**
	 * Constructor.
	 * @param view
	 * @param pv
	 */
	public PieceController(KabaSuji view, PieceView pv){
		this.view = view;
		this.pv = pv;
	}
	
	/**
	 * highlight the clicked PieceView, unmark previously selected PieceView if present.
	 */
	public void mouseClicked(MouseEvent me){
		System.out.println("mouse clicked on piece");
		
		//if you click on a piece thats already selected, make it unselected
		if (view.getSelectedPiece() == pv){
			view.removeSelected();
		}
		//if this is the puzzle player, the selected piece may be from the board
		if (view instanceof PuzzleLevelPanel){
			
			PuzzleLevelPanel puzzlePanel = (PuzzleLevelPanel) view;
			BoardView boardView = puzzlePanel.getBoardView();
			HashMap<Tile,PieceView> piecesOnBoard = puzzlePanel.getBoardView().getBoard().getPieces();
			
			//if there is a selected piece from the board, unselect that piece and redraw the board
			if (piecesOnBoard.containsValue(view.getSelectedPiece())){
				PieceView boardPieceView = piecesOnBoard.get(boardView.getSelectedTile());
				Piece boardPiece = boardPieceView.getP();
				Coordinate pieceAnchor = boardPiece.getAnchorOnBoard();
				int col = pieceAnchor.x;
				int row = pieceAnchor.y;
				Board board = boardView.getBoard();
				board.deselectPiece(row, col, view.getSelectedPiece());
				boardView.draw();
			}
			view.setSelected(pv);
		}
		//otherwise make that piece the selected piece
		else {
		view.setSelected(pv);
		}

	}
}
