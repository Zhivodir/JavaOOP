package les6.hw6.task2;

import static java.lang.Thread.sleep;

/**
 * Created by User on 28.10.2016.
 */
public class SumOfArrayPart implements Runnable{
    private int startElement;
    private int endElement;
    private int numOfProc;
    private int sum = 0;
    private Service service;

    public SumOfArrayPart(Service service, int startElement, int endElement, int numOfProc) {
        this.startElement = startElement;
        this.endElement = endElement;
        this.service = service;
        this.numOfProc = numOfProc;
    }

    @Override
    public void run() {
        for(int i = startElement; i < endElement; i++){
            sum += service.getMas()[i];
        }
        service.setSumsOfArrayParts(sum, numOfProc);
    }
}
