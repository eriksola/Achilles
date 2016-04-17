package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.BullPen;
import View.PieceView;

public class RotateRightController implements ActionListener{

	BullPen bp;
	JLabel label;

	public RotateRightController(BullPen bp, JLabel label){
		this.bp = bp;
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		bp.rotateRight();
		PieceView pv = null;
		for(PieceView view: bp.getPvs()){
			if(view.getP() == bp.getSelectedPiece()){
				pv = view;
			}
		}
		label.setIcon(new ImageIcon(pv.getBufferedImage()));
		label.repaint();
	}
}