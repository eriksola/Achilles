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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class BullPenView extends JPanel {
	Piece pieces[];
	PieceView pieceViews[];
	JFrame frame;
	BullPen bp;

	/**
	 * Create the panel.
	 */
	public BullPenView(JFrame f, BullPen p) {
		this.frame = f;
		this.bp = p;
		
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

	}
	
	/**
	 * Add random pieces to the bullpen.
	 */
	public void addPiecesToPen() {
		pieceViews = bp.getPvs();
		pieces = bp.getPieces();
		
		for(int i = 0; i < pieces.length; i++){
			PieceView pv = new PieceView(pieces[i]);
			pieceViews[i] = pv;	
		}
			
		for(int i = 0; i < pieces.length; i++){
			bp.selectedPiece = pieces[i];
			ImageIcon img = new ImageIcon(pieceViews[i].getBufferedImage());
			JLabel label = new JLabel(img);
			setLayout(new FlowLayout()); 
			add(label);
			
		}
		
	}

	
}
