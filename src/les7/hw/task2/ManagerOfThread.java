package les7.hw.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.11.2016.
 */
public class ManagerOfThread {
    private File source;
    private File target;
    private int numPartsOfBuffers;
    private int NumPartsReadyForWrite;
    private List<byte[]> generalBuffer = new ArrayList<>();
    private int [] bytereadLength;
    private boolean waitFlag;

    public ManagerOfThread(String sourcePath, String targetPath){
        source = new File(sourcePath);
        target = new File(targetPath + "/" + sourcePath.substring(sourcePath.lastIndexOf("/")));

        numPartsOfBuffers = (int)source.length()/1024*1024;
        waitFlag = true;
        Thread reader = new Thread(new Reader(source, this));
        Thread writer = new Thread(new Writer(target, this, numPartsOfBuffers));
        reader.start();
        writer.start();
    }

    public List<byte[]> getBuffer() {
        return generalBuffer;
    }

    public void setBuffer(byte[] buffer) {
        this.generalBuffer.add(buffer);
    }

    public boolean isWaitFlag() {
        return waitFlag;
    }

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    public int getNumPartsReadyForWrite() {
        return NumPartsReadyForWrite;
    }

    public void setNumPartsReadyForWrite(int numPartsReadyForWrite) {
        NumPartsReadyForWrite = numPartsReadyForWrite;
    }

    public int getNumPartsOfBuffers() {
        return numPartsOfBuffers;
    }
}
