package les9.hw.task4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by User on 09.11.2016.
 */
public class QueueForCola {
    int numGlasses;
    private Queue<Person> queue = new LinkedList<Person>();

    public QueueForCola(int numGlasses) {
        this.numGlasses = numGlasses;
        queue.add(new Person("Sheldon"));
        queue.add(new Person("Leonard"));
        queue.add(new Person("Volovitc"));
        queue.add(new Person("Kutrapalli"));
        queue.add(new Person("Penny"));
    }

    public void distributeGlasses(){
        for(int i = 0; i < numGlasses; i++){
            Person clone = queue.remove();
            queue.add(clone);
            queue.add(clone);
        }
    }

    public void showQueue(){
        System.out.println(queue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("Queue: " + "{" + System.lineSeparator());
        for (Person p:queue) {
            if(p != null) {
                sb.append("  " + p.toString() + System.lineSeparator());
            }
        }
        sb.append("}");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
