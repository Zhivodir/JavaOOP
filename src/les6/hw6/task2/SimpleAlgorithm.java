package les6.hw6.task2;

/**
 * Created by User on 29.10.2016.
 */
public class SimpleAlgorithm {
    private static int [] mas;
    private int result = 0;

    public SimpleAlgorithm(ArraysClass ac) {
        this.mas = ac.getMas();
    }

    public void sum(){
        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i < mas.length; i++){
            result += mas[i];
        }
        long timeSpent2 = System.currentTimeMillis() - startTime2;
        System.out.println("Simple method: " + timeSpent2 + " millisecund");
        System.out.println("sum: " + result);
    }
}
