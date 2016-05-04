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
	
	JFrame frame; //the frame of the player/builder app
	BullPen bp; //the bullPen entity
	KabaSuji view; //the screen which holds the BullPenView
	ArrayList<PieceView> pieceViews; //the array of PieceViews contained in the bullPen
	JLabel label; //holds the imageIcons which make up pieceViews

	/**
	 * Constructor for bullPenView
	 * @param f frame of app
	 * @param p bullpen entity
	 * @param view panel within frame
	 */
	public BullPenView(JFrame f, BullPen bp, KabaSuji view) {
		this.frame = f;
		this.bp = bp;
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
	
	/** 
	 * Removes the pieceView from the bullPenView
	 * @param pv the pieceView to be removed
	 */
	public void remove(PieceView pv){
		for (int i = 0; i < pieceViews.size(); i++) {
			if(pieceViews.get(i) == pv){
				//remove the pieceview/piece from the bullpenview/bullpen
				JLabel c = pieceViews.get(i).getLabel();
				System.out.println(c);
				bp.getPieces().remove(i);
				remove(c);
				draw();
				revalidate();
				repaint();
				break;
			}
		}
	}
	
	/**
	 * Adds the pieceView to the bullPenView
	 * @param pv the pieceView to be added
	 */
	public void addView(PieceView pv){
		this.pieceViews.add(pv);
		add(pv.getLabel());
	}
	
	/**
	 * getter function for the pieceViews on the BullPenView
	 * @return the pieceViews
	 */
	public ArrayList<PieceView> getPieceViews() {
		return pieceViews;
	}
	
	/**
	 * getter function for the bullPen entity
	 * @return the bullpen
	 */
	public BullPen getBullPen(){
		return this.bp;
	}

	/**
	 * Add a PieceView to the BullPenView (AND THE PIECE TO THE BULLPEN)
	 * @param pv PieceView to be added.
	 */
	public void addPiece(PieceView pv) {
		this.pieceViews.add(pv);
		this.bp.addPiece(pv.getP());
		add(pv.getLabel());
	}
	
}
