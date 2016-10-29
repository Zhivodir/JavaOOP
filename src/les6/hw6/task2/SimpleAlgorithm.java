package les6.hw6.task2;

/**
 * Created by User on 29.10.2016.
 */
public class SimpleAlgorithm {
    private static int [] mas;
    private int result = 0;

    public SimpleAlgorithm(int [] mas) {
        this.mas = mas;
    }

    public int sum(){
        for(int i = 0; i < mas.length; i++){
            result += mas[i];
        }
        return result;
    }
}
