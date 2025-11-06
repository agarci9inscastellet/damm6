package operationsOnFiles;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * Exercise 3. Simple version of the cp
 * 
 * Write a program that receives as parameters the name of a file and the name of a
 * directory and copy the file into the directory.
 * 
 * Hint: Use the Files.copy method.
 * */
/**
 * 
 * @author Yarií Soto
 * @version v1, 13 October 2023
 */
public class Exercice3Cp {
	/**
	 * Main method
	 * @param args - user arguments
	 */
	public static void main(String[] args) {
		if (args.length >= 1) {
			//Print a program explanation
			System.out.println("This program is a cp simple version.");
			
			try {
				//Create a File System
				FileSystem filSys=FileSystems.getDefault();
				
				//Obtain the path
				Path fileName=filSys.getPath(args[0]);
				Path dirName=filSys.getPath(args[1]);
				
				//Copy the file
				Files.copy(fileName, dirName.resolve(fileName.getFileName()));
				
				System.out.println("File has been successfully copied.");
				
			}catch(UnsupportedOperationException e) {
				System.out.println(e.getMessage());
			}catch(FileAlreadyExistsException e) {
				System.out.println(e.getMessage());
			}catch(DirectoryNotEmptyException e) {
				System.out.println(e.getMessage());
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("No arguments entered");
		}
	}
}
