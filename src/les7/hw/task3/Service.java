package les7.hw.task3;

/**
 * Created by User on 08.11.2016.
 */
public class Service implements Runnable{
    private String searchArea;
    private String targetOfSearch;
    Thread thread;

    public Service(String searchArea, String targetOfSearch) {
        this.searchArea = searchArea;
        this.targetOfSearch = targetOfSearch;
        thread = new Thread(new SearchTread(this, searchArea, targetOfSearch));
    }


    @Override
    public void run() {
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException e){e.printStackTrace();}
    }
}
