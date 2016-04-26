package Main;

import java.util.ArrayList;

import javax.swing.JFrame;

import Boundary.BullPenView;
import Boundary.KabaSuji;
import Game.BullPen;
import Game.Piece;
import Game.Stock;

public class test {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Stock s = new Stock();
		ArrayList<Piece> pieces = s.getRandomPiecesForPen();
		BullPen bp = new BullPen();
		for(Piece p : pieces){
			//bp.add(p);
		}
		BullPenView bpv = new BullPenView(frame, bp, new KabaSuji());
		frame.getContentPane().add(bpv);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
