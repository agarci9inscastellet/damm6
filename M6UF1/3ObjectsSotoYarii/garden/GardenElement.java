package garden;

/**
 * This interface defines the minimum methods that any element of the garden must have.
 * Thanks to the use of this interface, we have achieved that Garden does not depend on any
 * specific class, such as Plant or Seed.
 */
public interface GardenElement {
    /**
     * This method returns the character that should be printed for this element at the specified
     * height. For example, for a plant, it would return the character corresponding to the flower
     * if the same height as the plant's height is requested. If the requested height is lower,
     * the character corresponding to the stem would be returned, and if it is higher, a space
     * would be returned.
     *
     * @param height The height for which the character to write is requested.
     * @return The character that should be written at the specified height for this garden element.
     */
    public char getChar(int height);

    /**
     * The time method is called every time this element needs to act in the garden. In general,
     * in this method, plants will grow, and perhaps die. If the element generates another element,
     * this method should return it.
     *
     * @return A new element that has been created, or null if no element has been created.
     */
    public GardenElement time();

    /**
     * Returns whether this element should continue in the garden or not.
     *
     * @return true if this element should continue in the garden, false if it should be removed.
     */
    public boolean isAlive();

    /**
     * If this element creates another one, this method can be called to know where to place it,
     * relative to the position of this element. For example, if the new element is to go in the
     * same position, this method would return 0. If it returns 1, it means that the new element
	 * goes one position to the right respect to the position of this element.. 
	 * 
	 * @return  The amount of spaces to place a new element in the garden with respect to the 
	 * position of this element.
	 */
	public int spread();
}
