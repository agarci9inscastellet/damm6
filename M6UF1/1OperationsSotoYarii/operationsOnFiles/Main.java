import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tinc un paràmetre: ");

        String f = args[0];
        File path = new File(f);

        File[] files = path.listFiles();

        for (File file : files) {
            System.out.println(file.getName());
        }


    }
}
