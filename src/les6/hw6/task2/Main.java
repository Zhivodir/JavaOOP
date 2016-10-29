package les6.hw6.task2;

import java.util.Random;

/**
 * Created by User on 28.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArraysClass ac = new ArraysClass();

        long startTime = System.currentTimeMillis();
        Thread thread = new Thread((new Service(ac)));
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException e){e.printStackTrace();}
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Threads method: " + timeSpent  + " millisecund");

        long startTime2 = System.currentTimeMillis();
        SimpleAlgorithm sa = new SimpleAlgorithm(ac);
        sa.sum();
        long timeSpent2 = System.currentTimeMillis() - startTime2;
        System.out.println("Simple method: " + timeSpent2 + " millisecund");
    }
}
