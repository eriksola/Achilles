package Main;

import javax.swing.JFrame;

import Boundary.BullPenView;
import Boundary.KabaSuji;
import Game.BullPen;
import Game.Stock;

public class test {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Stock s = new Stock();
		BullPen bp = new BullPen(null, s.getRandomPiecesForPen());
		BullPenView bpv = new BullPenView(frame, bp, new KabaSuji());
		frame.getContentPane().add(bpv);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
