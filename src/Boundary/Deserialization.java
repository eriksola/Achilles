package Boundary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Game.Board;
import Game.BullPen;
import Game.Piece;

public class Deserialization {

	Piece[] pieces = new Piece[35];
	Board board = null;
	
	/**
	 * 
	 * @return true if the deserilization went smoothly
	 */
	public boolean Deserialize(){
		try {
			FileInputStream fileIn = new FileInputStream("./src/Levels/Level.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			
			pieces = (Piece[]) in.readObject();
			System.out.println(pieces.length);
			
			in.close();
			fileIn.close();
			return true;
		} catch (IOException i) {
		
			return false;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");

			return false;
		}
	}
	public Piece[] getPieces() {
		return pieces;
	}
	public Board getBoard() {
		return board;
	}
	
	
}
