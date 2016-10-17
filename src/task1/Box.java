package task1;

/**
 * Created by 1 on 14.10.2016.
 */
public class Box extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Box(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Box(){}

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
        return distanceBetweenPoints(pointA, pointB) * 4;
    }

    @Override
    public double area() {
        return Math.pow(distanceBetweenPoints(pointA, pointB) ,2);
    }

    @Override
    public String toString() {
        return "Box{" +
                "Perimeter: " + perimetr() +
                " Area: " + area() +
                '}';
    }
}
