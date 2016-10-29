package les6.hw6.task2;

import java.util.Random;

/**
 * Created by User on 28.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int [] mas = new int[1000];
        Random rn = new Random();
        for(int i = 0; i < mas.length; i++){
            mas[i] = rn.nextInt(100);
        }
        Thread thread = new Thread((new Service()));
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException e){e.printStackTrace();}
        System.out.println("Main process STOP!");
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }
}
