package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetTextController implements ActionListener {
	JTextField x;
	JTextField y;
	int xNum;
	int yNum;
	
	public GetTextController(JTextField x, JTextField y) {
		this.x = x;
		this.y = y;
	}

	public void actionPerformed(ActionEvent e) {
		//Check if we have anything in the text field
		if(!x.getText().equals("") && !y.getText().equals("")){
			 try
			    {
			      //Try to convert the string in the text in an int
			      xNum = Integer.parseInt(x.getText());
			      yNum = Integer.parseInt(y.getText());
	
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
