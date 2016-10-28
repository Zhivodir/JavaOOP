package les6.hw6.task1;

import java.math.BigInteger;

/**
 * Created by User on 28.10.2016.
 */
public class FactorialInThread implements Runnable{
    private int n;

    public FactorialInThread(int n) {
        super();
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i < this.n; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + "!" + factorial(i));
        }
    }

    private BigInteger factorial(int n){
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i < n; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }
}
