package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Boundary.Both.KabaSuji;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.PuzzleLevelPanel;
import Game.LevelModel;
import Game.PuzzleLevelModel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Controller to undo the last move in the builder
 * @author bwolfson
 *
 */
public class UndoController implements ActionListener{

	KabaSuji view;
	JFrame frame;
	

	public UndoController(KabaSuji view, JFrame frame) {
		this.view = view;
		this.frame = frame;
	}
	
	/**
	 * Invoked when the button is pressed to undo a move
	 */
	public void actionPerformed(ActionEvent e) {
		LevelModel model = view.getLastLevelModel();

		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		// instanceof check
		if(view instanceof LevelBuilderPuzzlePanel){
			LevelBuilderPuzzlePanel puzzleLevelView = new LevelBuilderPuzzlePanel(frame, (PuzzleLevelModel)model, 
																((LevelBuilderPuzzlePanel)view).getLevelModels(),
																view.getSelectedPiece());
			frame.getContentPane().add(puzzleLevelView, BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		
	}

}