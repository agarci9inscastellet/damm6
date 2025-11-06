package garden;

import java.io.Serializable;
import java.util.Random;

/**
 * The Plant class is the superclass for all garden elements that are plants.
 * The Plant class works together with the Seed class to simulate the dynamics
 * of plants: plants generate seeds, and seeds generate new plants of the same type.
 *
 * This class defines default behaviors for plants, which can be overridden by
 * derived classes to adapt the behaviors of each species.
 */
public abstract class Plant implements GardenElement, Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * This random object is shared among all plants and allows generating
	 * the necessary random numbers.
	 */
	private static final Random random = new Random();
	/**
	 * Indicates whether the plant is alive or dead. When the plant is dead,
	 * it will be removed from the garden.
	 */
	protected boolean alive = true;
	/**
	 * The current height of the plant.
	 */
	protected int height;

	/**
	 * Default behavior for plants as time passes. A plant grows one height
	 * unit every time this method is called, up to a maximum of 10. When the
	 * maximum height is reached, the plant dies.
	 *
	 * This method never returns a seed; each subclass should decide when to
	 * do so.
	 *
	 * @return  Always returns null. Note that it is valid to return a Seed
	 *          object instead of a GardenElement object. This is logical
	 *          because a plant can only create seeds, and it is legal at the
	 *          language level because all Seeds are always GardenElements
	 *          (since Seed implements GardenElement).
	 */
	@Override
	public Seed time() {
		if (height < 10)
			height++;
		else
			alive = false;
		return null;
	}

	/**
	 * By default, a plant scatters its seeds at a distance of 1 or 2,
	 * to the right or left.
	 *
	 * @return  A random number between -2, -1, 1, and 2.
	 */
	@Override
	public int spread() {
		int sign = 2 * random.nextInt(2) - 1;
		int distance = random.nextInt(2) + 1;
		return sign * distance;
	}

	/**
	 * Returns the current height of the plant.
	 *
	 * @return  The current height of the plant.
	 */
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
}
