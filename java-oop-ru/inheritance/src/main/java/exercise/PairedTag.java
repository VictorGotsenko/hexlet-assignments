package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String bodyTag;
    private List<Tag> children;
    StringBuilder result = new StringBuilder("<" + name+" ");

    public PairedTag(String name, Map<String, String> attribute, String bodyTag, List<Tag> children) {
        super(name, attribute);
        this.children = children;
        this.bodyTag = bodyTag;
    }

    @Override
    public String toString() {
        for (String key : attribute.keySet()) {
            result.append(key + "=\"");
            result.append(attribute.get(key)+"\" ");
        }
        result.toString();
        result = new StringBuilder(result.deleteCharAt(result.length() - 1) + ">");
        result.append(bodyTag);
        for (int i = 0; i < children.size();i++ ) {
            result.append(children.get(i).toString());
        }
        result.append("</" + name + ">");
        return result.toString();
    }
}
// END
