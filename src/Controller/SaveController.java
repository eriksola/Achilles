package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JPanel;

import Boundary.LevelBuilderFrame;
import Boundary.LevelBuilderMainMenuPanel;
import Game.Board;
import Game.BullPen;
import Game.Piece;

public class SaveController implements ActionListener {
	
	Piece[] pieces;
	Board board;
	int levelType;
	int numLevel;
	/**
	 * Constructor will take every entity that is needed in order to build a level.
	 * LevelTypes:
	 * 1 = Puzzle
	 * 2 = Lightning
	 * 3 = Release
	 */
	public SaveController(Piece[] pieces, Board board, int levelType, int numLevel){
		this.pieces = pieces;
		this.board = board;
		this.levelType = levelType;
		this.numLevel = numLevel;
		numLevel++;
	}

	/**
	 * Action to save a file given a level type.
	 * This will place the level in the appropriate package with the corresponding filename
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			
			String filepath = null;
			switch (levelType) {
	            case 1:  
	            		filepath = "./src/BuiltLevels/PuzzleLevels/Level" + numLevel + ".txt";
	                     break;
	            case 2:  filepath = "./src/BuiltLevels/LightningLevels/Level" + numLevel + ".txt";
	                     break;
	            case 3:  filepath = "./src/BuiltLevels/ReleaseLevels/Level" + numLevel + ".txt";
	                     break;
	            default: filepath = null;
	            break;
			}
			
			if(numLevel < 5){
				FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				
				//NEED TO ADD MORE ENTITIES
				out.writeObject(pieces);
				
				out.close();
				fileOut.close();
				System.out.println("Serialized data is saved in " + filepath + " file");
			}
			else{
				System.out.println("Cant add " + filepath + ", too many levels added.");
			}
			} catch (IOException i) {
			i.printStackTrace();
			}
	}
}
