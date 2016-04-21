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
	
	/**
	 * Constructor will take every entity that is needed in order to build a level.
	 * @param levelPanel
	 */
	public SaveController(Piece[] pieces, Board board){
		this.pieces = pieces;
		this.board = board;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			
			FileOutputStream fileOut = new FileOutputStream("./src/Levels/Level.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			System.out.println(pieces.length);
			out.writeObject(pieces);
			
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in ./src/Levels/Level.txt file");
			} catch (IOException i) {
			i.printStackTrace();
			}
		
		
		//After this is invoked exit back
	}
}
