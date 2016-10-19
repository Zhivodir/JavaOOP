package les3.task3;

/**
 * Created by User on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Group group = new Group("DA-99");
        Student st1 = new Student("Tsurko", "Ivan", 23, "DA-9901");
        Student st2 = new Student("Ivanov", "Petro", 23, "DA-9901");
        group.addStudent(st1);
        group.addStudent(st2);
        group.addStudent(new Student("Antonov", "Oleksandr", 23, "DA-9901"));
        group.addStudent(new Student("Savin", "Shurik", 23, "DA-9902"));
        group.addStudent(new Student("Turchak", "Oleksandr", 23, "DA-9903"));
        group.addStudent(new Student("Sav", "Oleksandr", 23, "DA-9904"));
        group.addStudent(new Student("Ksdf", "Oleksandr", 23, "DA-9905"));
        group.addStudent(new Student("Csdf", "Oleksandr", 23, "DA-9906"));
        group.addStudent(new Student("Ddfg", "Oleksandr", 23, "DA-9907"));
        group.addStudent(new Student("Svdfbvd", "Oleksandr", 23, "DA-9908"));
        group.addStudent(new Student("Mdfgd", "Oleksandr", 23, "DA-9909"));
        group.addStudent(new Student("Qwer", "Oleksandr", 23, "DA-9910"));
        group.addStudent(new Student("Xdvbdf", "Oleksandr", 23, "DA-9911"));
        System.out.println(group);
        System.out.println("Search result: " + group.findStudent("Ivanov"));
        group.delStudent(st1);
        group.delStudent(st2);
        System.out.println(group);
    }
}
