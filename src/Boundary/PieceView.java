package Boundary;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controller.PieceController;
import Game.Coordinate;
import Game.Piece;

/**
 * Visual manifestation of a Piece entity.
 * @author bwolfson
 *
 */
public class PieceView {

	JLabel label; /** the label representing the Piece. **/
	Piece p; /** the Piece entity itself. **/
	KabaSuji view; /** top-level boundary object. **/
	
	/**
	 * Constructor for PieceView.
	 * @param p
	 * @param view
	 */
	public PieceView(Piece p, KabaSuji view){
		this.p = p;
		this.view = view;
		this.label = new JLabel();
		label.addMouseListener(new PieceController(this.view, this));
		label.setLayout(new FlowLayout()); 
		drawUnselected();
	}
	
	/**
	 * draw a hexominoe representing the Piece of 6 Coordinates.
	 */
	public void drawUnselected(){
		BufferedImage img = new BufferedImage(65, 65, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 65, 65);
		g.setColor(Color.black);
		for(Coordinate c: getP().getCoordinates()){
			int newX = 30 + (10 * c.x);
			int newY = 30 - (10 * c.y);
			g.drawRect(newX, newY, 10, 10);
		}
		ImageIcon icon = new ImageIcon(img);
		label.setIcon(icon);
	}
	
	/**
	 * highlight the PieceView (yellow) to illustrate as selected.
	 */
	public void drawSelected(){
		BufferedImage img = new BufferedImage(65, 65, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 65, 65);
		g.setColor(Color.BLACK);
		for(Coordinate c: getP().getCoordinates()){
			int newX = 30 + (10 * c.x);
			int newY = 30 - (10 * c.y);
			g.drawRect(newX, newY, 10, 10);
			g.setColor(Color.YELLOW);
			g.fillRect(newX + 1, newY + 1, 8, 8);
			g.setColor(Color.BLACK);
		}

		ImageIcon icon = new ImageIcon(img);
		label.setIcon(icon);
	}
	

	public Piece getP() {
		return p;
	}

	public void setP(Piece p) {
		this.p = p;
	}

}
