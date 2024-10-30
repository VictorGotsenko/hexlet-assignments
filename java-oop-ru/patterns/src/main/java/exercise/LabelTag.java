package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface htmlTag;
    private String value;


    public LabelTag(String value, TagInterface tag) {
        this.value = value;
        this.htmlTag = tag;
    }

    @Override
    public String render() {
        return "<label>" + value + htmlTag.render() + "</label>"; // <label>Press Submit<input type="submit" value="Save"></label>
    }
}
// END
