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
	 * Highlights the clicked PieceView, unmarks previously selected PieceView if present.
	 */
	public void mouseClicked(MouseEvent me){
		System.out.println("mouse clicked on piece");
		
		//if you click on a piece thats already selected, make it unselected
		if (view.getSelectedPiece() == pv){
			view.removeSelected();
		}
		
		//if this is the puzzle player, the selected piece may be from the board
		else if (view instanceof PuzzleLevelPanel){
			
			PuzzleLevelPanel puzzlePanel = (PuzzleLevelPanel) view;
			BoardView boardView = puzzlePanel.getBoardView();
			HashMap<Tile,Piece> piecesOnBoard = puzzlePanel.getBoardView().getBoard().getPieces();
			
			//if there is a selected piece/tile from the board, unselect that piece/tile and redraw the board
			if (piecesOnBoard.containsValue(view.getSelectedPiece())){
				Piece boardPiece = piecesOnBoard.get(boardView.getSelectedTile());
				Coordinate pieceAnchor = boardPiece.getAnchorOnBoard();
				int col = pieceAnchor.x;
				int row = pieceAnchor.y;
				Board board = boardView.getBoard();
				board.deselectPiece(row, col, view.getSelectedPiece());
			}
			view.setSelected(pv);
			boardView.deselectTile();
		}
		
		//otherwise make that piece the selected piece
		else {
		view.setSelected(pv);
		view.getBoardView().deselectTile();
		}

	}
}
