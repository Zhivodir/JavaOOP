package les6.hw6.task3;

/**
 * Created by User on 31.10.2016.
 */
public class WithoutThread {
    private int [] array;
    private int sizeOfArray;

    public WithoutThread(ArrayStore arrayStore) {
        this.array = arrayStore.getMas();
        this.sizeOfArray = arrayStore.getMas().length;

    }

    public void shellSort(){
        int step = sizeOfArray / 2;
        while (step > 0)
        {
            for (int i = 0; i < (sizeOfArray - step); i++)
            {
                int j = i;
                while (j >= 0 && array[j] > array[j + step])
                {
                    int temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;//уменьшаем шаг
        }
    }
}
