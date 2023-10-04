package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tagBody;
    List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    public String toString() {
        String childrenStr = children.stream()
                .map(child -> child.toString())
                .collect(Collectors.joining());
        return String.format("%s%s%s</%s>", super.toString(), tagBody, childrenStr, tagName);
    }
}
// END
