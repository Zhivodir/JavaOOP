package les7.hw;

/**
 * Created by User on 02.11.2016.
 */
public class Manager {
    private Dock [] docks;

    public Manager() {
        super();
        Dock dock1 = new Dock();
        Dock dock2 = new Dock();
        docks = new Dock[]{dock1, dock2};
    }

    public void tryTakeDock(Ship ship) {
        int count = 0;
        for(int i = 0; i < docks.length; i++){
            if(!docks[i].isBusy()){
                docks[i].setBusy();
                docks[i].unloadOneBox(ship);
                System.out.println("Dock " + (i+1) + " unloaded box from " + ship.getName() +
                        ". Aboard: " + ship.getCountOfBoxes());
                notifyAll();
            }else{
                count++;
            }
        }
        if(count == 2){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
