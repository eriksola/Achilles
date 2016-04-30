package Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Boundary.Both.PieceView;
import sun.security.action.GetBooleanAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


/**
 * 
 * Stock contains all of the pieces used in the <b> Kabasuji </b> game.
 * @author Sola
 *
 */
public class Stock implements Serializable{
	
	/** Set of pieces */
	List<Piece> setOfPieces;
	
	/**
	 * Constructs a Stock that has all of the coordinates and pieces used in <b> Kabasuji. </b> 
	 */
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
		
		Coordinate c_1 = new Coordinate(0,-1);
		Coordinate c_2 = new Coordinate(0,-2);
		Coordinate c_3 = new Coordinate(0,-3);
		Coordinate c_4 = new Coordinate(0,-4);
		Coordinate c_5 = new Coordinate(0,-5);
		
		Coordinate c7 = new Coordinate(1,0);
		Coordinate c8 = new Coordinate(1,1);
		Coordinate c9 = new Coordinate(1,2);
		Coordinate c10 = new Coordinate(1,3);
		Coordinate c11 = new Coordinate(1,4);
		Coordinate c12 = new Coordinate(1,5);
		
		Coordinate c_7 = new Coordinate(1,-1);
		Coordinate c_8 = new Coordinate(1,-2);
		Coordinate c_9 = new Coordinate(1,-3);
		Coordinate c_10 = new Coordinate(1,-4);
		Coordinate c_11 = new Coordinate(1,-5);
		
		Coordinate neg_c_7 = new Coordinate(-1,0);
		Coordinate neg_c_8 = new Coordinate(-1,-1);
		Coordinate neg_c_9 = new Coordinate(-1,-2);
		Coordinate neg_c_10 = new Coordinate(-1,-3);
		Coordinate neg_c_11 = new Coordinate(-1,-4);
		Coordinate neg_c_12 = new Coordinate(-1,-5);
		
		Coordinate c13 = new Coordinate(2,0);
		Coordinate c14 = new Coordinate(2,1);
		Coordinate c15 = new Coordinate(2,2);
		Coordinate c16 = new Coordinate(2,3);
		Coordinate c17 = new Coordinate(2,4);
		Coordinate c18 = new Coordinate(2,5);

		Coordinate c_13 = new Coordinate(2,-1);
		Coordinate c_14 = new Coordinate(2,-2);
		Coordinate c_15 = new Coordinate(2,-3);
		Coordinate c_16 = new Coordinate(2,-4);
		Coordinate c_17 = new Coordinate(2,-5);

		Coordinate neg_c_13 = new Coordinate(-2,-1);
		Coordinate neg_c_14 = new Coordinate(-2,-2);
		Coordinate neg_c_15 = new Coordinate(-2,-3);
		Coordinate neg_c_16 = new Coordinate(-2,-4);
		Coordinate neg_c_17 = new Coordinate(-2,-5);
		
		
		// Now define all of the 35 pieces
		p1 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, c3, c2}, 0);
		p2 = new Piece(new Coordinate[] {c1, c2, c8, c_1, c_2, c_3} , 0);
		p3 = new Piece(new Coordinate[] {c1, c2, c7, c_1, c_2, c_3} , 0);
		p4 = new Piece(new Coordinate[] {c1, c7, c8, c_1, c_2, c_3} , 0);
		p5 = new Piece(new Coordinate[] {c1, c7, c_1, c_7, c_2, c_3} , 0);
		p6 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, c7, c_8} , 0);
		p7 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, c_9, c7} , 0);
		p8 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, c_7, c_8} , 0);
		p9 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, c7, c13} , 0);
		p10 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, c_7, c_13} , 0);
		p11 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, neg_c_7, c7} , 0);
		p12 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, neg_c_8, c7} , 0);
		p13 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, neg_c_9, c7} , 0);
		p14 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, neg_c_10, c7} , 0);
		p15 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, neg_c_9, c_7} , 0);
		p16 = new Piece(new Coordinate[] {c1, c_1, c_2, c_3, neg_c_8, c_7} , 0);
		p17 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c13, c8} , 0);
		p18 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c_8, c8} , 0);
		p19 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c8, c9} , 0);
		p20 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c8, c_7} , 0);
		p21 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c_7, c_8} , 0);
		p22 = new Piece(new Coordinate[] {c1, c_1, c_2, neg_c_7, c7, c8 } , 0);
		p23 = new Piece(new Coordinate[] {c1, c_1, c_2, neg_c_7, c7, c_7} , 0);
		p24 = new Piece(new Coordinate[] {c1, c_1, c_2, neg_c_8, c7, c8} , 0);
		p25 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c13, c14} , 0);
		p26 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c8, c14} , 0);
		p27 = new Piece(new Coordinate[] {c1, c_1, c_2, c7, c13, c_13} , 0);
		p28 = new Piece(new Coordinate[] {c1, c_1, c_2, c_7, c_13, c13} , 0);
		p29 = new Piece(new Coordinate[] {c1, c_1, c_8, c_7, c_13, c13} , 0);
		p30 = new Piece(new Coordinate[] {c1, c_1, c_2, neg_c_9, neg_c_10, c7} , 0);
		p31 = new Piece(new Coordinate[] {c1, c_1, c_2, c_7, c_8, c_14} , 0);
		p32 = new Piece(new Coordinate[] {c1, c_1, c_2, neg_c_8, neg_c_9, c_7} , 0);
		p33 = new Piece(new Coordinate[] {c1, c_1, neg_c_8, neg_c_13, neg_c_14, neg_c_9} , 0);
		p34 = new Piece(new Coordinate[] {c1, c_1, neg_c_8, neg_c_9, neg_c_14, neg_c_15 } , 0);
		p35 = new Piece(new Coordinate[] {c1, c2, c_1, c_2, c_3, c_7} , 0);
		
		// Now add the pieces to the list
		setOfPieces = new ArrayList<Piece>();
		setOfPieces.add(p1);
		setOfPieces.add(p2);
		setOfPieces.add(p3);
		setOfPieces.add(p4);
		setOfPieces.add(p5);
		setOfPieces.add(p6);
		setOfPieces.add(p7);
		setOfPieces.add(p8);
		setOfPieces.add(p9);
		setOfPieces.add(p10);
		setOfPieces.add(p11);
		setOfPieces.add(p12);
		setOfPieces.add(p13);
		setOfPieces.add(p14);
		setOfPieces.add(p15);
		setOfPieces.add(p16);
		setOfPieces.add(p17);
		setOfPieces.add(p18);
		setOfPieces.add(p19);
		setOfPieces.add(p20);
		setOfPieces.add(p21);
		setOfPieces.add(p22);
		setOfPieces.add(p23);
		setOfPieces.add(p24);
		setOfPieces.add(p25);
		setOfPieces.add(p26);
		setOfPieces.add(p27);
		setOfPieces.add(p28);
		setOfPieces.add(p29);
		setOfPieces.add(p30);
		setOfPieces.add(p31);
		setOfPieces.add(p32);
		setOfPieces.add(p33);
		setOfPieces.add(p34);
		setOfPieces.add(p35);		
	}
	

	public List<Piece> getPieces(){
		return this.setOfPieces;
	}
	
	public Piece getPiece(int id){
		return this.setOfPieces.get(id);
	}
	
	/**
	 * Generates a random number and then will grab the Piece associated with that random index.
	 * @return A random piece from the stock.
	 */
	public Piece getRandomPiece(){
		Random rand = new Random();
		int  randomIndex = rand.nextInt(35);
		return setOfPieces.get(randomIndex); 
	}
	
	/**
	 * Generates ten random numbers and adds all of those associated pieces to a list of Pieces.
	 * @return A list of pieces grabbed randomly from the stock.
	 */
	public ArrayList<Piece> getRandomPiecesForPen(){
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		
		for(int i = 0; i < 10; i ++){
			Random rand = new Random();
			int  randomIndex = rand.nextInt(35);
			pieces.add(setOfPieces.get(randomIndex));
		}
		return pieces;
	}
	
}
