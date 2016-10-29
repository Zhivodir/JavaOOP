package les6.hw6.task2;

/**
 * Created by User on 28.10.2016.
 */
public class Service implements Runnable{
    private int procQuantity;                 //Quantity of processes
    private static int [] mas;                //Massiv of elements for sum
    private Thread [] summators;              //massiv of summators
    private int [] sumsOfArrayParts;          //massiv of sums of Array parts
    private int result;

    public Service(ArraysClass ac) {
        super();
        this.mas = ac.getMas();
        this.procQuantity = Runtime.getRuntime().availableProcessors();
        this.summators = new Thread[procQuantity];
        this.sumsOfArrayParts = new int[procQuantity];
        for(int numOfProc = 0; numOfProc < procQuantity; numOfProc++){
            int startElement = numOfProc*(getMas().length/procQuantity);
            int endElement = (numOfProc+1)*(getMas().length/procQuantity);
            summators[numOfProc] = new Thread(new SumOfArrayPart(this, startElement, endElement, numOfProc));
        }
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
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
