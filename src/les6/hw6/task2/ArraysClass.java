package les6.hw6.task2;

import java.util.Random;

/**
 * Created by User on 29.10.2016.
 */
public class ArraysClass {
    int [] mas = new int[100000000];

    public ArraysClass() {
        Random rn = new Random();
        for(int i = 0; i < mas.length; i++){
            mas[i] = rn.nextInt(100);
        }
    }

    public int[] getMas() {
        return mas;
    }

    public void setMas(int[] mas) {
        this.mas = mas;
    }
}
