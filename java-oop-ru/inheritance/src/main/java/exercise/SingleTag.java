package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    StringBuilder result = new StringBuilder("<" + name+" ");

    public SingleTag(String name, Map<String, String> attribute) {
        super(name, attribute);
    }

    @Override
    public String toString() {
        for (String key : attribute.keySet()) {
            result.append(key + "=\"");
            result.append(attribute.get(key)+"\" ");
        }
        result.toString();
        return result.deleteCharAt(result.length()-1) + ">";
    }
}
// END
