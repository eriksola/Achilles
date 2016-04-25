package Boundary;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class EditDeletePopup extends JPopupMenu {
	
    JMenuItem edit;
    JMenuItem delete;
    String path;
    int levelNumber;
    int levelType;
    LevelBuilderBuiltLevelPanel currentPanel;
    Deserialization de;
	
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
                	
            		if(file.delete()){
            			currentPanel.removeLevel(levelNumber, levelType);
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
