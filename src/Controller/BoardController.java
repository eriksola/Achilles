package Controller;

import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Tile;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import Boundary.Builder.*;
import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.KabaSujiPlayer;
import Boundary.Both.PieceView;
import Boundary.Player.PuzzleLevelPanel;

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
	 * Depicts adding a PieceView to the board if one was selected prior.
	 */
	public void mouseClicked(MouseEvent me){
		
		Point p = me.getPoint();
		
		boolean isBuilder = (view instanceof LevelBuilderPuzzlePanel) ||
				(view instanceof LevelBuilderLightningPanel) ||
				(view instanceof LevelBuilderReleasePanel) ||
				(view instanceof EditPuzzleLevelPanel) ||
				(view instanceof EditLightningLevelPanel) ||
				(view instanceof EditReleaseLevelPanel);
		
		//if there is a selected piece
		if (view.getSelectedPiece() != null){
			
			System.out.println("Mouse clicked to board");
			System.out.println(p.x);
			System.out.println(p.y);
			int row = -1;
			int col = -1;
			
			//get the row and column of the tile that was clicked on
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
			
			PieceView pv = view.getSelectedPiece();
			Board brd = bv.getBoard();
			

			//check if this is a puzzle level
			if(view instanceof PuzzleLevelPanel || isBuilder){
				
				HashMap<Tile,Piece> piecesOnBoard = bv.getBoard().getPieces();
				
				//check if the piece is coming from the board
				System.out.println("Piece coming from board? " + piecesOnBoard.containsValue(view.getSelectedPiece()));
				if (piecesOnBoard.containsValue(view.getSelectedPiece().getP())){
					
					//get info for removing piece from board -
					//location of the anchor point of the piece
					Tile oldLocation = bv.getSelectedTile();
					Piece piece = piecesOnBoard.get(oldLocation);
					Coordinate pieceAnchor = piece.getAnchorOnBoard();
					int oldCol = pieceAnchor.getX();
					int oldRow = pieceAnchor.getY();
					
					//add the piece to the board in the new location
					if(brd.addPiece(row,col,pv)){
						
						//remove the piece from the old location
						brd.removePiece(oldRow, oldCol, pv);

						//if this is the player, update the score of the level
						if (view instanceof KabaSujiPlayer){
							KabaSujiPlayer player = (KabaSujiPlayer) view;
							player.updateScore();
							
							//if this is a puzzle level, decrement the moves left
							if (player instanceof PuzzleLevelPanel){
								PuzzleLevelPanel puzzlePlayer = (PuzzleLevelPanel) player;
								puzzlePlayer.useMove();
							}
						}
						//unselect the piece and draw
						view.removeSelected();
						bv.draw();
					}
				}
			}
			
			//otherwise the piece must be from the bullpen
			if(brd.addPiece(row,col,pv)){
					
				//redraw the board
				bv.draw();
				
				//remove the piece from the bullpen
				bpv.remove(pv);
				
				view.getScrollPane().setViewportView(bpv);
				view.removeSelected();
				
				//if this is the player, update the score of the level
				if (view instanceof KabaSujiPlayer){
					KabaSujiPlayer player = (KabaSujiPlayer) view;
					player.updateScore();
					
					//if this is a puzzle level, decrement the moves left
					if (player instanceof PuzzleLevelPanel){
						PuzzleLevelPanel puzzlePlayer = (PuzzleLevelPanel) player;
						puzzlePlayer.useMove();
					}
				}	
			}
			//if there was a selected piece end the function here
			return;
		}
		

		// if there is no selected piece and this is a puzzle level
		else if (view instanceof PuzzleLevelPanel || isBuilder){
		
			System.out.println("Mouse clicked from board");
			//pieces can be removed from the board while no piece is selected
			HashMap<Tile, Piece> piecesOnBoard = bv.getBoard().getPieces();
			int row = -1;
			int col = -1;
			
			//get the row and column of the tile that was clicked on
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
			
			//select the piece on the board at that row and column
			Tile t = bv.getBoard().getTiles()[row][col];
			bv.setSelectedTile(t);
			if (piecesOnBoard.containsKey(t)){
				Piece piece = piecesOnBoard.get(t);
				PieceView pv = new PieceView(piece, this.view);
				view.setSelected(pv);
				Coordinate c = pv.getP().getAnchorOnBoard();
				col = c.x;
				row = c.y;
				bv.getBoard().selectPiece(row, col, pv);
				bv.draw();
			}
		}
	}
}
