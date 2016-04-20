package Boundary;

import javax.swing.JPanel;

import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Boundary.PieceView;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class BullPenView extends JPanel {
	
	BullPen bp;
	Piece[] pieces;
	PieceView[] pieceView;
	KabasujiFrame frame;
	Stock s = new Stock();
	/**
	 * Create the panel.
	 */
	public BullPenView(KabasujiFrame f) {
		this.frame = f;

		
		pieces = s.getRandomPiecesForPen();
		pieceView = new PieceView[pieces.length];
		bp = new BullPen(pieces, pieceView);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 133, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		setBackground(Color.white);
		addPiecesToPen();
		
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(1,0);
		Coordinate c3 = new Coordinate(-1,0);
		Coordinate c4 = new Coordinate(0,1);
		Coordinate c5 = new Coordinate(0,-1);
		Coordinate c6 = new Coordinate(0,-2);
		//   $
		// $ $ $
		//   $
		//   $
		Coordinate[] coords = {c1,c2,c3,c4,c5,c6};
		Piece p = new Piece(coords, 0);
		PieceView pv = new PieceView(p);
		bp = new BullPen(new Piece[]{p}, new PieceView[]{pv});
		bp.selectedPiece = p;
		
		ImageIcon img = new ImageIcon(pv.getBufferedImage());
		JLabel label = new JLabel(img);

		
		
		setLayout(new FlowLayout()); 
		add(label);
		
	}
	
	/**
	 * Add random pieces to the bullpen.
	 */
	public void addPiecesToPen() {
		for(int i = 0; i < pieces.length; i++){
			PieceView pv = new PieceView(pieces[i]);
			pieceView[i] = pv;	
		}
			
		for(int i = 0; i < pieces.length; i++){
			bp.selectedPiece = pieces[i];
			ImageIcon img = new ImageIcon(pieceView[i].getBufferedImage());
			JLabel label = new JLabel(img);
			setLayout(new FlowLayout()); 
			add(label);
			
		}
		
	}

	
}
