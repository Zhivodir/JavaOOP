package les8.hw;

/**
 * Created by User on 18.10.2016.
 */
public class MyException extends Exception {
    @Override
    public String getMessage() {
        return "This group is full.";
    }
}
