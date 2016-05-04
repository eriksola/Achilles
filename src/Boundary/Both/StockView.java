package Boundary.Both;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;

import Game.Stock;

/**
 * Boundary object to represent the stock.
 * @author Achilles
 *
 */
public class StockView extends JPanel {

	private PieceView pieceViews[]; /** the PieceViews of all the pieces in the StockView **/
	JFrame frame; /** the frame of the application **/
	Stock s; /** the stock entity containing all the piece entities **/
	KabaSuji view; /** the view currently displayed in the application **/
	
	/**
	 * Create the panel.
	 */
	public StockView(JFrame f, Stock s, KabaSuji view) {
		this.frame = f;
		this.s = s;
		this.view = view;
		draw();
	}
	
	/**
<<<<<<< HEAD
	 * draws the StockView with the given entities
=======
	 * draw the StockView to the JPanel and display.
>>>>>>> refs/remotes/origin/master
	 */
	public void draw(){
		removeAll();
		setPieceViews(new PieceView[s.getPieces().size()]);
		for(int i = 0; i < getPieceViews().length; i++){
			getPieceViews()[i] = new PieceView(s.getPieces().get(i),view);
			add(getPieceViews()[i].getLabel());
			repaint();
		}
		revalidate();
	}
	
	/**
	 * getter function for the pieceViews
	 * @return array of pieceViews
	 */

	public PieceView[] getPieceViews() {
		return pieceViews;
	}

	/**
	 * Sets the pieceViews 
	 * @param pieceViews the new PieceViews
	 */
	public void setPieceViews(PieceView pieceViews[]) {
		this.pieceViews = pieceViews;
	}

	/**
	 * getter function for the stock entity
	 * @return stock entity
	 */
	public Stock getStock(){
		return this.s;
	}

}

