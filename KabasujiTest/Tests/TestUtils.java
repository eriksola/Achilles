package Tests;

import java.awt.*;

//http://www.ece.uvic.ca/~shsaad/seng426/resources/Lab%20Slides/Lab4-SENG09.pdf
public class TestUtils {

	static int counter;
	
	public static Component getChildNamed(Component parent, String name){
		if(name.equals(parent.getName())){ return parent; }
		
		if(parent instanceof Container){
			Component[] children = ((Container)parent).getComponents();
			
			for (int i = 0; i < children.length; i++) {
				Component child = getChildNamed(children[i], name);
				if(child != null){ return child; }
			}
		}
		
		return null;
	}
}
