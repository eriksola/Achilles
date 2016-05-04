package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Boundary.Both.KabaSuji;
import Boundary.Builder.KabaSujiBuilder;
import Game.ColorNumber;
import Game.ReleaseTile;
import Game.Tile;

public class ReleaseTileController implements ActionListener{
	
	KabaSujiBuilder view;
	JComboBox colorView;
	JTextField numView;
	String color;
	int num;
	
	public ReleaseTileController(KabaSujiBuilder v, JComboBox color, JTextField num){
		this.view = v;
		this.colorView = color;
		this.numView = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.color = (String) colorView.getSelectedItem();
		if (!numView.getText().equals("")){
			this.num = Integer.parseInt(numView.getText());
		}
		
		System.out.println("Add release tile");
		System.out.println(color + "\n" + num);
		Tile selectedTile = view.getBoardView().getSelectedTile();
		Tile[][] tiles = view.getBoardView().getBoard().getTiles();
		if (selectedTile != null){
			view.addLevelModel();
			
			int col = selectedTile.getCol();
			int row = selectedTile.getRow();
			
			//convert color into int representation
			int ryg = 0;
			if (color.equals("red")){ ryg = 1; }
			if (color.equals("yellow")) { ryg = 2; }
			if (color.equals("green")) {ryg = 3; }
			
			//checks the number is valid
			boolean validNum = false;
			if (num <= 6 && num >= 1){
				validNum = true; }
			
			//if there is a selected tile 
			if (validNum){
				System.out.println("Add valid release tile");
				ColorNumber colNum = new ColorNumber(ryg, num);
				tiles[col][row] = new ReleaseTile(row, col, colNum);
			} 
		view.getBoardView().deselectTile();
		view.getBoardView().draw();
		}
	}
}
