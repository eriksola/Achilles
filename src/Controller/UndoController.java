package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.EditPuzzleLevelPanel;
import Boundary.Builder.EditReleaseLevelPanel;
import Boundary.Builder.KabaSujiBuilder;
import Boundary.Builder.LevelBuilderLightningPanel;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Builder.LevelBuilderReleasePanel;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.PuzzleLevelModel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controller to undo the last move performed in the builder
 * @author bwolfson
 *
 */
public class UndoController implements ActionListener{

	JFrame frame; /** the main frame of the application. **/
	JPanel panel; /** the panel containing previous state to be loaded back up. **/
	
	/**
	 * Constructs an UndoController from a main frame and target panel.
	 * @param frame the main frame.
	 * @param panel the panel to be loaded.
	 */
	public UndoController(JFrame frame, JPanel panel) {
		this.frame = frame;
		this.panel = panel;
	}
	
	/**
	 * Invoked when the button is pressed to undo a move
	 */
	public void actionPerformed(ActionEvent e) {
		//add current state to levelModels saved for redo
		
		KabaSujiBuilder view = (KabaSujiBuilder)panel;
		LevelModel model = view.getLastLevelModel(); //the previous state to be loaded
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		if (model != null){
			//check if being called from puzzle, lightning, or release builder
			if(view instanceof LevelBuilderPuzzlePanel){
				((LevelBuilderPuzzlePanel)view).addModelForRedo();
				LevelBuilderPuzzlePanel puzzleLevelView = new LevelBuilderPuzzlePanel(frame, (PuzzleLevelModel)model, 
						((LevelBuilderPuzzlePanel)view).getLevelModels(),((LevelBuilderPuzzlePanel)view).getRedoModels());
				frame.getContentPane().add(puzzleLevelView, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
			else if(view instanceof LevelBuilderLightningPanel){
				((LevelBuilderLightningPanel)view).addModelForRedo();
				LevelBuilderLightningPanel lightningLevelView = new LevelBuilderLightningPanel(frame, (LightningLevelModel)model, 
						((LevelBuilderLightningPanel)view).getLevelModels(), ((LevelBuilderLightningPanel)view).getRedoModels());
				frame.getContentPane().add(lightningLevelView, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
			else if(view instanceof LevelBuilderReleasePanel){
				((LevelBuilderReleasePanel)view).addModelForRedo();
				LevelBuilderReleasePanel puzzleLevelView = new LevelBuilderReleasePanel(frame, (LevelModel)model, 
						((LevelBuilderReleasePanel)view).getLevelModels(), ((LevelBuilderReleasePanel)view).getRedoModels());
				frame.getContentPane().add(puzzleLevelView, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}	
			else if(view instanceof EditPuzzleLevelPanel){
				((EditPuzzleLevelPanel)view).addModelForRedo();
				EditPuzzleLevelPanel puzzleLevelView = new EditPuzzleLevelPanel(frame, (PuzzleLevelModel)model, 
						((EditPuzzleLevelPanel)view).getLevelModels(), ((EditPuzzleLevelPanel)view).getRedoModels());
				frame.getContentPane().add(puzzleLevelView, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
			else if(view instanceof EditLightningLevelPanel){
				((EditLightningLevelPanel)view).addModelForRedo();
				EditLightningLevelPanel lightningLevelView = new EditLightningLevelPanel(frame, (LightningLevelModel)model,
						((EditLightningLevelPanel)view).getLevelModels(), ((EditLightningLevelPanel)view).getRedoModels());
				frame.getContentPane().add(lightningLevelView, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			
			}
			else if(view instanceof EditReleaseLevelPanel){
				((EditReleaseLevelPanel)view).addModelForRedo();
				EditReleaseLevelPanel releaseLevelView = new EditReleaseLevelPanel(frame, (LevelModel)model,
						((EditReleaseLevelPanel)view).getLevelModels(), ((EditReleaseLevelPanel)view).getRedoModels());
				frame.getContentPane().add(releaseLevelView, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
				
			}
		}
	}
}