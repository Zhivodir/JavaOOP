package les6.hw6.task3;

/**
 * Created by User on 31.10.2016.
 */
public class Service implements Runnable {
    private int [] array;
    private int quantityOfProcesses;
    private Thread [] sortThreads;

    public Service(ArrayStore arrayStore) {
        this.array = arrayStore.getMas();
        this.quantityOfProcesses = Runtime.getRuntime().availableProcessors();
        sortThreads = new Thread[quantityOfProcesses];
        for(int numOfProc = 0; numOfProc < quantityOfProcesses; numOfProc++){
            int startElement = numOfProc*(array.length/quantityOfProcesses);
            int endElement = (numOfProc+1)*(array.length/quantityOfProcesses);
            sortThreads[numOfProc] = new Thread(new ShellSortThread(this, startElement, endElement, numOfProc));
        }
    }

    @Override
    public void run() {
        for(Thread thread:sortThreads){
            thread.start();
        }
        for(Thread thread:sortThreads){
            try {
                thread.join();
            }catch(InterruptedException e){e.printStackTrace();}
        }
        lastSort();
//        for(int f:array){
//            System.out.println(f);
//        }
    }

    public int[] getArray() {
        return array;
    }

    public void lastSort(){
        int step = array.length / 2;
        while (step > 0){
            for (int i = 0; i < (array.length - step); i++){
                int j = i;
                while (j >= 0 && array[j] > array[j + step])
                {
                    int temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;
        }
    }
}
