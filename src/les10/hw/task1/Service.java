package les10.hw.task1;

import les10.hw.task1.Translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 11.11.2016.
 */
public class Service {
    Translator translator;

    public Service(String path) {
        translator = new Translator(new File(path));
    }


}
