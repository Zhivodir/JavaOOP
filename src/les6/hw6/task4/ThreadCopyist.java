package les6.hw6.task4;

import java.io.*;

/**
 * Created by User on 29.10.2016.
 */
public class ThreadCopyist implements Runnable {
    private int startElement;
    private int endElement;
    private Service service;

    public ThreadCopyist(Service service, int startElement, int endElement) {
        this.startElement = startElement;
        this.endElement = endElement;
        this.service = service;
    }

    @Override
    public void run() {
        int offset = service.getPathToStartDirectory().length();
        for(int i = startElement; i < endElement; i++){
            String relativePath = service.getList()[i].getAbsolutePath().substring(offset);
            String insuranceAgainstMistakes = relativePath.substring(0, relativePath.lastIndexOf("\\"));
            try {

                if(!service.getList()[i].getName().contains(".")){
                    new File(service.getDirectoryToWrite()  + "/" + relativePath).mkdir();
                }else{
                    new File(service.getDirectoryToWrite()  + insuranceAgainstMistakes).mkdir();
                    copyFile(service.getList()[i],
                            new File(service.getDirectoryToWrite()  + "/" + relativePath));
                }
            }
            catch (IOException e){e.printStackTrace();}
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
