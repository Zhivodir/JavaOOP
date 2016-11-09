package les9.hw.task3;

/**
 * Created by User on 09.11.2016.
 */
public class Bukva {
    private char name;
    private int count = 1;
    private double relativeFrequency = 0;

    public Bukva(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    public double getRelativeFrequency() {
        return relativeFrequency;
    }

    public void setRelativeFrequency(double relativeFrequency) {
        this.relativeFrequency = relativeFrequency;
    }

    @Override
    public String toString() {
        return "Bukva{" +
                name + ": " + relativeFrequency +
                '}';
    }
}
