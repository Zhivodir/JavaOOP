package les7.hw.task3;

/**
 * Created by User on 08.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Service("c:/DevKit", "Java OOP (All cource)"));
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException e){e.printStackTrace();}
    }
}
