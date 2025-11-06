package garden;

import java.io.Serializable;

/**
 * The Altibus class defines a type of plant.
 */
public class Altibus extends Plant implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Altibus behaves like any other plant, with the exception that it produces
	 * seeds when its height is greater than 7.
	 * 
	 * @return null if the plant's height is 7 or less. A new Altibus seed if the
	 *         height is greater than 7.
	 */
	@Override
	public Seed time() {
		Seed s = null;

		super.time(); // we recycle the behavior implemented in Plant.
		if (getHeight() > 7)
			s = new Seed(new Altibus()); // create a new Altibus seed
		return s;
	}

	/**
	 * The flower of Altibus is represented by 'O', and the stem by '|'.
	 */
	@Override
	public char getChar(int height) {
		char c = '|';

		if (height >= getHeight())
			c = ' ';
		if (height == getHeight() - 1)
			c = 'O';
		return c;
	}
}
