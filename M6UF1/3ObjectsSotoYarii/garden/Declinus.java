package garden;

import java.io.Serializable;

/**
 * The Declinus class defines a specific type of plant.
 */
public class Declinus extends Plant implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * For the operation of Declinus, it is important to know whether the plant
	 * is in its growth or decline cycle. This attribute informs about this circumstance.
	 */
	private boolean ascending = true;
	/**
	 * Declinus grows once every two turns. This attribute is true when it's
	 * time to grow and false when it's not.
	 */
	private boolean needsToGrow = false;
	/**
	 * Declinus ascends to height 4 and then begins to decline. Growth/decline occurs
	 * once every two turns. And it produces two seeds, one each turn when it is at
	 * height 4.
	 * 
	 * @return  a Declinus seed if the height of the plant is 4. null otherwise.
	 */
	@Override
	public Seed time() {
		Seed s = null;
		
		if (needsToGrow) {
			if (ascending) {
				if (getHeight() < 4)
					height++;
				else
					ascending = false;
			} else {
				if (getHeight() >= 0)
					height--;
				else
					alive = false;
			}
		}
		needsToGrow = !needsToGrow; // grows once every two turns

		if (getHeight() == 4)
			s = new Seed(new Declinus()); // create a Declinus seed
		return s;
	}

	/**
	 * The flower of Declinus is represented with the character * and the stem with :
	 */
	@Override
	public char getChar(int height) {
		char c = ':';
		
		if (height >= getHeight())
			c = ' ';
		if (height == getHeight() - 1)
			c = '*';
		return c;
	}

}
