package les7.hw.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by User on 03.11.2016.
 */
public class Reader implements Runnable {
    File file;
    ManagerOfThread manager;
    byte[] buffer = new byte[1024*1024];

    public Reader(File source, ManagerOfThread manager) {
        this.file = source;
        this.manager = manager;
    }

    @Override
    public void run() {
        try(FileInputStream fis = new FileInputStream(file);) {
        int byteread = 0;
        for (; (byteread = fis.read(buffer)) > 0;) {
            manager.setBuffer(buffer);
        }
    } catch (FileNotFoundException e) {
        System.out.println(e);
    }catch(IOException e){
            System.out.println(e);
        }
    }
}
