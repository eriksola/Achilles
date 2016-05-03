package Controller;

import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Game.Tile;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import Boundary.Builder.*;
import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Boundary.Both.StockView;
import Boundary.Player.KabaSujiPlayer;
import Boundary.Player.LightningLevelPanel;
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
					int leftX = j * 20;
					int rightX = j * 20 + 20;
					int topY = i * 20;
					int botY = i * 20 + 20;
					if(p.x >= leftX && p.x <= rightX && p.y >= topY && p.y <= botY){
						row = i;
						col = j;
					}
				}
			}
			
			PieceView pv = view.getSelectedPiece();
			Board brd = bv.getBoard();
			
			if(view instanceof PuzzleLevelPanel || isBuilder){
				
				HashMap<Tile,Piece> piecesOnBoard = bv.getBoard().getPieces();
				Piece selectedPiece = view.getSelectedPiece().getP();
				
				//check if the piece is coming from the board
				if (piecesOnBoard.containsValue(selectedPiece)){
					
					//get info for removing piece from board -
					//location of the anchor point of the piece
					Tile oldLocation = bv.getBoard().getSelectedPieceAnchor();
					Piece piece = piecesOnBoard.get(oldLocation);
					Coordinate pieceAnchor = piece.getAnchorOnBoard();
					int oldCol = pieceAnchor.getX();
					int oldRow = pieceAnchor.getY();
					
					//if the piece isn't going to move, deselect it
					boolean notMove = false;
					for (int i = 0; i < 6; i++){
						Coordinate c = piece.getCoordinates()[i];
						if ((oldRow - c.y == row) && (oldCol + c.x == col)){
							notMove = true;
						}
					}
					if (notMove){
						view.removeSelected();
						bv.getBoard().deselectPiece(oldRow, oldCol, pv);
						bv.draw();
						return;
					}
					
					//add the piece to the board in the new location
					if(brd.isValidToAdd(row,col,pv)){
						if (view instanceof KabaSujiBuilder){
							((KabaSujiBuilder) view).addLevelModel();
						}
						
						brd.addPiece(row,col,pv);
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
						return;
					}
				}
			}
			
							
			//check if the piece is coming from the bullpen
			if(brd.isValidToAdd(row, col, pv)){
				if (view instanceof KabaSujiBuilder){
					((KabaSujiBuilder) view).addLevelModel();
				}
						
				if (bpv.getPieceViews().contains(pv)){
					if(brd.addPiece(row,col,pv)){
						//redraw the board
						bv.draw();
					
						//remove the piece from the bullpen
						bpv.remove(pv);
					
						//if this is a lightning level
						if (view instanceof LightningLevelPanel){
							//replace the piece with a random one from the stock
							LightningLevelPanel lightningPanel = (LightningLevelPanel) view;
							Stock stock = lightningPanel.getStock();
							PieceView pieceView = new PieceView(stock.getRandomPiece(), this.view);
							bpv.addPiece(pieceView);
							bpv.draw();
						}
						
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
				}
				
				//otherwise the piece must be coming from the stock
				else if (view instanceof KabaSujiBuilder){
					if(brd.isValidToAdd(row,col,pv)){
						((KabaSujiBuilder) view).addLevelModel();
					}
					brd.addPiece(row,col,pv);
					bv.draw();
					KabaSujiBuilder buildView = (KabaSujiBuilder) view;
					StockView stockView = buildView.getStockView();
					Piece selectedPiece = view.getSelectedPiece().getP();
					List<Piece> stockPieces = stockView.getStock().getPieces();
					if (stockPieces.remove(selectedPiece)){
						System.out.println("piece removed from stock");
					}
					stockView.draw();
					view.removeSelected();
				}
			}
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
					int leftX = j * 20;
					int rightX = j * 20 + 20;
					int topY = i * 20;
					int botY = i * 20 + 20;
					if(p.x >= leftX && p.x <= rightX && p.y >= topY && p.y <= botY){
						row = i;
						col = j;
					}
				}
			}
				
			Tile t = bv.getBoard().getTiles()[row][col];
				
			//if that tile is the selected tile, unselect it 
			if (t == bv.getSelectedTile()){
				bv.deselectTile();
			}
				
			//otherwise make that tile the selected tile
			else {
				bv.setSelectedTile(t);
			}	
				
			//if theres a piece at that tile, select that piece
			if (piecesOnBoard.containsKey(t)){
				
				if (view instanceof KabaSujiBuilder){
					((KabaSujiBuilder) view).addLevelModel();
				}
				
				Piece piece = piecesOnBoard.get(t);
				PieceView pv1 = new PieceView(piece, this.view);
				view.setSelected(pv1);
				Coordinate c = pv1.getP().getAnchorOnBoard();
				col = c.x;
				row = c.y;
				bv.getBoard().selectPiece(row, col, pv1);
			}
				
			//redraw board to display selected piece/tile
			bv.draw();		
		}
	}
}