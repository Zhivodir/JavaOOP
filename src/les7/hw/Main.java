package les7.hw;

/**
 * Created by User on 02.11.2016.
 */
public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        Thread thread1 = new Thread(new Ship(manager, "Ambal"));
        Thread thread2 = new Thread(new Ship(manager, "Gnom"));
        Thread thread3 = new Thread(new Ship(manager, "Vagonchik"));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
