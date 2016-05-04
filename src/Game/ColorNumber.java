package Game;
import java.io.Serializable;
/**
 * ColorNumber used in order to represent the color and number of a Release level tile in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class ColorNumber implements Serializable{

	int ryg; /** 1 - Red, 2 - Yellow, 3 - Green **/
	int number; /**number on the tile **/
	
	/**
	 * Creates a ColorNumber for a release level. The color associations are as follows:
	 * <ul> <li> Red = 1 </li> <li> Yellow = 2 </li> <li> Green = 3 </li> </ul> 
	 * @param col The color, either 1, 2, or 3.
	 * @param num The number associated with that color.
	 */
	public ColorNumber(int col, int num){
		this.ryg = col;
		this.number = num;
	}
	
	/**
	 * getter function for the color
	 * @return the int representation of the color on the tile
	 */
	public int getColor(){
		return this.ryg;
	}
	
	/**
	 * getter function for the num
	 * @return the number on the tile
	 */
	public int getNum(){
		return this.number;
	}
}
