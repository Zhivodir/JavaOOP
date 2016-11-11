package les10.hw.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 11.11.2016.
 */
public class ASCIIAlphabet {
    Map<Character, String[]> alphabet = new HashMap<>();
    List<String[]> onPrint = new ArrayList<>();

    public ASCIIAlphabet() {
        alphabet.put('A', new String[]{"  **   "," *  *  ","*    * ","****** ","*    * ","*    * "});
        alphabet.put('B', new String[]{"*****  ","*    * ","*****  ","*****  ","*    * ","*****  "});
        alphabet.put('C', new String[]{"  **** "," *     ","*      ","*      "," *     ","  **** "});
        alphabet.put('E', new String[]{"****** ","*      ","****   ","*      ","*      ","****** "});
        alphabet.put('L', new String[]{"*      ","*      ","*      ","*      ","*      ","****** "});
        alphabet.put('M', new String[]{"*    * ","**  ** ","* ** * ","*    * ","*    * ","*    * "});
        alphabet.put('P', new String[]{"*****  ","*    * ","*    * ","*****  ","*      ","*      "});
        alphabet.put('X', new String[]{"*    * "," *  *  ","  **   ","  **   "," *  *  ","*    * "});
        alphabet.put('.', new String[]{"       ","       ","       ","       ","**     ","**     "});
        alphabet.put('\u0020', new String[]{"       ","       ","       ","       ","       ","       "});
        alphabet.put('\u0009', new String[]{"       ","       ","       ","       ","       ","       "});

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
}
