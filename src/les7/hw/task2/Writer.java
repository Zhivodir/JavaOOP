package les7.hw.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 03.11.2016.
 */
public class Writer implements Runnable {
    private File target;
    private ManagerOfThread manager;
    private int numPartsOfBuffers;
    private int NumPartsReadyForWrite;



    public Writer(File target, ManagerOfThread manager, int numPartsOfBuffers){
        this.target = target;
        this.manager = manager;
        this.numPartsOfBuffers = numPartsOfBuffers;
    }

    @Override
    public void run() {
        try (FileOutputStream fos = new FileOutputStream(target);) {
            int currentBuf = 0;
            while(true) {
                if (manager.isWaitFlag()) {
                    fos.write(manager.getBuffer().get(currentBuf),
                            0, manager.getBytereadList().get(currentBuf));
                }
                if(currentBuf == numPartsOfBuffers){break;}

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
