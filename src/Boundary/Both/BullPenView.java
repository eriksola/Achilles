package Boundary.Both;

import javax.swing.JPanel;

import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Stock;
import Game.Tile;
import Controller.BoardController;
import Controller.BullPenController;
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
import javax.swing.JScrollPane;

public class BullPenView extends JPanel {
	
	JFrame frame;
	BullPen bp;
	KabaSuji view;
	ArrayList<PieceView> pvs;
	JLabel label;

	public BullPenView(JFrame f, BullPen p, KabaSuji view) {
		this.frame = f;
		this.bp = p;
		this.view = view;
		this.pvs = new ArrayList<PieceView>();
		
		draw();
	}
	
	public void draw(){
		removeAll();
		for (int i = 0; i < bp.getPieces().size(); i++) {
			PieceView view = new PieceView(bp.getPieces().get(i), this.view);
			pvs.add(view);
			add(view.getLabel());
		}
	}
	
	public void remove(PieceView pv){
		for (int i = 0; i < pvs.size(); i++) {
			if(pvs.get(i) == pv){
				frame.getContentPane().invalidate();
				pvs.remove(i);
				bp.getPieces().remove(i);
				JLabel c = pv.getLabel();
				int compX = (int) c.getAlignmentX();
				int compY = (int) c.getAlignmentY();
				remove(pv.getLabel());
				frame.getContentPane().revalidate();
				break;
			}
		}
	}
	
	public void addView(PieceView pv){
		this.pvs.add(pv);
		add(pv.getLabel());
	}

	public ArrayList<PieceView> getPieceViews() {
		return pvs;
	}

	public BullPen getBullPen(){
		return this.bp;
	}

	public void addPiece(PieceView pv) {
		this.pvs.add(pv);
		this.bp.addPiece(pv.getP());
		add(pv.getLabel());
	}
	
}
