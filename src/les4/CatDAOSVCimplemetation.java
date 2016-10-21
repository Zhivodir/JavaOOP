package les4;

import java.io.*;

/**
 * Created by User on 20.10.2016.
 */
public class CatDAOSVCimplemetation implements CatDAO {
    private File file;

    public CatDAOSVCimplemetation(File file) {
        super();
        this.file = file;
    }

    public CatDAOSVCimplemetation(){
        super();
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void saveCat(Cat cat) {
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(cat.getName() + ":" + cat.getColor() + ":" + cat.getAge());
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @Override
    public Cat loadCat() {
        Cat cat = null;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String str = br.readLine();
            String [] data = str.split(":");
            String name = data[0];
            String color = data[1];
            int age = Integer.valueOf(data[2]);
            cat = new Cat(name, color, age);
        }catch(IOException e){
            System.out.println(e);
        }
        return cat;
    }
}
