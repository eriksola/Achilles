package Boundary;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Game.Coordinate;
import Game.Piece;


public class PieceView {

	private BufferedImage bi;
	private Piece p;
	
	public PieceView(Piece p){
		this.p = p;		
		draw();
	}
	
	public void draw(){
		BufferedImage img = new BufferedImage(65, 65, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 65, 65);
		g.setColor(Color.black);
		for(Coordinate c: getP().getCoordinates()){
			int newX = 20 + (10 * c.x);
			int newY = 20 - (10 * c.y);
			g.drawRect(newX, newY, 10, 10);
		}

		bi = img;
	}
	
	public Piece getPiece(){
		return this.getP();
	}

	public Piece getP() {
		return p;
	}

	public void setP(Piece p) {
		this.p = p;
	}

	public BufferedImage getBufferedImage() {
		return this.bi;
	}

	public void setBufferedImage(BufferedImage bi) {
		this.bi = bi;
	}

}
