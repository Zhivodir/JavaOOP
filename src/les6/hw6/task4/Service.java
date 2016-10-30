package les6.hw6.task4;

import java.io.File;

/**
 * Created by User on 29.10.2016.
 */
public class Service implements Runnable {
    private static File[] list;
    private int procQuantity;
    private Thread [] copyists;
    private String directoryToWrite;
    private String pathToStartDirectory;

    public Service(ContentOfDirectory cod) {
        this.list = cod.getList();

        this.procQuantity = Runtime.getRuntime().availableProcessors();
        this.copyists = new Thread[procQuantity];
        this.directoryToWrite = cod.getDirectoryToWrite();
        this.pathToStartDirectory = cod.getPathToStartDirectory();

        for(int numOfProc = 0; numOfProc < procQuantity; numOfProc++){
            int startElement = numOfProc*(getList().length/procQuantity);
            int endElement = (numOfProc+1)*(getList().length/procQuantity);
            copyists[numOfProc] = new Thread(new ThreadCopyist(this, startElement, endElement));
        }
    }

    @Override
    public void run() {
        directoryToWrite = this.getDirectoryToWrite() + pathToStartDirectory.substring(pathToStartDirectory.lastIndexOf("\\"));
        new File(directoryToWrite).mkdir();
        for(Thread thread:copyists){
            thread.start();
        }
        for(Thread thread:copyists){
            try {
                thread.join();
            }catch (InterruptedException e){}
        }
    }

    public static File[] getList() {
        return list;
    }

    public String getDirectoryToWrite() {
        return directoryToWrite;
    }

    public String getPathToStartDirectory() {
        return pathToStartDirectory;
    }
}
