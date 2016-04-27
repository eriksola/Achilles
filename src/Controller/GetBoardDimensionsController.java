package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Boundary.BoardView;
import Boundary.KabaSuji;
import Boundary.LevelBuilderPuzzlePanel;

public class GetBoardDimensionsController implements ActionListener {
	JTextField x;
	JTextField y;
	int xNum;
	int yNum;
	BoardView bv;
	
	
	public GetBoardDimensionsController(JTextField x, JTextField y, BoardView bv) {
		this.x = x;
		this.y = y;
		this.bv = bv;
	}

	public void actionPerformed(ActionEvent e) {
		//Check if we have anything in the text field
		if(!x.getText().equals("") && !y.getText().equals("")){
			 try
			    {
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
