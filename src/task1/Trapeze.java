package task1;

/**
 * Created by 1 on 14.10.2016.
 */
public class Trapeze extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Trapeze(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Trapeze(){}

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Override
    public double perimetr() {
        return distanceBetweenPoints(pointA, pointB) +
               distanceBetweenPoints(pointB, pointC) +
               distanceBetweenPoints(pointC, pointD) +
               distanceBetweenPoints(pointD, pointA);
    }

    @Override
    public double area() {
        double a = distanceBetweenPoints(pointA, pointB);
        double b = distanceBetweenPoints(pointB, pointC);
        double c = distanceBetweenPoints(pointC, pointD);
        double d = distanceBetweenPoints(pointD, pointA);
        return (a + b)/2 *
                Math.sqrt(c*c - Math.pow(((Math.pow(b - a, 2) + c*c - d*d)/2*(b - a)),2));
    }

    @Override
    public String toString() {
        return "Trapeze{" +
                "Perimeter: " + perimetr() +
                " Area: " + area() +
                '}';
    }
}
