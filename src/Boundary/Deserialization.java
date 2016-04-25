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
	 * @return true if the deserilization went smoothly
	 */
	public boolean Deserialize(String filename){
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			
			pieces = (Piece[]) in.readObject();
			board = (Board) in.readObject();
			
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
		return this.pieces;
	}
	public Board getBoard() {
		return this.board;
	}
	
	
}
