package les9.hw.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 09.11.2016.
 */
public class CountOfAlphabet {
    private String sourceFile;
    private List<Bukva> alphabet = new ArrayList<>();
    private int lengthOfText = 0;


    public CountOfAlphabet(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void readFromFile(){
        try {
            FileReader fr = new FileReader(sourceFile);
            String str = "";
            char[] masFromStr;
            while(fr.ready()){
                str += (char)fr.read();
            }
            masFromStr = str.toLowerCase().replaceAll("[^a-zA-Z]","").toCharArray();
            lengthOfText = masFromStr.length;

            for(char bukva:masFromStr){
                int index = isBukvaInList(bukva);
                if(index == -1){
                    alphabet.add(new Bukva(bukva));
                }else{
                    alphabet.get(index).setCount();
                }
            }


        }catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }

    public int isBukvaInList(char bukva){
        for (int i = 0; i < alphabet.size(); i++){
            if(alphabet.get(i).getName() == bukva){
                return i;
            }
        }
        return -1;
    }

    public void calculateRelativeFrequencies(){
        for(Bukva b:alphabet){
            b.setRelativeFrequency(b.getCount()*1.0/lengthOfText);
        }
    }

    public void showList(){
        calculateRelativeFrequencies();
        Collections.sort(alphabet, new Comparator<Bukva>() {
            public int compare(Bukva bukva1, Bukva bukva2) {
                if(bukva1.getRelativeFrequency() > bukva2.getRelativeFrequency()){
                    return -1;
                }else if(bukva1.getRelativeFrequency() < bukva2.getRelativeFrequency()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(Bukva b:alphabet){
            System.out.println(b);
        }
    }
}
