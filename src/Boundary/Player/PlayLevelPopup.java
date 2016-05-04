package Boundary.Player;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Boundary.Both.Deserialization;
import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.EditPuzzleLevelPanel;
import Boundary.Builder.EditReleaseLevelPanel;
import Boundary.Builder.LevelBuilderBuiltLevelPanel;
import Boundary.Builder.LevelBuilderFrame;
import Game.Board;
import Game.BullPen;
import Game.IScore;
import Game.LevelModel;
import Game.LightningBoard;
import Game.LightningLevelModel;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;
import Game.ReleaseScore;
import Game.Stock;

public class PlayLevelPopup extends JPopupMenu{
	
	JMenuItem play;
	int levelType;
	String name;
	BuiltLevelPanel currentPanel;
    Deserialization de;
    
    public PlayLevelPopup(String filename, BuiltLevelPanel p, int level, Deserialization d){
    	
    	this.name = filename;
    	this.currentPanel = p;
    	this.levelType = level;
    	this.de = d;
    	
    	play = new JMenuItem("Play");
        //Add what happens when you press edit
        play.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		KabasujiFrame mainFrame = currentPanel.getMainFrame();

        		mainFrame.getContentPane().removeAll();
        		mainFrame.getContentPane().invalidate();
        		
        		JPanel playableLevel = null;
        		
        		switch(levelType){	
        			case 1:
        				PuzzleLevelModel puzzleLevel = new PuzzleLevelModel(de.getBoard(), de.getBullPen(), name , (PuzzleScore) de.getScore(), new Stock(), de.getNumMoves());
        				playableLevel = new PuzzleLevelPanel(currentPanel.getMainFrame(), puzzleLevel);
        				break;
        			case 2:
        				LightningLevelModel lightningLevel = new LightningLevelModel( (LightningBoard) de.getBoard(), de.getBullPen(), name ,de.getScore(), new Stock(), de.getTime());
        				playableLevel = new LightningLevelPanel(currentPanel.getMainFrame(), lightningLevel);
        				break;
        			case 3:
        				LevelModel releaseLevel = new LevelModel(de.getBoard(), de.getBullPen(), name, (ReleaseScore) de.getScore(), new Stock());
        				playableLevel = new ReleaseLevelPanel(currentPanel.getMainFrame(), releaseLevel);
        				break;
        			default:
        				System.err.println("No level type found to edit.");
        				
        				
        		}
        		
        		if(playableLevel == null){
        			System.err.println("No level type found to edit.");
        		}
        		
        		mainFrame.getContentPane().add(playableLevel, BorderLayout.CENTER);
        		mainFrame.getContentPane().revalidate();
        		
        	}
        });
        add(play);
    }
}
