package textFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * Exercise 2. Simple version of grep
 * Make a program that receives for parameter a text string and a file and that display only those lines of the file that contain the string.
 * */
/**
 * Grep simple version program
 * @author Yarií Soto
 * @version v1, 27 October 2023
 */
public class Grep {
	public static void main(String[] args) {
		if (args.length > 1) {
			System.out.println("This program is a grep simple version\n");
			
			String text = args[0];
			Path file= Path.of(args[1]);
			
			// I am testing programming with a functional approach
			if(Files.exists(file) && Files.isReadable(file)) {
				try {
					Files.lines(file)
						// Apply a filter
						.filter(line -> line.contains(text))
						// Print lines
						.forEach(System.out::println);
					
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
				
			}else {
				System.out.println("The second argument must be a file.");
			}
		}else {
			System.out.println("Insufficient arguments");
		}
	}
}
