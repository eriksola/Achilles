package Boundary;

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

import Game.Board;
import Game.BullPen;
import Game.Piece;

public class BoardView extends JPanel {

	Board brd;
	JFrame frame;
	
	public BoardView(JFrame f, Board brd) {
		this.frame = f;
		this.brd = brd;
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 133, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		setBackground(Color.white);
		draw();
	}
	
	public void draw(){
		int brdHeight = brd.getTiles().length*10;
		int brdWidth = brd.getTiles()[0].length*10;
		int brdRows = brd.getTiles().length;
		int brdCols = brd.getTiles()[0].length;
		BufferedImage img = new BufferedImage(brdWidth + 5, brdHeight + 5, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, brdWidth + 5, brdHeight + 5);
		g.setColor(Color.black);
		for(int i = 0; i < brdRows; i++){
			for(int j = 0; j < brdCols; j++){
				g.drawRect(j*10, i*10, 10, 10);
			}
		}
		ImageIcon img1 = new ImageIcon(img);
		JLabel label = new JLabel(img1);
		setLayout(new FlowLayout()); 
		add(label);
	}

}
