package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderMainMenuPanel;
import Game.Board;
import Game.BullPen;
import Game.Piece;
import Game.Stock;

public class SaveController implements ActionListener {
	
	ArrayList<Object> entities;
	int levelType;

	/**
	 * Constructor will take every entity that is needed in order to build a level.
	 * LevelTypes:
	 * 1 = Puzzle
	 * 2 = Lightning
	 * 3 = Release
	 */
	public SaveController(ArrayList<Object> ent, int levelType){
		this.entities = ent;
		this.levelType = levelType;
	}
	
	public String getInput(){
		String levelName = null;
		boolean validName = false;
		while(!validName){
			levelName = JOptionPane.showInputDialog("Level name: ");
			if(levelName == null){
				//This is if the user presses cancel
				break;
			}
			else if(!(levelName.equals(""))){
				validName = true;
			}		
		}
		return levelName;
	}
	public String overWriteLevel(String pastName){
		String levelName = null;
		boolean validName = false;
		while(!validName){
			levelName = JOptionPane.showInputDialog("New Level name: ");
			if(levelName == null || (levelName.equals(""))){
				//This is if the user presses cancel
				break;
			}
			else if(!(levelName.equals(pastName))){
				validName = true;
			}		
		}
		return levelName;
	}
	/**
	 * Action to save a file given a level type.
	 * This will place the level in the appropriate package with the corresponding filename
	 */
	public void actionPerformed(ActionEvent e) {
		
		String levelName = getInput();
		boolean canWriteFile = false;
		if(levelName != null){
			try {
				
				String filepath = null;
				switch (levelType) {
		            case 1:  
		            		filepath = "./src/BuiltLevels/PuzzleLevels/" + levelName + ".txt";
		                     break;
		            case 2:  filepath = "./src/BuiltLevels/LightningLevels/" + levelName + ".txt";
		                     break;
		            case 3:  filepath = "./src/BuiltLevels/ReleaseLevels/" + levelName + ".txt";
		                     break;
		            default: filepath = null;
		            break;
				}
				
				File level = new File(filepath);
				
				if(level.exists() && !level.isDirectory()) { 
				    //There is already a file with this name, check if the user
					//would like to overwrite the file
					int answer;	
					answer = JOptionPane.showConfirmDialog(null, "Overwrite level?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION){
						canWriteFile = true;
					}
					else if(answer == JOptionPane.NO_OPTION){
						String changedName = overWriteLevel(levelName);
						levelName = changedName;
						if(levelName != null && !levelName.equals("")){
							
							//The file name must be changed to what the user wants it to be called instead
							switch (levelType) {
				            case 1:  
				            		filepath = "./src/BuiltLevels/PuzzleLevels/" + levelName + ".txt";
				                     break;
				            case 2:  filepath = "./src/BuiltLevels/LightningLevels/" + levelName + ".txt";
				                     break;
				            case 3:  filepath = "./src/BuiltLevels/ReleaseLevels/" + levelName + ".txt";
				                     break;
				            default: filepath = null;
				            break;
							}
							canWriteFile = true;
						}												
					}
						
				}
				else{
					//No overwriting of a file proceed normally
					canWriteFile = true;
				}
				
				//Now check if we have a valid level, we can do this by checking the arraylists of objects
				switch (levelType) {
	            case 1: 
	            		boolean hasBoard = false;
	            		boolean hasPen = false;
	            		//A puzzle level will have four objects, board, bullpen, and number of moves
	            		if(entities.size() != 2){//Make two for right now
	            			canWriteFile = false;
	            			System.err.println("This level does not have everything it needs to be playable!");
	            			System.err.println("Remember, for a puzzle level you need, board, pieces, and number of moves.");
	            		}
	            		else{
		            		for(Object j: entities){
		            			if(j instanceof Board){
		            				hasBoard = true;
		            			}
		            			else if(j instanceof BullPen){
		            				hasPen = true;
		            			}
		            		}
	            		}
	            		
	            		if(!hasBoard || !hasPen){
	            			canWriteFile = false;
	            		}
	                    break;
	            case 2:  
	            	boolean hasboard = false;
            		boolean haspen = false;
            		boolean hastimer = false;
            		//A lightning level will have three objects, board, bullpen, and a time
            		if(entities.size() != 3){
            			canWriteFile = false;
            			System.err.println("This level does not have everything it needs to be playable!");
            			System.err.println("Remember for a lightning level you need board, pieces, and a time that is not 0.");
            		}
            		else{
	            		for(Object j: entities){
	            			if(j instanceof Board){
	            				hasboard = true;
	            			}
	            			else if(j instanceof BullPen){
	            				haspen = true;
	            			}
	            			else if(j instanceof Integer){
	            				hastimer = true;
	            			}
	            		}
            		}
            		
            		if(!hasboard || !haspen || !hastimer){
            			canWriteFile = false;
            		}
	                     break;
	            case 3:  
	            		//TODO
	            		//Need to add validity for release
	                     break;
	            default:
	            	System.err.println("Level not found!");
	            	break;
				}
				
				if(canWriteFile){
					FileOutputStream fileOut = new FileOutputStream(filepath);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					
					
					
					//Add all entities given to the controller
					for(Object j: entities){
						out.writeObject(j);
					}
					
							
					out.close();
					fileOut.close();
					System.out.println("Serialized data is saved in " + filepath + " file");
				}
				
				
			}
			catch (IOException i) {
				i.printStackTrace();
			}
		}
	}
}
