package Main;

import javax.swing.*;

import Boundary.Builder.LevelBuilderFrame;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.MainMenuPanel;
import Game.Stock;

import java.awt.*;
import java.awt.event.*;

/**
 * Run the builder.
 * @author Achilles
 *
 */
public class LevelBuilderMain {
	public static void main(String[] args){
		Stock s = new Stock();
		final LevelBuilderFrame frame = new LevelBuilderFrame(s);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}      
		});
	}
}
