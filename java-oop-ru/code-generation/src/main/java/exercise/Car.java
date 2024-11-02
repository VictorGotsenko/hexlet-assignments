package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

// BEGIN
@Value
@Builder
// END
class Car implements Serializable {

    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public static Car deserialize(String string) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(string, Car.class);
    }

    // END
}
