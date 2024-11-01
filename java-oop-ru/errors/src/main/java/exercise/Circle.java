package exercise;

// BEGIN
public class Circle {

    Point centr;
    int radius;

    public Circle(Point centr, int radius) {
        this.centr = centr;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException{
        if (radius < 0) {
            throw new NegativeRadiusException();
        }
        return (Math.PI * radius * radius);
    }
}
// END
