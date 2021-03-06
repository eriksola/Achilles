package Boundary.Builder;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Boundary.Both.Deserialization;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Pop up menu that allows a user to either edit or delete a level.
 * @author Sola
 *
 */
public class EditDeletePopup extends JPopupMenu {
	
    JMenuItem edit; /** item for editing a level **/
    JMenuItem delete; /** item for deleting a level **/
    String path; /** filepath for selected level **/
    int levelNumber; /** level number **/
    int levelType; /** leveltype: Puzzle - 1, Lightning - 2, Release - 3 **/
    LevelBuilderBuiltLevelPanel currentPanel; /**the current panel being displayed **/
    Deserialization de; /** the deserialization of the level at the given filepath **/
	
    /**
     * Constructor.
     * @param filepath Filepath for the level.
     * @param p Panel where the you will be able to right click.
     * @param levelNum The level number that is going to be edited.
     * @param level The level type.
     * @param d The Deserialization object that holds serialized objects.
     */
    public EditDeletePopup(String filepath, LevelBuilderBuiltLevelPanel p, int levelNum, int level, Deserialization d){
    	
    	this.path = filepath;
    	this.currentPanel = p;
    	this.levelNumber = levelNum;
    	this.levelType = level;
    	this.de = d;
    	
        edit = new JMenuItem("Edit");
        //Add what happens when you press edit
        edit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		LevelBuilderFrame mainFrame = currentPanel.getMainFrame();

        		mainFrame.getContentPane().removeAll();
        		mainFrame.getContentPane().invalidate();
        		
        		JPanel editableLevel = null;
        		
        		switch(levelType){	
        			case 1:
        				editableLevel = new EditPuzzleLevelPanel(currentPanel.getMainFrame(), de, levelNumber);
        				break;
        			case 2:
        				editableLevel = new EditLightningLevelPanel(currentPanel.getMainFrame(), de, levelNumber);
        				break;
        			case 3:
        				editableLevel = new EditReleaseLevelPanel(currentPanel.getMainFrame(), de, levelNumber);
        				break;
        			default:
        				System.err.println("No level type found to edit.");
        				
        				
        		}
        		
        		if(editableLevel == null){
        			System.err.println("No level type found to edit.");
        		}
        		
        		mainFrame.getContentPane().add(editableLevel, BorderLayout.CENTER);
        		mainFrame.getContentPane().revalidate();
        		
        	}
        });
        
        //Add what happens when you pressed delete
        delete = new JMenuItem("Delete");
        delete.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent event) {
        		try{          		
            		File file = new File(path);
                	String levelName = file.getName(); 
                	//Removes the file extension
					if (levelName.indexOf(".") > 0){
						levelName = levelName.substring(0, levelName.lastIndexOf("."));
					}
            		if(file.delete()){
            			currentPanel.removeLevel(levelName, levelType);
            			System.out.println(file.getName() + " is deleted!");
            			
            		}else{
            			System.err.println("Could not delete level" + file.getName() +"!");
            		}
            	   
            	}catch(Exception e){
            		
            		e.printStackTrace();
            		
            	}
        	}
        });
        
        add(edit);
        add(delete);
    }
}
