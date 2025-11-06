package garden;

import java.io.Serializable;

/**
 * This class models the seed of any plant.
 * 
 * To avoid having to create a different seed class for each type of plant,
 * it has been designed so that a seed stores a reference to a specific type
 * of Plant object to which this seed belongs. This Plant object will be the
 * plant that grows from the seed when it matures, and it also allows us to
 * delegate some operation that depends on the type of plant. This way, it will
 * only be necessary to create classes for specific seeds when they have a
 * different behavior from the majority of seeds.
 */
public class Seed implements GardenElement, Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * This plant will be the one that grows from this seed.
	 */
	private Plant plant;
	/**
	 * The lifespan of the seed. When it reaches 5, the seed germinates.
	 */
	private int lifespan = 0;
	/**
	 * Indicates whether the seed is alive or not. The seed is alive until it germinates.
	 */
	private boolean alive = true;
	/**
	 * The constructor of Seed receives a plant, which will be the new plant that
	 * grows from the seed when it matures.
	 * 
	 * @param p  The plant that must emerge from this seed.
	 */
	public Seed(Plant p) {
		plant = p;
	}
	/**
	 * The seed will remain alive for five turns. After that, the plant that is
	 * inside it (which it returns) will be born, and the seed will die.
	 * 
	 * @return  Null while the seed is still alive, the plant that must be born
	 * when the seed dies.
	 */
	@Override
	public Plant time() {
		Plant p = null;
		lifespan++;
		if (lifespan == 5) {
			p = plant;
			alive = false;
		}
		return p;
	}
	/**
	 * The seed always has a height of 0. It returns '.' if the height requested is 0
	 * and space if any other height is requested.
	 * 
	 * @param height  The height for which to obtain the character that should be
	 * written for the seed.
	 */
	@Override
	public char getChar(int height) {
		char c = ' ';
		if (height == 0)
			c = '.';
		return c;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
	
	@Override
	public int spread() {
		return 0;
	}
}
