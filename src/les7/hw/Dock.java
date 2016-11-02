package les7.hw;

/**
 * Created by User on 02.11.2016.
 */
public class Dock{
    private boolean busy;

    public Dock() {
        this.busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy() {
        this.busy = true;
    }

    public void unloadOneBox(Ship ship){
        ship.reduceCountOfBoxes();
        busy = false;
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){e.printStackTrace();}
    }
}
