package les10.hw.task3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 11.11.2016.
 */
public class CounterOfElements {
    //Massiv zapolnen testovimi dannimi
    Object [] variousObjectList =
            new Object[]{9, "test" , 9,
            new Cat("Vasya", "brown", 21),
            new Cat("Vasya", "brown", 21),
            new Cat("Vasya", "brown", 21),
            3.0, "test"};
    Map<Object, Integer> map = new HashMap<>();

    public CounterOfElements() {
    }

    public void countRepeatingElement(){
        for(Object obj1 : variousObjectList){
            if(map.containsKey(obj1)) {
                map.put(obj1, map.get(obj1) + 1);
            }else{
                map.put(obj1, 1);
            }
        }
    }

    public void showResult(){
        for(Map.Entry<Object, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
