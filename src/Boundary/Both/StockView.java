package Boundary.Both;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;

import Game.Stock;

public class StockView extends JPanel {

	private PieceView pieceViews[];
	JFrame frame;
	Stock s;
	KabaSuji view;
	/**
	 * Create the panel.
	 */
	public StockView(JFrame f, Stock s, KabaSuji view) {
		this.frame = f;
		this.s = s;
		this.view = view;
	
		setBackground(Color.WHITE);
		setPieceViews(new PieceView[s.getPieces().size()]);
		for(int i = 0; i < getPieceViews().length; i++){
			getPieceViews()[i] = new PieceView(s.getPieces().get(i),view);
			add(getPieceViews()[i].getLabel());
			repaint();
		}
		

	}
	
	public PieceView[] getPieceViews() {
		return pieceViews;
	}

	public void setPieceViews(PieceView pieceViews[]) {
		this.pieceViews = pieceViews;
	}

	

}

