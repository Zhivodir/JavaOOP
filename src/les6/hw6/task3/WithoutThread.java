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
        int step = sizeOfArray / 2;//инициализируем шаг.
        while (step > 0)//пока шаг не 0
        {
            for (int i = 0; i < (sizeOfArray - step); i++)
            {
                int j = i;
                //будем идти начиная с i-го элемента
                while (j >= 0 && array[j] > array[j + step])
                //пока не пришли к началу массива
                //и пока рассматриваемый элемент больше
                //чем элемент находящийся на расстоянии шага
                {
                    //меняем их местами
                    int temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;//уменьшаем шаг
        }
        // Выводим отсортированный массив
//        for (int i = 0; i < sizeOfArray; i++) {
//            System.out.println((array[i] + " "));
//        }
    }
}
