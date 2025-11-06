package binaryFiles;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * Exercise 1. Generate secret
 * 
 * In this program, a binary file will be generated that will contain a series of code-secret pairs. 
 * 
 * - The code is an integer and the secret is a string of 3 characters
 * - The file will be sorted from smallest to largest by the codes.
 * 
 * - To generate the file, proceed as follows: 
 * - the first code will be one random number between 1 and 3.
 * - Each of the following codes will be like the previous one adding an amount between 1 and 3.
 * - The secrets will be combinations of three letters taken at random from the set of lowercase letters.
 * - The program will generate a total of 1000 code-secret pairs.
 * 
 * Note: to save the strings use writeChars and not writeUTF, since the length of a UTF string is variable.
 * */
/**
 * 
 * @author Yarií Soto
 * @version v1, 13 October 2023
 *
 */
public class Exercice1Secret {
	public static void main(String[] args) {
		final int TOTAL_PAIRS=10;
		//Create the codes, secrets and pairs arrays
		int[] codes= new int[TOTAL_PAIRS];
		String secrets[]= new String[TOTAL_PAIRS];
		int currentCode=0;
		
		//Print a program explanation
		System.out.println("This program generates a binary file that will contain a series of code-secret pairs.");
		
		//Generate codes
		for(int i=0;i<codes.length;i++) {
			//Get a code
			int code = (int)Math.floor(Math.random()*3+1);
			
			//Save the current code + code
			codes[i]=currentCode+code;
			
			//Add to currentCode the code
			currentCode+=code;
		}
		
		//Generate secrets
		for(int i=0;i<secrets.length;i++) {
			//Save the current code + code
			secrets[i]=getSecret();
		}
		
		try {
			File f = new File("secret.bin");
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			
			//Write binary file
			for (int i=0;i<codes.length;i++) {
				//System.out.print(codes[i]);
				dos.writeInt(codes[i]);
				//System.out.println(secrets[i]);
				dos.writeChars(secrets[i]);
			}
			
			fos.close();
			dos.close();
			
			System.out.println("The file was successfully created");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		readAndPrintSecrets(new File("secret.bin"));
	}

	/**
	 * Reads and prints code-secret pairs from the given file.
	 */
	public static void readAndPrintSecrets(File f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			while (true) {
				try {
					int n = dis.readInt();
					char[] secret = new char[3];
					for (int i = 0; i < 3; i++) {
						secret[i] = disreadChar();
					}
					System.out.println(n + " " + new String(secret));
				} catch (IOException e) {
					break; // End of file reached
				}
			}
			dis.close();
			fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to get a secret
	 * 
	 * @return - a 3 chars String
	 */
	public static String getSecret() {
		final int MIN_NUM = 97;
		final int MAX_NUM = 122;

		String secret = "";

		// Generate a secret
		for (int i = 0; i < 3; i++) {
			secret += (char) (int) (Math.floor(Math.random() * (MAX_NUM - MIN_NUM + 1) + MIN_NUM));
		}

		return secret;
	}

}
