package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String car2Json = car.serialize();
        Files.write(path, Collections.singleton(car2Json), StandardCharsets.UTF_8);
    }

    public static Car extract(Path path) throws Exception {
        String jsonCar = Files.readString(path);
        return Car.deserialize(jsonCar);
    }

}
// END
