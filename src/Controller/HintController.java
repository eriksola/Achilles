package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Both.PieceView;
import Game.Piece;

public class HintController implements ActionListener{

	KabaSuji view;
	
	public HintController(KabaSuji view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		//check if selected piece is in bullpen (otherwise moves not allowed)
		view.addLevelModel();
		PieceView selected = view.getSelectedPiece();
		view.getBoardView().getBoard().registerHintPiece(selected.getP());
		view.getBoardView().draw();
	}
	
}
