package les7.hw;

/**
 * Created by User on 02.11.2016.
 */
public class Ship implements Runnable {
    private String name;
    private int countOfBoxes = 10;
    Manager manager;

    public Ship(Manager manager, String name) {
        this.manager = manager;
        this.name = name;
    }

    @Override
    public void run() {
        unloadingBoxes();
    }

    public void unloadingBoxes(){
        while(countOfBoxes > 0){
            manager.tryTakeDock(this);
        }
    }

    public void reduceCountOfBoxes() {
        this.countOfBoxes--;
    }

    public int getCountOfBoxes() {
        return countOfBoxes;
    }

    public String getName() {
        return name;
    }
}
