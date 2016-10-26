package les5.hw5.task2;

import com.sun.deploy.util.StringUtils;

import java.io.*;

/**
 * Created by User on 26.10.2016.
 */
public class SamplingSameWords {
    public static void main(String[] args) {
        SamplingSameWords ssw = new SamplingSameWords();
        String resultFile = "C:\\DevKit\\Temp\\Target\\task2Result.txt";

        String [] mas1 = ssw.readFile("C:\\DevKit\\Temp\\Source\\3.txt");
        String [] mas2 = ssw.readFile("C:\\DevKit\\Temp\\Source\\5.txt");
        String [] result = new String[mas1.length < mas2.length ? mas1.length : mas2.length];

        int count = 0;
        for (String word1:mas1) {
            for(String word2:mas2){
                if(word1.equals(word2)){
                    boolean flag = false;
                    for (int i=0; i < count+1; i++) {
                        if(word1.equals(result[i])){
                            flag = true;
                           break;
                        }
                    }
                    if(flag != true){
                        result[count] = word1;
                        count++;
                    }
                }
            }
        }

        try(BufferedWriter f = new BufferedWriter(new FileWriter(resultFile))){
            for (String word : result) {
                if(word != null) {
                    f.write(word + " ");
                }
            }
        } catch(IOException e){
            System.out.println();
        }
    }

    public String [] readFile(String path){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while (true) {
                String buffer = reader.readLine();
                if (buffer == null) {
                    break;
                }
                sb.append(buffer + "\n");
            }
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        String contentOfFile = sb.toString().replaceAll("\\W"," ");
        return contentOfFile.split("\\s+");
    }
}
