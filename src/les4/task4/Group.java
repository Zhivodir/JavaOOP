package les4.task4;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by User on 18.10.2016.
 */
public class Group implements Voenkom {
    private Student[] group = new Student[10];
    private String name;

    public Group(String name) {
        group[0] = new Student("Tsurko", "Ivan", 21, "DA-9901");
        group[1] = new Student("Ivanov", "Petro", 19, "DA-9901");
        group[2] = new Student("Avanov", "Petro", 20, "DA-9901");
        group[3] = new Student("Fosman", "Isaak", 30, "DA-9901");
        group[4] = new Student("Abdula", "Dark", 17, "DA-9901");
        this.name = name;
    }

    public Group(){}

    public void choiseOperation(){
        boolean flagOfExit = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(flagOfExit){
            System.out.println("List op operations: ");
            System.out.println("1. Add student.");
            System.out.println("2. Delete student.");
            System.out.println("3. Find student.");
            System.out.println("4. Sort list of group.");
            System.out.println("5. Voenkom.");
            System.out.println("6. Save group into the file.");
            System.out.println("7. Load group from the file.");
            System.out.println("0. Exit.");
            System.out.println("Select the operation: ");
            try {
                int numOfOperation = Integer.parseInt(reader.readLine());
                switch (numOfOperation) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        delStudent();
                        break;
                    case 3:
                        findStudent();
                        break;
                    case 4:
                        sortByParametr();
                        System.out.println(this);
                        break;
                    case 5:
                        Student [] temp = findRookie();
                        System.out.println("List of rookies from Group " + name + ":");
                        for (int i = 0; i < temp.length; i++) {
                            if(temp[i] != null) {
                                System.out.println("  " + temp[i].toString());
                            }
                        }
                        break;
                    case 6:
                        saveGroup();
                        break;
                    case 7:
                        Group loadGroup = loadGroup();
                        System.out.println(loadGroup);
                    case 0:
                        flagOfExit = false;
                        break;
                }
            }catch (IOException e){e.printStackTrace();}
        }
    }

    public void addStudent(){
        Student student = null;
        BufferedReader reader;
        try {
            System.out.println("Surname: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String surname = reader.readLine();
            System.out.println("Name: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            System.out.println("Age: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            int age = Integer.valueOf(reader.readLine());
            System.out.println("Zachotka: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String zachotka = reader.readLine();
            student = new Student(surname, name, age, zachotka);
        }catch (IOException e){e.printStackTrace();}

        if(student == null){
            //throw new IllegalArgumentException();
            System.out.println("Data about the student is not entered.");
        }else {

            for (int num = 0; num < group.length; num++) {
                if (group[num] == null) {
                    group[num] = student;
                    break;
                } else if (num == group.length - 1) {
                    try {
                        throw new MyException();
                    } catch (MyException e) {
                        System.out.println("This group is full.");
                    }
                }
            }
        }
    }

    public void delStudent(){
        System.out.println("Choise student for delete: ");
        System.out.println(this);
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int position = Integer.valueOf(reader.readLine());
            System.out.println(position);
            group[position] = null;
        }catch (IOException e){e.printStackTrace();}
    }

    public void findStudent(){
        System.out.println("Enter student's surname for search: ");
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String surname = reader.readLine();
            if(surname == null){throw new IllegalArgumentException();}
            for (Student st:group) {
                if(st == null){continue;}
                //System.out.println(st.getSurname() + " : " + surname);
                if(st.getSurname().equals(surname)){
                    System.out.println(st);
                }
            }
        }catch (IOException e){e.printStackTrace();}
    }

    public void sortByParametr(){
        System.out.println("Choise type of sort(1.byAge 2.bySurname):");
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        try {
            int typeOfSort = Integer.parseInt(reader2.readLine());
            switch (typeOfSort){
                case 1:
                    Arrays.sort(group, compareByAge);
                    break;
                case 2:
                    Arrays.sort(group, compareBySurname);
                    break;
            }
        }catch (IOException e){e.printStackTrace();}
    }

    Comparator<Student> compareBySurname = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            if(o1 == null && o2 == null)  return 0;
            else if(o1 != null && o2 == null)  return 1;
            else if(o1 == null && o2 != null)  return -1;
            else return o1.getSurname().compareTo(o2.getSurname());
        }
    };

    Comparator<Student> compareByAge = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            if(o1 == null && o2 == null)  return 0;
            else if(o1 != null && o2 == null)  return 1;
            else if(o1 == null && o2 != null)  return -1;
            else return o1.getAge() - o2.getAge();
        }
    };

    @Override
    public Student [] findRookie() {
        Student [] temp = new Student[group.length];
        int count = 0;
        for(Student student:group){
            if(student != null && student.getAge() > 18){
                temp[count] = student;
                count++;
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("Group " + name + "{" + System.lineSeparator());
        for (int i = 0; i < group.length; i++) {
            if(group[i] != null) {
                sb.append("  " + group[i].toString() + System.lineSeparator());
            }
        }
        sb.append("}");
        sb.append(System.lineSeparator());
        return sb.toString();
    }


    public void saveGroup(){
        String content = this.toString();
        try(BufferedWriter f = new BufferedWriter(new FileWriter(this.name + ".txt"))){
            f.write(content);
            System.out.println();
        } catch(IOException e){
            System.out.println();
        }
    }

    public Group loadGroup(){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader f = new BufferedReader(new FileReader("C:\\DevKit\\Project\\JavaOOP\\DA-99.txt"))){
            String str="";
            int count = 0;
            for(;(str=f.readLine())!=null;) {
                if(count == 0){
                    //System.out.println(str.matches("[a-q]"));
                    count++;
                }
                sb.append(str);
                sb.append(System.lineSeparator());
            }
        }catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        String content = sb.toString();
        String [] words = content.split(System.lineSeparator());
        Group result = new Group();
        result.name = words[1].substring(6,11);
        for(int i = 2,j = 0; i < words.length - 1; i++){
            String [] dataStudent = words[i].replaceAll(" ","").split(",");
            result.group[j] = new Student(dataStudent[0], dataStudent[1],
                    Integer.parseInt(dataStudent[2].substring(0,2)), dataStudent[3]);
            j++;
        }
       return result;
    }
}
