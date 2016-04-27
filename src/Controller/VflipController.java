package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.KabaSuji;
import Boundary.PieceView;
import Game.Piece;

public class VflipController implements ActionListener{

	KabaSuji view;
	
	public VflipController(KabaSuji view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		//check if selected piece is in bullpen (otherwise moves not allowed)
		PieceView selected = view.getSelectedPiece();
		if (selected != null){
			Piece p = selected.getP();
			p.verticalFlip();
			selected.drawSelected();
		}
	}
	
}