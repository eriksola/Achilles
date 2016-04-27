package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Game.Piece;

public class HflipController implements ActionListener{

	KabaSuji view;
	
	public HflipController(KabaSuji view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		//check if selected piece is in bullpen (otherwise moves not allowed)
		PieceView selected = view.getSelectedPiece();
		if(selected != null){
			Piece p = selected.getP();
			p.horizontalFlip();
			selected.drawSelected();
		}
	}
	
}
