package Boundary.Both;

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
	Board board;
	int timer = 0;
	int numMoves = 0;
	
	/**
	 * @return true if the deserialization went smoothly
	 */
	@SuppressWarnings("unchecked")
	public boolean Deserialize(String filename, int levelType){
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			//TODO add more entities as needed
			
			switch(levelType){
			
			//Puzzle level
			case 1:
				bullPen = (BullPen) in.readObject();
				board = (Board) in.readObject();
				numMoves = (Integer) in.readObject();
				break;
			
			//Lightning level
			case 2:
				bullPen = (BullPen) in.readObject();
				board = (Board) in.readObject();
				timer = (Integer) in.readObject();
				break;
				
			//Release level
			case 3:
				bullPen = (BullPen) in.readObject();
				board = (Board) in.readObject();
				numMoves = (Integer) in.readObject();
				break;
				
			default:
				System.err.println("Level type" + levelType + "not found!");		
		}
			
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
	
	
	public Board getBoard() {
		return this.board;
	}
	
	public int getTime(){
		return this.timer;
	}
	
	public int getNumMoves(){
		return this.numMoves;
	}
}