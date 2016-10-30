package les6.hw6.task4;

import java.io.File;

/**
 * Created by User on 29.10.2016.
 */
public class ContentOfDirectory {
    private String directoryToWrite;
    private String pathToStartDirectory;
    private int quantityOfFile = 0;
    private int numOfCurrentFile = 0;
    private File[] list;

    public ContentOfDirectory(String pathToStartDirectory, String directoryToWrite) {
        this.directoryToWrite = directoryToWrite;
        this.pathToStartDirectory = pathToStartDirectory;
        File folder = new File(pathToStartDirectory);
        countNumberFiles(folder);
        this.list = new File[quantityOfFile];
        makeListOfFiles(folder, numOfCurrentFile);
    }

    public File[] getList() {
        return list;
    }

    public String getDirectoryToWrite() {
        return directoryToWrite;
    }

    public String getPathToStartDirectory() {
        return pathToStartDirectory;
    }

    public void countNumberFiles(File folder){
        for(File file : folder.listFiles()){
            if(file.isDirectory() && file.listFiles().length != 0){
                countNumberFiles(file);
            }
            quantityOfFile++;
        }
    }

    public void makeListOfFiles(File folder, int numOfCurrentFile){
        for(File file : folder.listFiles()){
            if(file.isDirectory() && file.listFiles().length != 0){
                list[numOfCurrentFile] = file;
                numOfCurrentFile++;
                makeListOfFiles(file, numOfCurrentFile);
            }else {
                if(list[numOfCurrentFile] == null){
                    list[numOfCurrentFile] = file;
                    numOfCurrentFile++;
                }else{
                    numOfCurrentFile++;
                    list[numOfCurrentFile] = file;
                }
            }
        }
    }
}
