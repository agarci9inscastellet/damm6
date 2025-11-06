package garden;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * In this exercise we will make a new version of the program garden.
 * 
 * In the current version, the time passed each time the user entered a line of text, 
 * except if I typed exit, at which point the program ended.
 * 
 * In this version, when the user types exit the state of the garden using an ObjectStream.
 * 
 * It will always be saved in the same file, from name garden.sav.
 * 
 * When the program is run again, the first thing it should do is check if there is a 
 * half-saved game, load it if that's the case, and continue from where he was.
 * */
import java.util.Scanner;

/**
 * This class creates a garden, adds some plants to it, and advances
 * one turn every time the user enters a line of text.
 */
public class Main {
    /**
     * The garden created, with size 40.
     */
    private Garden garden = new Garden(40);

    /**
     * The main method just creates an instance of this class. The
     * constructor of this class does the rest. This is a common pattern,
     * since we're working with an object, it avoids having to declare
     * all other properties and methods of the class as static.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Initializes the garden and asks for user input. Each line that
     * is entered advances the garden one turn. If the user enters the
     * string "quit", the program ends.
     */
    public Main() {
    	Garden actualGarden= openGarden();
    	
        Scanner sc = new Scanner(System.in);
        
        String command = "";
        
        if(actualGarden == null) {
        	garden.addElement(new Altibus(), 10);
            garden.addElement(new Declinus(), 30);
    	}else {
    		garden=actualGarden;
    	}
        
        while (!command.equals("quit")) {
            garden.time();
            
            System.out.println(garden.toString());
            
            command = sc.nextLine();
 
        }
        
        storeGarden(garden);
        sc.close();
    }
    
    /**
     * Store garden object.
     * @param garden - a garden object.
     */
    private void storeGarden(Garden garden) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("garden.sav"))) {

			writer.writeObject(garden);

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
    
    /**
     * Store garden object.
     * @param garden - a garden object.
     */
    private Garden openGarden() {
    	Garden garden=null;
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("garden.sav"))) {
			Object gar= reader.readObject();
			
			garden=(Garden) gar;
			
			return garden;

		} catch (IOException e) {
			//System.err.println(e.getMessage());
		}catch (ClassNotFoundException e) {
			//System.err.println(e.getMessage());
		}
		
		return garden;
	}
}
