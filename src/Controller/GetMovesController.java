package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Boundary.Both.KabaSuji;
import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.EditPuzzleLevelPanel;
import Boundary.Builder.EditReleaseLevelPanel;
import Boundary.Builder.KabaSujiBuilder;
import Boundary.Builder.LevelBuilderLightningPanel;
import Boundary.Builder.LevelBuilderPuzzlePanel;
import Boundary.Builder.LevelBuilderReleasePanel;
import Game.PuzzleScore;

/**
 * 
 * Controller to get the amount of moves for a puzzle or release level.
 * @author Sola
 *
 */
public class GetMovesController implements ActionListener {
	JTextField moves;
	KabaSujiBuilder view;
	int numMoves;
	
	/**
	 * Creates a GetMovesController.
	 * @param moves TextField where the amount of moves will be types in.
	 * @param p Panel where the text field resides.
	 */
	public GetMovesController(JTextField moves, KabaSujiBuilder view) {
		this.moves = moves;
		this.view = view;
		if(!moves.getText().equals("")){
			numMoves = Integer.parseInt(moves.getText());
		}
	}

	/**
	 * Invoked when the Enter Moves button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		//Check if we have anything in the text field
		if(!moves.getText().equals("")){
			 try
			    {
				  view.addLevelModel();
			      //Try to convert the string in the text in an int
			      numMoves = Integer.parseInt(moves.getText());
			      // print out the value after the conversion
			      System.out.println("numMoves = " + numMoves);
			    }
			    catch (NumberFormatException nfe)
			    {
			      System.out.println("NumberFormatException: " + nfe.getMessage());
			    }
			 

			if(view instanceof LevelBuilderPuzzlePanel){
				((LevelBuilderPuzzlePanel) view).addEntity(new PuzzleScore(numMoves));
				((LevelBuilderPuzzlePanel) view).addEntity(numMoves);
			}


			else if (view instanceof EditPuzzleLevelPanel){
				((EditPuzzleLevelPanel) view).addEntity(new PuzzleScore(numMoves));
				((EditPuzzleLevelPanel) view).addEntity(numMoves);
			}
		}
	}
	public boolean hasMoves(){
		return this.numMoves > 0;
	}
	
	public int getMoves(){
		return this.numMoves;
	}

}

