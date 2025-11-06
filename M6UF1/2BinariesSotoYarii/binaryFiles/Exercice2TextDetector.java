package binaryFiles;

import java.io.File;
import java.io.FileInputStream;

/*
 * Exercise 2. Text detector.
 * Make a program that receives as a parameter one or more file names and that, for a each of them, 
 * show on the screen only those parts that are text, skipping the binary parts.
 * 
 * It uses Character methods for simple detection of what text i is no.
 * An error in a file should not interrupt the program, it should jump in the following file.
 * */
/**
 * 
 * @author Yarií Soto
 * @version v1, 23 October 2023
 *
 */
public class Exercice2TextDetector {
	public static void main(String[] args) {
		//If the user introduce an arguments
		if (args.length > 0) {
			//Create an File array
			File[] files = new File[args.length];
			
			System.out.println("This program receives as a parameter one or more file names and that, for a each of them, \n"
					+ "show on the screen only those parts that are text, skipping the binary parts.\n");
			
			//Create a File element with each argument
			for (int i=0; i<files.length;i++) {
				files[i] = new File(args[i]);
			}
			
			//Print numbers
			for (int i=0; i<files.length;i++) {
				
				try {
					//
					FileInputStream fis = new FileInputStream(files[i]);
					int nextInt=fis.read();
					
					while (nextInt != -1) {
						char nextChar = (char) nextInt;
						if(Character.isAlphabetic(nextInt)) {
							System.out.print(nextChar);
						}
						nextInt = fis.read();
					}
					
					fis.close();
				} catch (Exception e) {
					
				}
				System.out.println();
			}
		}else {
			System.out.println("No arguments entered");
		}
	}
}
