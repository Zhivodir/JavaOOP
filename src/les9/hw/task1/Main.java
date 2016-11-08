package les9.hw.task1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 08.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        new Main().demoList();
    }

    public void demoList(){
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            list.add("element" + i);
        }

        list.remove(0);
        list.remove(0);
        list.remove(list.size()-1);

        for(String element:list){
            System.out.println(element);
        }
    }
}
