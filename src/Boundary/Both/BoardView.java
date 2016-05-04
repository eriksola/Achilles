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
import Game.ReleaseTile;
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
	 * Draws the current state of the Board, occupied tiles cyan, selected tiles/pieces magenta, unoccupied white.
	 * For release levels it displays red, yellow, and green tiles with numbers
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
					
					if (brd.getTiles()[i][j] instanceof ReleaseTile){
						
						ReleaseTile relTile = (ReleaseTile) brd.getTiles()[i][j];
						int col = relTile.getColNum().getColor();
						int num = relTile.getColNum().getNum();
						
						//get the appropriate color for the int representation of the color
						if (col == 1){
							g.setColor(Color.RED);
						}
						
						if (col == 2){
							g.setColor(Color.YELLOW);
						}
						
						if (col == 3){
							g.setColor(Color.GREEN);
						}
						g.fillRect(j*20, i*20, 20, 20);
						g.setColor(Color.BLACK);
						
						//add the number to the tile
						g.drawString(Integer.toString(num), j*20 + 7, i*20 + 15);
					}
					
					if(brd.getTiles()[i][j].isOccupied()){
						g.setColor(Color.CYAN);
						g.fillRect(j*20, i*20, 20, 20);
						g.setColor(Color.BLACK);
					}
				
					if(brd.getTiles()[i][j].isSelected()){
						g.setColor(Color.MAGENTA);
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
	/**
	 * getter function for the Board
	 * @return the board
	 */
	public Board getBoard(){
		return this.brd;
	}
	/**
	 * Set the board as a new board with a tile double array with the given parameters
	 * @param row y-param for the tile double array
	 * @param col x-param for the tile double array
	 */
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
	
	/**
	 * getter function for the BullPenView
	 * @return the bullpenview
	 */
	public BullPenView getBullPenView(){
		return this.bpv;
	}
	
	/**
	 * getter function for the label
	 * @return the label
	 */
	public JLabel getLabel(){
		return this.label;
	}
	
	/**
	 * getter function for the selected tile on the boardview
	 * @return the selected tile
	 */
	public Tile getSelectedTile(){
		return this.selectedTile;
	}
	
	/**
	 * Sets the selected tile on the boardview
	 * @param t the new selected tile
	 */
	public void setSelectedTile(Tile t){
		//if there is a selected tile, unselect it
		if (this.selectedTile != null){
			this.selectedTile.setSelected(false);
		}
		//set the new tile as selected
		this.selectedTile = t;
		this.selectedTile.setSelected(true);
		draw();
	}
	/**
	 * Deselects the selected tile on the boardview
	 */
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
