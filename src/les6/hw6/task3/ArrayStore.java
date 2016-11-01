package les6.hw6.task3;

import java.util.Random;

/**
 * Created by User on 31.10.2016.
 */
public class ArrayStore {
    int [] mas = new int[100000];

    public ArrayStore() {
        Random rn = new Random();
        for(int i = 0; i < mas.length; i++){
            mas[i] = rn.nextInt(10000);
        }
    }

    public int[] getMas() {
        return mas;
    }
}
