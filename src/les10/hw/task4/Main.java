package les10.hw.task4;

import java.io.File;

/**
 * Created by User on 11.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        ASCIIAlphabet asciiAlphabet = new ASCIIAlphabet(new File("c:/DevKit/Temp/Source/Alphabet.txt"));
        asciiAlphabet.prepareListForPrint();
        asciiAlphabet.printList();
    }
}
