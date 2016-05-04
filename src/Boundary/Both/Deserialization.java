package Boundary.Both;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Game.Board;
import Game.BullPen;
import Game.IScore;
import Game.LightningBoard;
import Game.Piece;
import Game.Stock;

public class Deserialization {

	BullPen bullPen; /** bullpen for the level **/
	Board board; /** board for the level **/
	int timer = 0; /** timer for a lightning level **/
	int numMoves = 0; /** number of moves for a puzzle level **/
	IScore score; /** score for the level **/
	
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
	
	/**
	 * getter function for the bullpen
	 * @return the bullpen
	 */
	public BullPen getBullPen(){
		return this.bullPen;
	}
	
	/**
	 * getter function for the board
	 * @return the board
	 */
	public Board getBoard() {
		return this.board;
	}
	
	/**
	 * getter function for the score
	 * @return the score
	 */
	public IScore getScore() {
		return this.score;
	}

	/**
	 * getter function for the time 
	 * @return the time
	 */
	public int getTime(){
		return this.timer;
	}
	
	/**
	 * getter function for the number of moves
	 * @return the number of moves
	 */
	public int getNumMoves(){
		return this.numMoves;
	}
}
