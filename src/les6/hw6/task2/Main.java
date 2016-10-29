package les6.hw6.task2;

import java.util.Random;

/**
 * Created by User on 28.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArraysClass ac = new ArraysClass();

        Thread thread = new Thread((new Service(ac)));
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException e){e.printStackTrace();}

        SimpleAlgorithm sa = new SimpleAlgorithm(ac);
        sa.sum();
    }
}
