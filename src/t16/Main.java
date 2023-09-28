package t16;

import java.io.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        copyFile("C:\\Temp\\UninstalItems.log");

    }

    public static void copyFile(String path){
        String extension=path.substring(path.indexOf(".")+1);
        String pathName=path.substring(0,path.indexOf("."));
        String suffices="This is copy";

        InputStream inStream;
        OutputStream outStream;

        try {
            File sourceFile = new File(path);
            File destFile = new File(pathName+suffices + "."+extension);

            inStream = new FileInputStream(sourceFile);
            outStream = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inStream.read(buffer)) != -1){
                outStream.write(buffer, 0, length);
            }



            System.out.println("File is copied successful!");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
