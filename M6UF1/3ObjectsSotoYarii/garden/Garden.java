package garden;

import java.io.Serializable;

/**
 * The Garden class manages the elements of a garden and allows
 * to see their evolution over time.
 */
public class Garden implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Constant that defines the maximum height of a garden
	 */
	private static final int GARDEN_HEIGHT = 10;
	/**
	 * Array with all the elements in the garden
	 */
	private GardenElement[] elements;
	/**
	 * To make it easier to convert the garden to a string, here we store
	 * the ground line of the garden.
	 */
	private String ground = "";
	/**
	 * Parameterless constructor. Creates a garden of size 10.
	 */
	public Garden() {
		this(10);
	}
	/**
	 * Constructor with one parameter. Creates a garden with the specified size.
	 *
	 * @param size The size the garden should have. Must be a positive number.
	 */
	public Garden(int size) {
		/*
		 * If the size is incorrect, we create a garden of size 10 and display an error
		 * on the screen. Later we will see how to handle these situations better
		 * using exceptions.
		 */
		if (size <= 0) {
			System.err.println("Garden: incorrect size");
			size = 10;
		}
		elements = new GardenElement[size];
		for (int i = 0; i < size; i++)
			ground += "_";
	}

	/**
	 * Advances time for this garden.
	 */
	public void time() {
		GardenElement newElement;
        GardenElement element;
		int i;
		int location;
		
		for (i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
                element = elements[i];
				// advance time for all elements
				newElement = element.time();
				// remove dead elements
				if (!element.isAlive())
					elements[i] = null;
				// if a new element was created, try to place it
				if (newElement != null) {
					location = i + element.spread();
					addElement(newElement, location);
				}
			}
		}
	}

	/**
	 * Returns a multi-line string with a representation of the garden.
	 *
	 * @return A string that represents the entire garden.
	 */
	@Override
	public String toString() {
		int height, position;
		String s = "";
		
		// to create the string, we start with the maximum height and go down
		for (height = GARDEN_HEIGHT - 1; height >= 0; height--) {
			// for each element in the garden...
			for (position = 0; position < elements.length; position++) {
				if (elements[position] == null)
					s += ' ';
				else
					// ... add the character that corresponds to the current height.
					s += elements[position].getChar(height);
			}
			// add a new line at the end of each height
			s += "\n";
		}
		// at the bottom, add the ground line
		s += ground;
		return s;
	}
	
	/**
	 * Attempts to add a new element to the garden.
	 *
	 * @param newElement  Element to be added to the garden.
	 * @param position  Position where the new element should be placed.
	 * @return  true if the element was successfully added, false if not. An element
	 * cannot be added if the indicated position does not exist in the garden or if
	 * it already contains another element.
	 */
	public boolean addElement(GardenElement newElement, int position) {
	    boolean isSpaceAvailable = false;
	    if (position >= 0 && position < elements.length && elements[position] == null) {
	        isSpaceAvailable = true;
	        elements[position] = newElement;
	    }
	    return isSpaceAvailable;
	}
}
