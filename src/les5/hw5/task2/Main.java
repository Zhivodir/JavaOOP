package les5.hw5.task2;

/**
 * Created by User on 27.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        SamplingSameWords ssw = new SamplingSameWords("C:\\DevKit\\Temp\\Source\\3.txt",
                "C:\\DevKit\\Temp\\Source\\5.txt",
                "C:\\DevKit\\Temp\\Target\\task2Result.txt");
        ssw.writeFile();
    }
}
