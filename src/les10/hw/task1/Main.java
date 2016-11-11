package les10.hw.task1;

import java.io.File;

/**
 * Created by User on 10.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator(new File("c:/DevKit/Temp/Source/English.in"));
        translator.choiseOperation();
    }
}
