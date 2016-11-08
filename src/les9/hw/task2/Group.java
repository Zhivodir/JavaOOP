package les9.hw.task2;

import java.io.*;
import java.util.*;

/**
 * Created by User on 18.10.2016.
 */
public class Group implements Voenkom, Serializable {
    private List<Student> group = new ArrayList<>();
    private String name;

    public Group(String name) {
        this.name = name;
        group.add(new Student("1","1",1,"2"));
        group.add(new Student("1","1",1,"2"));
        group.add(new Student("1","1",1,"2"));
        group.add(new Student("1","1",1,"2"));
        group.add(new Student("1","1",1,"2"));
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

            for (int num = 0; num < group.size(); num++) {
                if (group.get(num) == null) {
                    group.set(num, student);
                    break;
                } else if (num == group.size() - 1) {
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
            group.remove(position);
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
                    Collections.sort(group, compareByAge);
                    break;
                case 2:
                    Collections.sort(group, compareBySurname);
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
        Student [] temp = new Student[group.size()];
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
        for (int i = 0; i < group.size(); i++) {
            if(group.get(i) != null) {
                sb.append("  " + group.get(i).toString() + System.lineSeparator());
            }
        }
        sb.append("}");
        sb.append(System.lineSeparator());
        return sb.toString();
    }


    public void saveGroup(){
        try(ObjectOutputStream OOS = new ObjectOutputStream(
                new FileOutputStream(ManagerOfGroup.rootPath + "/" + this.name + ".txt"))){
            OOS.writeObject(this);
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("ERROR save group !!!");
        }catch(IOException e1){e1.printStackTrace();}
    }
}
