package les8.hw.blackList;

/**
 * Created by User on 04.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.addObject(new String("str"));
        stack.addObject(new Integer(1));
        stack.addObject(new Object());
        stack.addObject(new Double(3));
        stack.addObject(new Boolean(true));

        for (Object object:stack.getStack()) {
            System.out.println(object);
        }
        System.out.println();

        System.out.println("getElement: " + stack.getObject());
        System.out.println();

        for (Object object:stack.getStack()) {
            System.out.println(object);
        }
        System.out.println();

        System.out.println("takeElement: " + stack.takeObject());
        System.out.println();

        for (Object object:stack.getStack()) {
            System.out.println(object);
        }
        System.out.println();
    }
}
