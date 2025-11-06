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

public class Main {
    private static int count;

    public static void main(String args[])  {
        String file = "text.txt";

        File f = new File(file);
        try{
        FileOutputStream fos = new FileOutputStream(f);

        fos.write("HOLA ALUMNES".getBytes());
        fos.write("\n".getBytes());

            String t = "Sóm a classe: çñâ";
            for (char c:t.toCharArray()){
                fos.write(c);
            }

        fos.close();

///////////////////////////////////////////////////
/// 
            FileInputStream fis = new FileInputStream(f);
            
            int b=0;
            //byte[] b = new byte[100];
            while (b!=-1){
                b = fis.read();

              if (b!=-1)  System.out.print((char)b);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    }

