package les6.hw6.task2;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Random;

/**
 * Created by User on 28.10.2016.
 */
public class Service implements Runnable{
    private int procQuantity;                 //Quantity of processes
    private static int [] mas = new int[1000];//Massiv of elements for sum
    private Thread [] summators;              //massiv of summators
    private int [] sumsOfArrayParts;          //massiv of sums of Array parts
    private int result;

    public Service() {
        super();
        Random rn = new Random();
        for(int i = 0; i < mas.length; i++){
            mas[i] = rn.nextInt(100);
        }
        procQuantity = Runtime.getRuntime().availableProcessors();
        summators = new Thread[procQuantity];
        sumsOfArrayParts = new int[procQuantity];
        for(int numOfProc = 0; numOfProc < procQuantity; numOfProc++){
            summators[numOfProc] = new Thread(
                    new SumOfArrayPart(this, numOfProc*(getMas().length/procQuantity),
                            (numOfProc+1)*(getMas().length/procQuantity), numOfProc));
        }
    }

    @Override
    public void run() {
        for(Thread thread:summators){
            thread.start();
        }
        for(Thread thread:summators){
            try {
                thread.join();
            }catch (InterruptedException e){}
        }
        for(int sum:sumsOfArrayParts){
            result += sum;
        }
        System.out.println("Sum of matrix elements equals: " + result);
    }

    public static int[] getMas() {
        return mas;
    }

    public void setSumsOfArrayParts(int sumOfArrayPart, int numOfProc) {
        this.sumsOfArrayParts[numOfProc] = sumOfArrayPart;
    }
}
