package Boundary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Game.Board;
import Game.BullPen;
import Game.Piece;
import Game.Stock;

public class Deserialization {

	BullPen bullPen;
	Stock stock;
	Board board;
	
	/**
	 * @return true if the deserialization went smoothly
	 */
	@SuppressWarnings("unchecked")
	public boolean Deserialize(String filename){
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			
			bullPen = (BullPen) in.readObject();
			stock = (Stock) in.readObject();
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
	
	public BullPen getBullPen(){
		return this.bullPen;
	}
	
	public Stock getStock(){
		return this.stock;
	}
	
	
	public Board getBoard() {
		return this.board;
	}
	
	
}
