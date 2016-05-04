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
	
	public abstract StockView getStockView(); /** getter for stockView **/
	public abstract void addLevelModel(); /** adds a LevelModel to the undo stack **/
	public abstract LevelModel getLastLevelModel(); /** returns the last undo levelModel **/
	public abstract void addModelForRedo(); /** adds a LevelModel to the redo stack **/
	public abstract LevelModel getLastRedoModel(); /** returns the last redo levelModel **/

}
