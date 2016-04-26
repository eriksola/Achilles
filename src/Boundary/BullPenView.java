package Boundary;

import javax.swing.JPanel;

import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
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
	private PieceView pieceViews[];
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
	
	public void addPiece(PieceView pv){
		this.pvs.add(pv);
		add(pv.label);
	}

	public PieceView[] getPieceViews() {
		return pieceViews;
	}

	public void setPieceViews(PieceView pieceViews[]) {
		this.pieceViews = pieceViews;
	}

	
}
