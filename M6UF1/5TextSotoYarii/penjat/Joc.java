package penjat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Joc {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";


    public static void main(String[] args) {
        
    

        System.out.println("Benvingut al joc del penjat!");

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("users.dat")));

            User usr = new User("alex", "1234");
            oos.writeObject(usr);

            System.out.println("Usuari creat: " + usr.nom);
            usr = new User("pepe", "1234");
            oos.writeObject(usr);

            System.out.println("Usuari creat: " + usr.nom);
            usr = new User("toto", "1234");
            oos.writeObject(usr);

            System.out.println("Usuari creat: " + usr.nom);

            oos.writeObject(usr);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("users.dat")));

            User u = (User) ois.readObject();
            System.out.println(u.nom);
            // .println("Usuari llegit: " + u.nom);
            u = (User) ois.readObject();
            u = (User) ois.readObject();
            System.out.println(u.nom);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
