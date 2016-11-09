package les9.hw.task3;

/**
 * Created by User on 09.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        CountOfAlphabet coa = new CountOfAlphabet("c:/DevKit/Temp/Source/test.txt");
        coa.readFromFile();
        coa.showList();
    }
}
