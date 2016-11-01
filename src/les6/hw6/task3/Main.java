package les6.hw6.task3;

/**
 * Created by User on 31.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayStore arrayStore = new ArrayStore();

        long startTime1 = System.currentTimeMillis();
        WithoutThread wt = new WithoutThread(arrayStore);
        wt.shellSort();
        long timeSpent1 = System.currentTimeMillis() - startTime1;
        System.out.println("Withoutthreads: " + timeSpent1  + " millisecund");

        long startTime2 = System.currentTimeMillis();
        Thread thread = new Thread(new Service(arrayStore));
        thread.start();
        long timeSpent2 = System.currentTimeMillis() - startTime2;
        System.out.println("Threads: " + timeSpent2  + " millisecund");
    }
}
