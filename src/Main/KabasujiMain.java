package Main;

import javax.swing.*;

import Boundary.KabasujiFrame;
import Boundary.MainMenuPanel;

import Game.Stock;


import java.awt.*;
import java.awt.event.*;


public class KabasujiMain {
	public static void main(String[] args){
		Stock s = new Stock();
		final KabasujiFrame frame = new KabasujiFrame();

		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}      
		});
	}
}
