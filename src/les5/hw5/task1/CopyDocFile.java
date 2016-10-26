package les5.hw5.task1;

import java.io.*;

/**
 * Created by User on 26.10.2016.
 */
//This program copy files , wich have extension equals "doc" from source catalog to target catalog


public class CopyDocFile{

    public static void main(String[] args) {
        File source = new File("C://DevKit//Temp//Source");
        File target = new File("C://DevKit//Temp//Target");
        FilterForDocFile filter = new FilterForDocFile();
        File[] fileList = source.listFiles(filter);

        for (int i = 0; i < fileList.length; i++) {
            try (FileInputStream fis = new FileInputStream(fileList[i]);
                 FileOutputStream fos = new FileOutputStream(target + "/" + fileList[i].getName())) {
                byte[] buffer = new byte[1024];
                int byteread = 0;
                for (; (byteread = fis.read(buffer)) > 0;) {
                    fos.write(buffer, 0, byteread);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }
}
