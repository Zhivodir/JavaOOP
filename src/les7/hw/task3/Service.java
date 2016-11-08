package les7.hw.task3;

/**
 * Created by User on 08.11.2016.
 */
public class Service implements Runnable{
    private String searchArea;
    private String targetOfSearch;
    private volatile String [] resultsOfSearch = new String[10];
    private int quantityOfResults = 0;
    Thread thread;

    public Service(String searchArea, String targetOfSearch) {
        this.searchArea = searchArea;
        this.targetOfSearch = targetOfSearch;
        thread = new Thread(new SearchTread(this, searchArea, targetOfSearch));
    }

    public void setResultOfSearch(String resultOfSearch) {
        this.resultsOfSearch[quantityOfResults] = resultOfSearch;
        this.quantityOfResults++;
    }

    public String[] getResultsOfSearch() {
        return resultsOfSearch;
    }

    @Override
    public void run() {
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException e){e.printStackTrace();}

        for(String str:resultsOfSearch){
            System.out.println(str);
        }
    }
}
