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
    //total of parts of blocks
    private int numPartsOfBuffers;
    //quantity of blocks , which are ready for write
    private int NumPartsReadyForWrite = 0;
    //quantity of already writed blocks
    private int numOfAlreadyWrited = 0;
    //blocks in this list are ready to write
    private List<byte[]> generalBuffer = new ArrayList<>();
    //quantity of bytes in buffers blocks
    private List<Integer> byteReadList = new ArrayList<>();
    //private boolean waitFlag;
    private boolean endOfFile = false;

    Thread reader;
    Thread writer;

    public ManagerOfThread(String sourcePath, String targetPath){
        source = new File(sourcePath);
        target = new File(targetPath + "/" + sourcePath.substring(sourcePath.lastIndexOf("/")));

        numPartsOfBuffers = (int)source.length()/(1024*1024);
        if(source.length()%(1024*1024) > 0){
            numPartsOfBuffers = numPartsOfBuffers + 1;
        }
        reader = new Thread(new Reader(source, this));
        writer = new Thread(new Writer(target, this, numPartsOfBuffers));
    }

    public synchronized void copyFile() {
        reader.start();
        writer.start();
    }

    public List<byte[]> getBuffer() {
        return generalBuffer;
    }

    public void addBuffer(byte[] buffer) {
        this.generalBuffer.add(buffer);
    }

    public List<Integer> getByteReadList() {
        return byteReadList;
    }

    public void addByteReadList(int byteread) {
        this.byteReadList.add(byteread);
    }
}
