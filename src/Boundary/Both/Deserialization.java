package Boundary.Both;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Game.Board;
import Game.BullPen;
import Game.IScore;
import Game.Piece;
import Game.Stock;

public class Deserialization {

	BullPen bullPen;
	Board board;
	int timer = 0;
	int numMoves = 0;
	IScore score;
	
	/**
	 * Deserializes a previously serialized level.
	 * @return true if the deserialization went smoothly
	 */

	public boolean Deserialize(String filename, int levelType){
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			//TODO add more entities as needed
			bullPen = (BullPen) in.readObject();
			board = (Board) in.readObject();
			score = (IScore) in.readObject();
			
			switch(levelType){
			
			//Puzzle level
			case 1:
				numMoves = (Integer) in.readObject();
				break;
			
			//Lightning level
			case 2:
				timer = (Integer) in.readObject();
				break;
				
			//Release level
			case 3:
				break;
				
			default:
				System.err.println("Level type" + levelType + "not found!");		
		}
			
			in.close();
			fileIn.close();
			return true;
			
		} catch (IOException i) {
			
			System.out.println(i.getMessage());
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
	
	public IScore getScore() {
		return this.score;
	}

	public int getTime(){
		return this.timer;
	}

	public int getNumMoves(){
		return this.numMoves;
	}
}
