package Boundary.Both;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import Controller.BoardController;
import Controller.PieceController;
import Game.Board;
import Game.BullPen;
import Game.Coordinate;
import Game.Piece;
import Game.Tile;

/**
 * Visual manifestation of the Board entity.
 * @author bwolfson
 *
 */
public class BoardView extends JPanel {

	Board brd; /** the Board entity **/
	JFrame frame; /** the JFrame the BoardView belongs to. **/
	JLabel label; /** the label representing the Board. **/
	KabaSuji view; /** the top-level boundary object. **/
	BullPenView bpv; /** the BullPenView **/
	Tile selectedTile; /** the tile on the board which was most recently selected**/
	
	/**
	 * Constructor for the BoardView.
	 * @param f
	 * @param brd
	 * @param view
	 * @param bullPenView the BullPenView
	 */
	public BoardView(JFrame f, Board brd, KabaSuji view, BullPenView bullPenView) {
		this.frame = f;
		this.brd = brd;
		this.view = view;
		this.bpv = bullPenView;
		this.selectedTile = null;
		
		label = new JLabel();
		label.setLayout(new FlowLayout()); 
		add(label);
		draw();
	}
	
	/**
	 * draws the current state of the Board, occupied Tiles yellow, unoccupied white.
	 */
	public void draw(){
	
		int brdHeight = brd.getTiles().length*20;
		int brdWidth = brd.getTiles()[0].length*20;
		int brdRows = brd.getTiles().length;
		int brdCols = brd.getTiles()[0].length;
		BufferedImage img = new BufferedImage(brdWidth + 5, brdHeight + 5, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, brdWidth + 5, brdHeight + 5);
		g.setColor(Color.BLACK);
		for(int i = 0; i < brdRows; i++){
			for(int j = 0; j < brdCols; j++){
				
				if(brd.getTiles()[i][j] != null){
					
					g.drawRect(j*20, i*20, 20, 20);
					g.setColor(Color.WHITE);
					g.fillRect(j*20, i*20, 20, 20);
					g.setColor(Color.BLACK);
					
					if(brd.getTiles()[i][j].isHint()){
						g.setColor(Color.GREEN);
						g.fillRect(j*20, i*20, 20, 20);
						g.setColor(Color.BLACK);
					}
					
					if(brd.getTiles()[i][j].isOccupied()){
						g.setColor(Color.RED);
						g.fillRect(j*20, i*20, 20, 20);
						g.setColor(Color.BLACK);
					}
				
					if(brd.getTiles()[i][j].isSelected()){
						g.setColor(Color.YELLOW);
						g.fillRect(j*20, i*20, 20, 20);
						g.setColor(Color.BLACK);
					}
					g.drawRect(j*20, i*20, 20, 20);
				}
			}
		}
		ImageIcon img1 = new ImageIcon(img);
		label.setIcon(img1);
	}
	
	public Board getBoard(){
		return this.brd;
	}
	
	public void setBoard(int row, int col){
		Tile[][] brdTiles = new Tile[row][col];
		
		//start board empty
		for (int i = 0; i < brdTiles.length; i++) {
			for (int j = 0; j < brdTiles[0].length; j++) {
				brdTiles[i][j] = new Tile(i, j);
			}
		}
		
		this.brd.setTiles(brdTiles);
	}
	
	public BullPenView getBullPenView(){
		return this.bpv;
	}
	
	public void setBullPenView(BullPenView bpv){
		this.bpv = bpv;
	}
	
	public JLabel getLabel(){
		return this.label;
	}
	
	public Tile getSelectedTile(){
		return this.selectedTile;
	}
	
	public void setSelectedTile(Tile t){
		//if there is a selected tile, unselect it
		if (this.selectedTile != null){
			this.selectedTile.setSelected(false);
		}
		//set the new tile as selected
		this.selectedTile = t;
		t.setSelected(true);
		draw();
	}
	
	public void deselectTile(){
		//if there is a selectedTile, unselect it
		if (this.selectedTile != null){
			this.selectedTile.setSelected(false);
		}
		//remove the selected Tile
		this.selectedTile = null;
		draw();
	}
}
