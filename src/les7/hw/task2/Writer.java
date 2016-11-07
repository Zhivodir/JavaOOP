package les7.hw.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 03.11.2016.
 */
//public class Writer implements Runnable {
public class Writer{
    private File target;
    private ManagerOfThread manager;
    private int numPartsOfBuffers;
    private int NumPartsReadyForWrite;



    public Writer(File target, ManagerOfThread manager, int numPartsOfBuffers){
        this.target = target;
        this.manager = manager;
        this.numPartsOfBuffers = numPartsOfBuffers;
    }

//    @Override
//    public void run() {
    public void writing(){
        try (FileOutputStream fos = new FileOutputStream(target);) {
            for(int i = 0; i < 1; i++) {
                fos.write(manager.getBuffer().get(i),
                        0, manager.getBytereadList().get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
