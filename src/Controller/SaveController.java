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

import Boundary.Both.KabaSuji;
import Boundary.Builder.LevelBuilderFrame;
import Boundary.Builder.LevelBuilderMainMenuPanel;
import Game.Board;
import Game.BullPen;
import Game.LightningBoard;
import Game.LightningScore;
import Game.Piece;
import Game.PuzzleScore;
import Game.ReleaseScore;
import Game.Stock;

/**
 * 
 * SaveController is used in the LevelBuilder in order to serialize created levels into the corresponding directories where built leveles reside.
 * @author Sola
 *
 */
public class SaveController implements ActionListener {
	
	ArrayList<Object> entities;
	int levelType;

	/**
	 * Constructor will take every entity that is needed in order to build a level.
	 * LevelTypes:
	 * <ul> <li> Puzzle = 1 </li> <li> Lightning = 2 </li> <li> Release = 3</li>
	 * @param ent List of objects to be serialized.
	 * @param levelType The leveltype of the level being built.
	 */
	public SaveController(ArrayList<Object> ent, int levelType){
		this.entities = ent;
		this.levelType = levelType;
	}
	
	/**	
	 * Get the input, name of the file, from the builder.
	 * @return Name of the level being built.
	 */
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
	
	/**
	 * If the level name requested is already created this will be invoked.
	 * This will get the name of a level that is not the same as any levels in the directory.
	 * @param pastName The previous name of a level that will be overwritten.
	 * @return The name of the new level.
	 */
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
	public void actionPerformed(ActionEvent e){
		
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
	            		boolean hasNumMoves = false;
	            		boolean hasScore = false;
	            		//A puzzle level will have three objects, board, bullpen, and number of moves
	            		
	            		if(entities.size() != 4){
	            			canWriteFile = false;
	            			System.err.println("This level does not have everything it needs to be playable!");
	            			System.err.println("Remember, for a puzzle level you need, board, bullpen, and number of moves.");
	            		}
	            		else{
		            		for(Object j: entities){
		            			if(j instanceof Board){
		            				hasBoard = true;
		            			}
		            			else if(j instanceof BullPen){
		            				hasPen = true;
		            			}
		            			else if( j instanceof Integer){
		            				hasNumMoves = true;
		            			}
		            			else if (j instanceof PuzzleScore){
		            				hasScore = true;
		            			}
		            		}
	            		}
	            		
	            		if(!hasBoard || !hasPen || !hasNumMoves || !hasScore){
	            			canWriteFile = false;
	            		}
	                    break;
	            case 2:  
	            	boolean hasboard = false;
            		boolean haspen = false;
            		boolean hasTimer = false;
            		boolean hasscore = false;
            		//A lightning level will have three objects: board, bullpen, and a time
            		//PRINT FOR TESTING
            		for (int i = 0; i < entities.size(); i++){
            			System.out.println(entities.get(i));
            			
            		}
            		if(entities.size() != 4){
            			canWriteFile = false;
            			System.err.println("This level does not have everything it needs to be playable!");
            			System.err.println("Remember for a lightning level you need board, bullpen, and a time that is not 0.");
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
	            				hasTimer = true;
	            			}
	            			else if(j instanceof LightningScore){
	            				hasscore = true;
	            			}
	            		}
            		}
            		
            		if(!hasboard || !haspen || !hasTimer || !hasscore){
            			canWriteFile = false;
            		}
	                     break;
	            case 3:  
	            	boolean board = false;
            		boolean pen = false;
            		boolean score = false;
            		//A release level will have three objects, board, bullpen, number of moves, colornumber class.....add more
            		if(entities.size() != 3){//Make three for right now
            			canWriteFile = false;
            			System.err.println("This level does not have everything it needs to be playable!");
            			System.err.println("Remember, for a release level you need, board, bullpen, color numbers...");
            		}
            		else{
	            		for(Object j: entities){
	            			if(j instanceof Board){
	            				board = true;
	            			}
	            			else if(j instanceof BullPen){
	            				pen = true;
	            			}
	            			else if(j instanceof ReleaseScore){
	            				score = true;
	            			}
	            		}
            		}
            		
            		if(!board || !pen || !score){
            			canWriteFile = false;
            		}
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
