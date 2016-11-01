package les6.hw6.task3;

import les6.hw6.task2.*;

/**
 * Created by User on 31.10.2016.
 */
public class ShellSortThread implements Runnable {
    private int startElement;
    private int endElement;
    private int numOfProc;
    private Service service;
    private int sizeOfArray;

    public ShellSortThread(Service service, int startElement, int endElement, int numOfProc) {
        this.startElement = startElement;
        this.endElement = endElement;
        this.service = service;
        this.numOfProc = numOfProc;
        this.sizeOfArray = endElement - startElement;
    }

    @Override
    public void run() {
        int step = sizeOfArray / 2;
        while (step > 0){
            for (int i = startElement; i < (endElement - step); i++){
                int j = i;
                while (j >= 0 && service.getArray()[j] > service.getArray()[j + step])
                {
                    int temp = service.getArray()[j];
                    service.getArray()[j] = service.getArray()[j + step];
                    service.getArray()[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;
        }
    }
}
