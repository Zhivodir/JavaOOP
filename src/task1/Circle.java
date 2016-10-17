package task1;

/**
 * Created by 1 on 14.10.2016.
 */
public class Circle extends Shape {
    private Point center;
    private Point pointOfPerimeter;

    public Circle(Point center, Point pointOfPerimeter) {
        this.center = center;
        this.pointOfPerimeter = pointOfPerimeter;
    }

    public Circle(){}

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getPointOfPerimeter() {
        return pointOfPerimeter;
    }

    public void setPointOfPerimeter(Point pointOfPerimeter) {
        this.pointOfPerimeter = pointOfPerimeter;
    }

    @Override
    public double perimetr() {
        return 2*Math.PI*distanceBetweenPoints(center, pointOfPerimeter) * 4;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(distanceBetweenPoints(center, pointOfPerimeter), 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Perimeter: " + perimetr() +
                " Area: " + area() +
                '}';
    }
}
