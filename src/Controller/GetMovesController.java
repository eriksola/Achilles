package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetMovesController implements ActionListener {
	JTextField moves;
	int numMoves;
	
	public GetMovesController(JTextField moves) {
		this.moves = moves;
	}

	public void actionPerformed(ActionEvent e) {
		//Check if we have anything in the text field
		if(!moves.getText().equals("")){
			 try
			    {
			      //Try to convert the string in the text in an int
			      numMoves = Integer.parseInt(moves.getText());
			      // print out the value after the conversion
			      System.out.println("int numMoves = " + numMoves);
			    }
			    catch (NumberFormatException nfe)
			    {
			      System.out.println("NumberFormatException: " + nfe.getMessage());
			    }
		}
	}
	
	public int getMoves(){
		return this.numMoves;
	}

}

