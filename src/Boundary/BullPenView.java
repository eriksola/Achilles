package Boundary;

import javax.swing.JPanel;

import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Boundary.PieceView;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class BullPenView extends JPanel {
	
	BullPen bp;
	//bp.selectedPiece = p;
	/**
	 * Create the panel.
	 */
	public BullPenView(KabasujiFrame f, Stock s) {
		
		setBackground(new Color(255, 255, 255));
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
		
		/**NOT FINAL JUST TRYING TO GET TO**/
		Coordinate[] coords = {c1,c2,c3,c4,c5,c6};
		Piece p = new Piece(coords, 0);
		PieceView pv = new PieceView(p);
		bp = new BullPen(new Piece[]{p}, new PieceView[]{pv});
		bp.selectedPiece = p;
		
		ImageIcon img = new ImageIcon(pv.getBufferedImage());
		JLabel label = new JLabel(img);
		JPanel pen = new JPanel();
		
		pen.add(label);

	}

	
}
