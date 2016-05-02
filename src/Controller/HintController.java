package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.BullPenView;
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
		PieceView selected = view.getSelectedPiece();
		if (selected != null){
			//set as a hint on the board
			view.getBoardView().getBoard().registerHintPiece(selected.getP());
			view.getBoardView().draw();
			//and add the piece to the bullpen
			BullPenView bpView = view.getBullPenView();
			bpView.addView(new PieceView(selected.getP(), view));
			view.getScrollPane().setViewportView(bpView);
		}
	}
	
}
