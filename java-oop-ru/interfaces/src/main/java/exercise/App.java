package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }

    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        List<String> result;
        apartments.sort((v1, v2) -> Double.compare(v1.getArea(), v2.getArea()));
        result = apartments.stream()
                .map(apartment -> apartment.toString())
                .limit(n)
                .collect(Collectors.toList());
                        //(v1,v2)->Double.compare(v1.getArea(), v2.getArea()))

        return result;


    }

}
// END
