package exercise;

// BEGIN
public interface Home {
    double getArea();
    default int compareTo(Home another) {
        if (another.getArea() < this.getArea()) {
            return -1;
        } else if (another.getArea() > this.getArea()) {
            return 1;
        }
        return 0;
    }
}
// END
