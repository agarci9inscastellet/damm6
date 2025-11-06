
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class InOut {
    private static int count;

    public static void main(String args[])  {
        try {
            String file = "secret.bin";
            File f = new File(file);

            FileOutputStream fos;

            fos = new FileOutputStream(f); //APPEND
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(16); // 0123456789ABCDEF 10
            dos.writeChar('R');
            dos.writeChar('D');
            dos.writeChar('M');
            //dos.writeChars("FVT");
            dos.close();

            ////////////////////////////////////////////////////
            ///
           
            FileInputStream fis = new FileInputStream(f);

            int b = 0;
            String str = "";

            while (b!=-1){
                b = fis.read();
                System.out.print(b+", ");

                str += (char)b;
                if (b == 65) count++;
            }

            System.out.println("ver1: " + str);
            System.out.println("TOTAL: " +  count);
///////////////////////////////////////////////////////////////////
            fis.close();
            fis = new FileInputStream(f);
            byte[] text = new byte[100];
            fis.read(text);
            System.out.println("\n\nver2: " + new String(text));
            fis.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
