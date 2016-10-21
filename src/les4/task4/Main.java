package les4.task4;

/**
 * Created by User on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Group group = new Group("DA-99");
        Student st1 = new Student("Tsurko", "Ivan", 23, "DA-9901");
        Student st2 = new Student("Ivanov", "Petro", 23, "DA-9901");
        group.choiseOperation();
        System.out.println(group);
    }
}
