package exercicis;

import java.io.*;
import java.util.Scanner;

public class SaveText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("usertext.txt");

        try (FileOutputStream newFile = new FileOutputStream(file)) {
            String input;
            while (true) {
                System.out.print("Escriu una línia de text (o 'quit' per sortir): ");
                input = scanner.nextLine();
                if ("quit".equals(input) || "QUIT".equals(input)) {
                    break;
                }
                newFile.write((input + "\n").getBytes());
            }
        } catch (IOException e) {
            System.err.println("Error d'escriptura: " + e.getMessage());
        }

        System.out.println("Contingut de usertext.txt:");
        try (FileInputStream readFile = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(readFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e);
        }
    }
}