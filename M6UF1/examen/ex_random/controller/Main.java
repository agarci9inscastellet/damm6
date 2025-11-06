package controller;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {

	System.err.println(dataActual());

	        try (RandomAccessFile fitxer = new RandomAccessFile("dades.bin", "rw")) {
								fitxer.seek(0); // Move to the beginning of the file
		 	fitxer.writeInt(101);

			// 				fitxer.seek(38); // Move to the beginning of the file
		 	// fitxer.writeInt(102);



		 String acceleracio = "Lenovo 400e";
		 acceleracio = buildFixedSizeString(acceleracio, 15);	
		 fitxer.writeChars(acceleracio);
		fitxer.writeFloat(2545.5F);

		 	fitxer.writeInt(102);
		 acceleracio = "HP Stellite 5";
		 acceleracio = buildFixedSizeString(acceleracio, 15);	
		 fitxer.writeChars(acceleracio);
		fitxer.writeFloat(1433.3F);



		 fitxer.close();
		} catch (IOException e) {
			System.err.println(e);
		}






		// byte edat = 1;
		// float pi = 2545.5F;
		// String acceleracio = "Lenovo 300e";
		// byte edat = 2;
		// float pi = 1433.3F;
		// String acceleracio = "HP Stellite 5";
		// acceleracio = buildFixedSizeString(acceleracio, 15);

		// try (DataOutputStream escriptor = new DataOutputStream(new FileOutputStream("dades.bin",true));) {
		// 	escriptor.writeInt(edat);
        //     escriptor.writeChars(acceleracio);
		// 	escriptor.writeFloat(pi);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a code to search: ");
        int userCode = sc.nextInt();

        boolean found = false;

        try (DataInputStream dis = new DataInputStream(new FileInputStream("dades.bin"))) {
            while (true) {
                try {
                    int code = dis.readInt();
                    StringBuilder nom = new StringBuilder();
                    for (int i = 0; i < 15; i++) {
                        nom.append(dis.readChar());
                    }
                    float preu = dis.readFloat();

					if (code == userCode) {
						System.out.println("Code: " + code);
						System.out.println("Name: " + nom.toString().trim());
						System.out.println("Price: " + preu);
						found = true;
						break;
					}


		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
			}
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
	}

	    public static String buildFixedSizeString(String text, int size) {
        StringBuilder sb = new StringBuilder(size);
        sb.append(text);
        
        while (sb.length() < size) {
            sb.append(' ');
        }
        if (sb.length() > size) {
            sb.setLength(size);
        }

        return sb.toString();
    }

	public static String dataActual() {
        LocalDate today = LocalDate.now();
        return today.toString();
}


		}
