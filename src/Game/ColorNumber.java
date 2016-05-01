package Game;

/**
 * ColorNumber used in order to represent the color and number of a Release level type in the <b> Kabasuji </b> game.
 * @author Achilles
 *
 */
public class ColorNumber {
	int ryg;
	int number;
	
	/**
	 * Creates a ColorNumber for a release level. The color associations are as follows:
	 * <ul> <li> Red = 1 </li> <li> Yellow = 2 </li> <li> Green = 3 </li> </ul> 
	 * @param col The color, either 1, 2, or 3.
	 * @param num The number associated with that color.
	 */
	ColorNumber(int col, int num){
		this.ryg = col;
		this.number = num;
	}

}
