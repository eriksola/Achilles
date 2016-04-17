package Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Controller.RotateLeftController;
import Controller.RotateRightController;
import View.PieceView;

public class Stock {
	
	/** Set of pieces **/
	List<Piece> setOfPieces;
	
	public Stock(){
		
		
		// Define all pieces used in this game
		Piece p1, p2, p3, p4, p5, p6, p7, p8, p9,
			p10, p11, p12, p13, p14, p15, p16, p17, p18,
			p19, p20, p21, p22, p23, p24, p25, p26, p27, 
			p28, p29, p30, p31, p32, p33, p34, p35;
		
		// Define all of the coordinates used for all the pieces
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(0,1);
		Coordinate c3 = new Coordinate(0,2);
		Coordinate c4 = new Coordinate(0,3);
		Coordinate c5 = new Coordinate(0,4);
		Coordinate c6 = new Coordinate(0,5);
		
		Coordinate c7 = new Coordinate(1,0);
		Coordinate c8 = new Coordinate(1,1);
		Coordinate c9 = new Coordinate(1,2);
		Coordinate c10 = new Coordinate(1,3);
		Coordinate c11 = new Coordinate(1,4);
		Coordinate c12 = new Coordinate(1,5);
		
		Coordinate c13 = new Coordinate(2,0);
		Coordinate c14 = new Coordinate(2,1);
		Coordinate c15 = new Coordinate(2,2);
		Coordinate c16 = new Coordinate(2,3);
		Coordinate c17 = new Coordinate(2,4);
		Coordinate c18 = new Coordinate(2,5);

		Coordinate c19 = new Coordinate(3,0);
		Coordinate c20 = new Coordinate(3,1);
		Coordinate c21 = new Coordinate(3,2);
		Coordinate c22 = new Coordinate(3,3);
		Coordinate c23 = new Coordinate(3,4);
		Coordinate c24 = new Coordinate(3,5);
		
		Coordinate c25 = new Coordinate(4,0);
		Coordinate c26 = new Coordinate(4,1);
		Coordinate c27 = new Coordinate(4,2);
		Coordinate c28 = new Coordinate(4,3);
		Coordinate c29 = new Coordinate(4,4);
		Coordinate c30 = new Coordinate(4,5);
		
		Coordinate c31 = new Coordinate(5,0);
		Coordinate c32 = new Coordinate(5,1);
		Coordinate c33 = new Coordinate(5,2);
		Coordinate c34 = new Coordinate(5,3);
		Coordinate c35 = new Coordinate(5,4);
		Coordinate c36 = new Coordinate(5,5);
		
		// Now define all of the 35 pieces
		p1 = new Piece(new Coordinate[] {c1,c2,c3,c4,c5,c6}, 0);
		
		// Now add the piece to the hashmap
		setOfPieces = new ArrayList<Piece>();
		setOfPieces.add(p1);
		
	}
	
	public List<Piece> getPieces(){
		return this.setOfPieces;
	}
	public Piece getPiece(int id){
		return this.setOfPieces.get(id);
	}
	
	public Piece[] getPiecesForPen(){
		Piece[] pieces;
		pieces = new Piece[6];
		for(int i = 0; i < 6; i ++){
			pieces[i] = setOfPieces.get(i);
		}
		return pieces;
	}
}
