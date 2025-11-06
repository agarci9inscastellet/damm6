package operationsOnFiles;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

/*
 * Exercise 2. Simple version of ls -R
 * Make a program that takes a directory name as a parameter and displays its directory content, 
 * indicating in each case whether it is a file or directory and the permissions we have on it.
 * 
 * The program will act recursively, showing the content of all the subdirectories it encounters.
 * 
 * To do this, it uses a stack to hold pending directory names show.
 * */

/**
 * 
 * @author Yarií Soto
 * @version v1, 27 September 2023
 */
public class Exercice2LsR {
	private static Deque<File> stack = new LinkedList<>();
	
	public static void main(String[] args) {
		//If the user introduce an arguments
		if (args.length>0) {
			String directory=args[0];
			
			//Print a program explanation
			System.out.println("This program is a simple version of ls -R, lists files and directories recursively.");
			
			//Get the argument path
			File dirPath = new File(directory);
			
			//Print actual path
			//System.out.println(dirPath);
			
			//Push the actual path 
			stack.push(dirPath);
			
			//Print the directories content
			while(!stack.isEmpty()) {
				//Save the stack's first object
				File firstDir = stack.pop();
				
				//Print the actual path
				System.out.println("\n"+firstDir+":");
				
				//List the directory content
				listContent(firstDir);
			}
			
		}else {
			System.out.println("No arguments entered");
		}
	}
	
	
	/**
	 * Method to list the directory content
	 * @param path - the current path
	 */
	public static void listContent(File dir) {
		//Fill an array with directories and files list
		File[] files = dir.listFiles();
		
		//Print the files list
		for(File currFile:files) {
			if(currFile.isDirectory()) {
				//Push the actual path 
				stack.push(currFile);
			}
			
			System.out.println(getContentType(currFile)+getPermissions(currFile)+" "+currFile.getName());
		}
	}
	
	/**
	 * Method to get the content type
	 * @param currFile - the actual object
	 * @return a string
	 */
	public static String getContentType(File currFile) {
		String type;
		if(currFile.isDirectory()) {
			type="d";
			
		}else {
			type="-";
		}
		return type;
	}
	
	/**
	 * Method to get the permissions.
	 * @param file - the current file
	 * @return - A permissions string
	 */
	public static String getPermissions(File file) {
		String perm="";
		
		if(file.canRead()) {
			perm += "r";
		}else {
			perm += "-";
		}
		
		if(file.canWrite()) {
			perm += "w";
		}else {
			perm += "-";
		}
		
		if(file.canExecute()) {
			perm += "x";
		}else {
			perm += "-";
		}
		
		return perm;
	}
}
