package les11.hw.task3;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 16.11.2016.
 */
public class AllReferences {
    String adress;
    String htmlDocument;
    String links;
    String pathForSave = "c:/DevKit/Temp/Target/result.txt";

    public AllReferences(String adress) {
        this.adress = adress;
        getHtmlDocument();
        getAllReferences();
        writeToFile();
    }

    public void getHtmlDocument(){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(adress);
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String text = "";
            for(;(text = br.readLine()) != null;){
                sb.append(text);
                sb.append(System.lineSeparator());
            }
        }catch(MalformedURLException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        htmlDocument = sb.toString();
    }

    public void getAllReferences(){
        StringBuilder sb = new StringBuilder();
        String TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
        String LINK_PATTERN = "\\s*(?i)href\\s*=\\s*(\\\"([^\"]*\\\")|'[^']*'|([^'\">\\s]+))";

        Pattern tagPattern = Pattern.compile(TAG_PATTERN);
        Pattern linkPattern = Pattern.compile(LINK_PATTERN);
        Matcher tagMatcher = tagPattern.matcher(htmlDocument);
        while(tagMatcher.find()) {
            String aTag = tagMatcher.group();
            Matcher linkMatcher = linkPattern.matcher(aTag);

            if(linkMatcher.find()) {
                String link = linkMatcher.group(1);
                sb.append(link.substring(1, link.length() - 1).trim());
                sb.append(System.lineSeparator());
            }
        }
        links = sb.toString();
    }

    public void writeToFile(){
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathForSave),"UTF-8"));
        ){
            out.write(links);
        }catch (IOException e){e.printStackTrace();}
    }
}
