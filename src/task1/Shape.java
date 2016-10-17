package task1;

/**
 * Created by 1 on 14.10.2016.
 */
public abstract class Shape {
    public abstract double perimetr();
    public abstract double area();
    public double distanceBetweenPoints(Point p1, Point p2){
        return Math.sqrt(Math.pow(p2.getX()- p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
