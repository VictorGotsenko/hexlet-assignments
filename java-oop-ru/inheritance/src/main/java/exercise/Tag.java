package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {

    protected String name;
    protected Map<String, String> attribute;


    public Tag(String name, Map<String, String> attribute) {
        this.name = name;
        this.attribute = attribute;
    }

}
// END
