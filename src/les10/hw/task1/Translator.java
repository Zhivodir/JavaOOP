package les10.hw.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 10.11.2016.
 */
public class Translator implements Serializable{
    transient private File file;
    private Map<String, String> vocabulary = new HashMap<>();


    public Translator(File file) {
        this.file = file;
        vocabulary.put("this", "ця");
        vocabulary.put("program", "программа");
        vocabulary.put("translate", "перекладае");
        vocabulary.put("text", "текст");
    }

    public String readFromFile(){
        if(file == null){
            throw new IllegalArgumentException("Null");
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text = "";
            while ((text = br.readLine()) != null) {
                sb.append(text.toLowerCase());
            }
        }catch (IOException e){e.printStackTrace();}
        return sb.toString();
    }

    public void translate(){
        String textForTranslate = readFromFile();
        StringBuilder sb = new StringBuilder();
        String[] words = textForTranslate.split(" ");
        for(String word:words){
            if(vocabulary.containsKey(word)){
                sb.append(vocabulary.get(word));
                sb.append(" ");
            }else {
                sb.append("\'" + word + "\'");
                sb.append(" ");
            }
        }try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/DevKit/Temp/Target/Ukrainian.out"),"UTF-8"));
        ){
            out.write(sb.toString());
        }catch (IOException e){e.printStackTrace();}
    }

    public void addNewWord(){
        try {
            System.out.println("Enter English word:");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String key = reader1.readLine();
            System.out.println("Enter his translation into Ukrainian:");
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            String value = reader2.readLine();
            vocabulary.put(key, value);
        }catch (IOException e){e.printStackTrace();}
    }

    public void saveVocabulary(){
        System.out.println("Enter name for file-vocabulary:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try {
            fileName = reader.readLine();
        }catch(IOException e){e.printStackTrace();}
        try(ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(
                file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")) + "/" + fileName + ".txt"))){
            OOS.writeObject(this);
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("ERROR save vocabulary !!!");
        }catch(IOException e1){e1.printStackTrace();}
    }

    public void choiseOperation(){
        boolean flagOfExit = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(flagOfExit) {
            System.out.println("Choise operation:");
            System.out.println("1. Add new words.");
            System.out.println("2. Translate text.");
            System.out.println("3. Save vocabulary.");
            System.out.println("0. Exit.");
            try {
                int choise = Integer.parseInt(reader.readLine());
                switch (choise) {
                    case 0:
                        flagOfExit = false;
                        break;
                    case 1:
                        addNewWord();
                        break;
                    case 2:
                        translate();
                        break;
                    case 3:
                        saveVocabulary();
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
