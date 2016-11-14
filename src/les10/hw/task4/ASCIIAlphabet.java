package les10.hw.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 11.11.2016.
 */
public class ASCIIAlphabet {
    private File file;
    private Map<Character, String[]> alphabet = new HashMap<>();
    private List<String[]> onPrint = new ArrayList<>();

    public ASCIIAlphabet(File file) {
        this.file = file;
        loadAlphabetFromFile();
        alphabet.put('\u0020', new String[]{"       ","       ","       ","       ","       ","       "});
        alphabet.put('\u0009', new String[]{"       ","       ","       ","       ","       ","       "});
        //printListTest();
    }

    public void loadAlphabetFromFile(){
        String text = "";
        Character sign = null;
        String [] grafSign = new String[6];
        int i = -1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((text = br.readLine()) != null) {
                if(text.matches("[A-Z0-9]")){
                    sign = text.charAt(0);
                    i++;
                }else if(i >= 0 && i <6){
                    grafSign[i] = text;
                    i++;
                }
                if(i == 6){
                    alphabet.put(sign, grafSign);
                    i = -1;
                    grafSign = new String[6];
                }
            }
        }catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
    }

    public void prepareListForPrint(){
        System.out.println("Enter text:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        try{
            text = reader.readLine().toUpperCase();
        }catch(IOException e){e.printStackTrace();}

        char[] mas = text.toCharArray();
        for(char sign:mas){
            for (Map.Entry<Character, String[]> pair : alphabet.entrySet())
            {
                char key = pair.getKey();
                if(sign == key) {
                    onPrint.add(alphabet.get(key));
                    break;
                }
            }
        }
    }

    public void printList(){
        int quantityOfRows = onPrint.get(0).length;
        for(int numOfRows = 0; numOfRows < quantityOfRows; numOfRows++){
            for(String[] sign:onPrint){
                System.out.print(sign[numOfRows]);
            }
            System.out.println();
        }
    }

//    public void printListTest(){
//        int quantityOfRows = alphabet.get('1').length;
//        for(int numOfRows = 0; numOfRows < 6; numOfRows++){
//            for(Map.Entry<Character, String[]> pair : alphabet.entrySet()){
//                System.out.print(pair.getValue()[numOfRows]);
//            }
//            System.out.println();
//        }
//    }
}
