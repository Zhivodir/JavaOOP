package les4;

import java.io.File;

/**
 * Created by User on 20.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        //Cat cat = new Cat("Vaska", "White", 5);
        CatController catcon = new CatController();
        catcon.setCatDAO(new CatDAOSVCimplemetation(new File("cat.txt")));

        //catcon.saveCat(cat);

        Cat catOne = catcon.loadCat();
        System.out.println(catOne);
    }

}
