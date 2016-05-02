package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Game.Board;
import Game.Tile;

public class DeleteTileController implements ActionListener{
	
	KabaSuji view;
	
	public DeleteTileController(KabaSuji v){
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Tile selectedTile = view.getBoardView().getSelectedTile();
		Tile[][] tiles = view.getBoardView().getBoard().getTiles();
		int col = selectedTile.getCol();
		int row = selectedTile.getRow();
		
		if (selectedTile != null){
			view.getBoardView().deselectTile();
			tiles[col][row] = null;
		} 
		
		view.getBoardView().draw();
	}
}
