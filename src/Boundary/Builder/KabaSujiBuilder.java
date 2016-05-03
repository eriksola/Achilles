package Boundary.Builder;

import javax.swing.JScrollPane;

import Boundary.Both.BoardView;
import Boundary.Both.BullPenView;
import Boundary.Both.KabaSuji;
import Boundary.Both.StockView;
import Game.LevelModel;
import Game.Stock;
/**
 * Necessary abstract class for building levels
 * @author gaguila
 *
 */
public abstract class KabaSujiBuilder extends KabaSuji{
	
	public abstract StockView getStockView();
	public abstract void addLevelModel();
	public abstract LevelModel getLastLevelModel();
	public abstract void addModelForRedo();
	public abstract LevelModel getLastRedoModel();

}
