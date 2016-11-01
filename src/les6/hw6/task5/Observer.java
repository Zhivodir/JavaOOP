package les6.hw6.task5;

import java.io.File;

/**
 * Created by User on 31.10.2016.
 */
public class Observer implements Runnable {
    private String observableCatalog;
    private int startQuantityOfFiles;

    public Observer(String observableCatalog) {
        this.observableCatalog = observableCatalog;
        this.startQuantityOfFiles = countNumberFiles(new File(observableCatalog), 0);
    }

    @Override
    public void run() {
        File folder = new File(observableCatalog);
        folder.mkdir();
        while(true){
            try {
                Thread.currentThread().sleep(1000);
            }catch (InterruptedException e){e.printStackTrace();}
            int quantityOfFile = countNumberFiles(folder, 0);
            //System.out.println(quantityOfFile);
            if(quantityOfFile > startQuantityOfFiles){
                System.out.println("Added " + (quantityOfFile - startQuantityOfFiles) + " files");
            }else if(quantityOfFile < startQuantityOfFiles){
                System.out.println("Deleted " + (startQuantityOfFiles - quantityOfFile) + " files");
            }
            startQuantityOfFiles = quantityOfFile;
        }
    }

    public int countNumberFiles(File folder, int quantityOfFile){
        for(File file : folder.listFiles()){
            if(file.isDirectory() && file.listFiles().length != 0){
                quantityOfFile = countNumberFiles(file, quantityOfFile);
            }
            quantityOfFile++;
        }
        return quantityOfFile;
    }
}
