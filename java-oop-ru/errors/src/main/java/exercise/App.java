package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (Exception e) {
            System.out.println("Не удалось посчитать площадь");
        }
        finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
