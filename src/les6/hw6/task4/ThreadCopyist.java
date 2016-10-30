package les6.hw6.task4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 29.10.2016.
 */
public class ThreadCopyist implements Runnable {
    private int startElement;
    private int endElement;
    private int numOfProc;
    private Service service;

    public ThreadCopyist(Service service, int startElement, int endElement, int numOfProc) {
        this.startElement = startElement;
        this.endElement = endElement;
        this.service = service;
    }

    @Override
    public void run() {
        int offset = service.getPathToStartDirectory().length();
        for(int i = startElement; i < endElement; i++){
            try {
                System.out.println(service.getDirectoryToWrite()  + "/" + service.getList()[i].getAbsolutePath().substring(offset));
                if(!service.getList()[i].getName().contains(".")){
                    new File(service.getDirectoryToWrite()  + "/" + service.getList()[i].getAbsolutePath().substring(offset)).mkdir();
                }else{
                    copyFile(service.getList()[i],
                            new File(service.getDirectoryToWrite()  + "/" + service.getList()[i].getAbsolutePath().substring(offset)));
                }
            }catch (IOException e){e.printStackTrace();}
        }
    }

    public static void copyFile(File in, File out) throws IOException {
        try(FileInputStream fis = new FileInputStream(in);
            FileOutputStream fos = new FileOutputStream(out)){
            byte [] bufferArray = new byte[1024*100];
            int n = 0;

            for(;(n = fis.read(bufferArray)) > 0;){
                fos.write(bufferArray, 0, n);
            }
        } catch (IOException e){
            throw e;
        }
    }
}
