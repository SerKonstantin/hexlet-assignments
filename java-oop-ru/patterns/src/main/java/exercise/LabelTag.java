package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface inputTag;
    private String label;

    public LabelTag(String label, TagInterface inputTag) {
        this.inputTag = inputTag;
        this.label = label;
    }

    @Override
    public String render() {
        // <label>Press Submit<input type="submit" value="Save"></label>
        String tag = inputTag.render();
        return String.format("<label>%s%s</label>", label, tag);
    }
}
// END
