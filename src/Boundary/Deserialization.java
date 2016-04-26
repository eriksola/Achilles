package Boundary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Game.Board;
import Game.BullPen;
import Game.Piece;

public class Deserialization {

	//The deserialization class will have all of the possible objects a level can have
	Piece[] pieces = new Piece[35];
	Board board = null;
	int timer = 0;
	
	
	/**
	 * @return true if the deserilization went smoothly
	 */
	public boolean Deserialize(String filename, int levelType){
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			
			switch(levelType){
			
				//Puzzle level
				case 1:
					pieces = (Piece[]) in.readObject();
					board = (Board) in.readObject();
					break;
				
				//Lightning level
				case 2:
					pieces = (Piece[]) in.readObject();
					board = (Board) in.readObject();
					timer = (Integer) in.readObject();
					break;
					
				//Release level
				case 3:
					pieces = (Piece[]) in.readObject();
					board = (Board) in.readObject();
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
	public Piece[] getPieces() {
		return this.pieces;
	}
	public Board getBoard() {
		return this.board;
	}
	public int getTimer(){
		return this.timer;
	}
	
}
