package les8.hw;

import les4.task4.People;

import java.io.Serializable;

/**
 * Created by User on 18.10.2016.
 */
public class Student extends People implements Serializable {
    private String zachotka;

    public Student(String surname, String name, int age, String zachotka) {
        super(surname, name, age);
        this.zachotka = zachotka;
    }

    public Student() {}

    public String getZachotka() {
        return zachotka;
    }

    public void setZachotka(String zachotka) {
        this.zachotka = zachotka;
    }

    @Override
    public String toString() {
        return super.toString() + " ," + getZachotka();
    }
}
