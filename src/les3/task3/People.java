package les3.task3;

/**
 * Created by User on 18.10.2016.
 */
public class People {
    private String name;
    private String surname;
    private int age;

    public People(String surname, String name, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public People(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  surname + " " +
                name + " ," +
                age + " years";
    }
}
