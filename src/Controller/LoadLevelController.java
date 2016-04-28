package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Boundary.Both.Deserialization;
import Boundary.Builder.EditLightningLevelPanel;
import Boundary.Builder.EditPuzzleLevelPanel;
import Boundary.Builder.EditReleaseLevelPanel;
import Boundary.Player.KabasujiFrame;
import Boundary.Player.LightningLevelPanel;
import Boundary.Player.PuzzleLevelPanel;
import Game.LevelModel;
import Game.LightningLevelModel;
import Game.LightningScore;
import Game.PuzzleLevelModel;
import Game.PuzzleScore;

public class LoadLevelController implements ActionListener {

	JFrame mainFrame;
	int levelType;
	int levelNum;
		
	public LoadLevelController(JFrame kabasuji, int levelType, int levelNum){
		this.mainFrame = kabasuji;
		this.levelType = levelType;
		this.levelNum = levelNum;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().invalidate();
				
		JPanel level = null;
		Deserialization de = new Deserialization();
		
		switch(levelType){
			case 1:
					de.Deserialize("./src/DefaultLevels/PuzzleLevels/" + levelNum + ".txt", levelType);
					int totalPieces;
					totalPieces = de.getBullPen().getNumOfPieces();
					PuzzleScore ps = new PuzzleScore(totalPieces);
					PuzzleLevelModel lm = new PuzzleLevelModel(de.getBoard(), de.getBullPen(), 2, ps, de.getNumMoves());
					level = new PuzzleLevelPanel((KabasujiFrame) mainFrame, lm);
			
				break;
			case 2:
				de.Deserialize("./src/DefaultLevels/LightningLevels/" + levelNum + ".txt", levelType);
				int time;
				//fix
				int pieces = de.getBullPen().getNumOfPieces();
				//FIX THIS
				LightningScore ls = new LightningScore(pieces);
				LightningLevelModel lmm = new LightningLevelModel(de.getBoard(), de.getBullPen(), 2, ls, de.getTime());
				level = new LightningLevelPanel((KabasujiFrame) mainFrame, lmm);
				break;
			case 3:
				//level = new ReleaseLevelPanel(, de, levelNum);
				break;
			default:
				System.err.println("No level type found to edit.");			
		}
		if(level == null){
			System.err.println("No level type found to edit.");
		}
		
		mainFrame.getContentPane().add(level, BorderLayout.CENTER);
		mainFrame.getContentPane().revalidate();
	}

}
