package Boundary.Builder;

import javax.swing.JScrollPane;

import Boundary.Both.KabaSuji;
import Boundary.Both.StockView;
import Game.Stock;
/**
 * Necessary abstract class for building levels
 * @author gaguila
 *
 */
public abstract class KabaSujiBuilder extends KabaSuji{
	
	public abstract StockView getStockView();

}
