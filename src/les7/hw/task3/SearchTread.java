package les7.hw.task3;

import java.io.File;

/**
 * Created by User on 08.11.2016.
 */
public class SearchTread implements Runnable {
    String targetOfSearch;
    String searchArea;
    File [] list;
    Service service;

    public SearchTread(Service service, String searchArea, String targetOfSearch) {
        this.service = service;
        this.targetOfSearch = targetOfSearch;
        this.searchArea = searchArea;
    }

    @Override
    public void run() {
        File catalog = new File(searchArea);
        list = catalog.listFiles();
        for(File file:list){
            String name = "";
            if(file.isDirectory()){
                name = file.getName();
                new Thread(new SearchTread(service, file.getAbsolutePath(), targetOfSearch)).start();
            }else if(file.getName().contains(".")){
                name = file.getName().substring(0, file.getName().lastIndexOf("."));
            }
            if(targetOfSearch.equals(name)){
                System.out.println("!!!");
                service.setResultOfSearch(file.getAbsolutePath());
            }
        }
        Thread.currentThread().interrupt();
    }
}
