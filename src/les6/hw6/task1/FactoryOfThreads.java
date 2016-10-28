package les6.hw6.task1;

/**
 * Created by User on 28.10.2016.
 */
public class FactoryOfThreads {
    Thread [] threads = new Thread[100];

    public FactoryOfThreads() {
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new FactorialInThread(i));
        }
    }

    public void startThreads(){
        for (Thread thread:threads){
            thread.start();
        }
    }
}
