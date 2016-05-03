package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Boundary.Both.BoardView;
import Boundary.Both.KabaSuji;
import Boundary.Builder.KabaSujiBuilder;
import Boundary.Builder.LevelBuilderPuzzlePanel;

/**
 * Controller to retrieve the dimensions set for a board in the level builder.
 * @author Wolfson
 *
 */
public class GetBoardDimensionsController implements ActionListener {
	JTextField x;
	JTextField y;
	int xNum;
	int yNum;
	KabaSujiBuilder view;
	
	/**
	 * Creates a GetBoardDimensionsController.
	 * @param x JTextField where x coordinate can be entered.
	 * @param y TextField where y coordinate can be entered.
	 * @param view Panel where the controller resides.
	 */
	public GetBoardDimensionsController(JTextField x, JTextField y, KabaSujiBuilder view) {
		this.x = x;
		this.y = y;
		this.view = view;
	}

	/**
	 * Invoked when the set board button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		//Check if we have anything in the text field
		if(!x.getText().equals("") && !y.getText().equals("")){
			 try
			    {
			      view.addLevelModel();

				  BoardView bv = view.getBoardView();
			      //Try to convert the string in the text in an int
			      xNum = Integer.parseInt(x.getText());
			      yNum = Integer.parseInt(y.getText());
			      if(!(xNum < 6 || yNum < 6 || xNum > 12 || yNum > 12)){
			    	  bv.setBoard(xNum, yNum);
			    	  bv.draw();
			      }
			      // print out the value after the conversion
			      System.out.println("int x = " + xNum);
			      System.out.println("int y = " + yNum);
			    }
			    catch (NumberFormatException nfe)
			    {
			      System.out.println("NumberFormatException: " + nfe.getMessage());
			    }
			 
		}
	}
	
	public int getXNum(){
		return this.xNum;
	}
	public int getYNum(){
		return this.yNum;
	}

}
