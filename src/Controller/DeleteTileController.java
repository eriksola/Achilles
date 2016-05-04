package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Builder.KabaSujiBuilder;
import Game.Board;
import Game.Tile;

public class DeleteTileController implements ActionListener{
	
	KabaSujiBuilder view;
	
	public DeleteTileController(KabaSujiBuilder v){
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Tile selectedTile = view.getBoardView().getSelectedTile();
		Tile[][] tiles = view.getBoardView().getBoard().getTiles();
		
		if (selectedTile != null){
			view.addLevelModel();
			int col = selectedTile.getCol();
			int row = selectedTile.getRow();
			view.getBoardView().deselectTile();
			tiles[col][row] = null;
		} 
		view.getBoardView().draw();
	}
}
