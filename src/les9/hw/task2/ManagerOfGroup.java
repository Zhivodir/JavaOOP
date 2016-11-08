package les9.hw.task2;

import java.io.*;

/**
 * Created by User on 04.11.2016.
 */
public class ManagerOfGroup {
    private String [] list = new String[20];
    protected static String rootPath = "C:/DevKit/Temp/Groups";

    public ManagerOfGroup() {
        File source = new File(rootPath);
        File[] fileList = source.listFiles();
        list = new String[fileList.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = fileList[i].getName().substring(0,fileList[i].getName().indexOf("."));
        }
    }

    public void addGroup(){
        System.out.println("Enter a name of new group:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String newGroup = "";
        try {
            newGroup = reader.readLine();
        }catch (IOException e){e.printStackTrace();}
        Group group = new Group(newGroup);
        group.choiseOperation();
    }

    public void workWithGroup(){
        System.out.println("All groups:");
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + 1 + ". " + list[i]);
        }
        System.out.println("Choise the group: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choiseGroup = -1;
        try {
            choiseGroup = Integer.valueOf(reader.readLine());
        }catch (IOException e){e.printStackTrace();}

        Group group = null;
        System.out.println(new File(rootPath + "/" + list[choiseGroup - 1] + ".txt"));
        try (ObjectInputStream OIS = new ObjectInputStream(
                new FileInputStream(new File(rootPath + "/" + list[choiseGroup - 1] + ".txt")))){
            group = (Group)OIS.readObject();
        } catch(IOException e1){e1.printStackTrace();}
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("ERROR load group !!!");
        }
        group.choiseOperation();
    }

    public void deleteGroup(){
        System.out.println("All groups:");
        for (int i = 0; i < list.length; i++) {
            if(list[i] != null) {
                System.out.println(i + 1 + ". " + list[i]);
            }
        }
        System.out.println("Choise the group: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choiseGroup = -1;
        try {
            choiseGroup = Integer.valueOf(reader.readLine());
        }catch (IOException e){e.printStackTrace();}
        File delFile = new File(rootPath + "//" + list[choiseGroup - 1] + ".txt");
        delFile.delete();
        list[choiseGroup - 1] = null;
    }

    public void choiseOperation(){
        boolean flagOfExit = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(flagOfExit){
            System.out.println("List of operations: ");
            System.out.println("1. Add new group.");
            System.out.println("2. Work with group.");
            System.out.println("3. Delete group.");
            System.out.println("0. Exit.");
            System.out.println("Select the operation: ");
            try {
                int numOfOperation = Integer.parseInt(reader.readLine());
                switch (numOfOperation) {
                    case 1:
                        addGroup();
                        break;
                    case 2:
                        workWithGroup();
                        break;
                    case 3:
                        deleteGroup();
                        break;
                    case 0:
                        flagOfExit = false;
                        break;
                }
            }catch (IOException e){e.printStackTrace();}
        }
    }
}
