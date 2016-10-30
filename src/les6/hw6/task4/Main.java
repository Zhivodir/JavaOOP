package les6.hw6.task4;


/**
 * Created by User on 29.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        ContentOfDirectory cod = new ContentOfDirectory("C:\\DevKit\\Project\\OrdersMaker",
                "C:\\DevKit\\Temp");
        Thread thread = new Thread(new Service(cod));
        thread.start();
        try{
            thread.join();
        }catch (InterruptedException e){e.printStackTrace();}
    }
}
