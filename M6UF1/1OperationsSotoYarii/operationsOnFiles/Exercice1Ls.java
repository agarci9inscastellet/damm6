

import java.io.File;

/*
 * Exercise 1. Simple version of ls.
 * Make a program that takes a directory name as a parameter and displays its directory content, 
 * indicating in each case whether it is a file or directory and the permissions we have on it.
 * */

/**
 * 
 * @author Yarii Soto
 * @version v1, 25 September 2023
 */
public class Exercice1Ls {
	public static void main(String[] args) {
		
		//If the user introduce an arguments
		if (args.length == 1) {
			//Print a program explanation
			System.out.println("This program is a simple ls version, lists files and directories.");
			
			//Create a File element with the arguments
			File path = new File(args[0]);
			
			listContent(path);
			
		}else {
			System.out.println("No arguments entered");
		}
	}
	
	/**
	 * Method to list the directory content
	 * @param path - the current path
	 */
	public static void listContent(File path) {
		//Create a File array
		File[] files;
		
		
		if(isCorrectDir(path)) {
			//Print actual path
			System.out.println(path);
			
			//Return list of directories and files
			files = path.listFiles();
			
			//Print the files list
			for(File currFile:files) {
				String type = currFile.isDirectory()?"d":"-";
				
				System.out.println(type+getPermissions(currFile)+" "+currFile.getName());
			}
		}else {
			System.out.println("Cannot be listed");
		}
	}
	
	/**
	 * Method to get the permissions.
	 * @param file - the current file
	 * @return - A permissions string
	 */
	public static String getPermissions(File file) {
		String perm="";
		
		if(file.canRead()) {perm += "r";}
		
		if(file.canWrite()) {perm += "w";}
		
		if(file.canExecute()) {perm += "x";}
		
		return perm;
	}
	
	/**
	 * Method to check the path
	 * @param path - the user path
	 * @return - true if the path is correct
	 */
	public static boolean isCorrectDir(File path) {
		//Path check
		if(path.exists()) {
			
			if(path.isDirectory()) {
				return true;
			}else {
				System.out.println("Is a file.");
				return false;
			}
		}else {
			System.out.println("Error! Path not found.");
			return false;
		}
	}
}
