package task1;

/**
 * Created by 1 on 14.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Circle circle = new Circle(new Point(1,3), new Point(1,0));
        Box box = new Box(new Point(1,1), new Point(1,4), new Point(4,4), new Point(4,1));
        Trapeze trapeze = new Trapeze(new Point(-6,2), new Point(-5,4),
                new Point(-3,4), new Point(1,2));

        board.addShape(circle ,1);
        board.addShape(box ,0);
        board.addShape(trapeze ,3);
        board.getInfo();

        board.deleteShape(trapeze);
        board.getInfo();
    }
}
