package Main;

import javax.swing.*;

import Boundary.Player.KabasujiFrame;
import Boundary.Player.MainMenuPanel;
import Game.Stock;

import java.awt.*;
import java.awt.event.*;


public class KabasujiMain {
	public static void main(String[] args){
		Stock s = new Stock();
	
		final KabasujiFrame frame = new KabasujiFrame();
		frame.initialize();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}      
		});
	}
}
