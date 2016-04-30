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
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

/**
 * Visual manifestation of the BullPen entity.
 * @author Wolfson
 *
 */
public class BullPenView extends JPanel {
	
	JFrame frame;
	BullPen bp;
	KabaSuji view;
	ArrayList<PieceView> pieceViews;
	JLabel label;

	/**
	 * Constructor for bullpenview.
	 */
	public BullPenView(JFrame f, BullPen p, KabaSuji view) {
		this.frame = f;
		this.bp = p;
		this.view = view;
		this.pieceViews = new ArrayList<PieceView>();
		draw();
	}
	
	/**
	 * Draws the all of the PieceViews in the BullPenView.
	 * @return The drawn BullPenView.
	 */
	public BullPenView draw(){
		
		//clear the pieceViews and their labels from the system
		pieceViews.clear();
		removeAll();
		
		//check for updated piece info from the bullpen entity 
		//create new PieceViews
		for (int i = 0; i < bp.getPieces().size(); i++) {
			PieceView view = new PieceView(bp.getPieces().get(i), this.view);
			pieceViews.add(view);
			add(view.getLabel());
		}
		
		//revalidate the BullPenView
		revalidate();
		repaint();
		return this;
	}
	
	public void remove(PieceView pv){
		for (int i = 0; i < pieceViews.size(); i++) {
			if(pieceViews.get(i) == pv){
				//remove the pieceview/piece from the bullpenview/bullpen
				JLabel c = pieceViews.get(i).getLabel();
				System.out.println(c);
				bp.getPieces().remove(i);
				pieceViews.remove(i);
				remove(c);
				revalidate();
				repaint();
				break;
			}
		}
	}
	
	public void addView(PieceView pv){
		this.pieceViews.add(pv);
		add(pv.getLabel());
	}

	public ArrayList<PieceView> getPieceViews() {
		return pieceViews;
	}

	public BullPen getBullPen(){
		return this.bp;
	}

	/**
	 * Add a PieceView to the BullPenView.
	 * @param pv PieceView to be added.
	 */
	public void addPiece(PieceView pv) {
		this.pieceViews.add(pv);
		this.bp.addPiece(pv.getP());
		add(pv.getLabel());
	}
	
}
