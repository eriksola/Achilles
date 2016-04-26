package Boundary;

import javax.swing.JPanel;

import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import Boundary.PieceView;
import Controller.PieceController;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class BullPenView extends JPanel {
	JFrame frame;
	BullPen bp;
	KabaSuji view;
	ArrayList<PieceView> pvs;

	/**
	 * Create the panel.
	 */
	public BullPenView(JFrame f, BullPen p, KabaSuji view) {
		this.frame = f;
		this.bp = p;
		this.view = view;
		this.pvs = new ArrayList<PieceView>();
		
		/*
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
		
		*/
	}
	
	public void remove(PieceView pv){
		for (int i = 0; i < pvs.size(); i++) {
			if(pvs.get(i) == pv){
				pvs.remove(i);
				bp.getPieces().remove(i);
				remove(pv.label);
				System.out.println("found the piece to remove");
				break;
			}
		}
	}
	
	public void addPiece(PieceView pv){
		this.pvs.add(pv);
		bp.getPieces().add(pv.getP());
		add(pv.label);
	}

	public ArrayList<PieceView> getPieceViews() {
		return pvs;
	}

	
}
