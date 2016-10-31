package les6.hw6.task5;

/**
 * Created by User on 31.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Thread observer = new Thread(new Observer("C:/DevKit/Temp"));
        observer.start();
        try {
            observer.join();
        }catch (InterruptedException e){e.printStackTrace();}
    }
}
