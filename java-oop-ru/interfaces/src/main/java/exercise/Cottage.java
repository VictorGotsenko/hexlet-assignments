package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }


    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public String toString() {
        return  getFloorCount() + " этажный коттедж площадью "
                                + getArea()
                                + " метров" ; //"2 этажный коттедж площадью 135 метров"
    }
}
// END
