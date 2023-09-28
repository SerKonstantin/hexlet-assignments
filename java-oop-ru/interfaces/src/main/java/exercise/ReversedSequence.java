package exercise;

// BEGIN
public class ReversedSequence implements java.lang.CharSequence {
    private String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    public int length() {
        return text.length();
    }

    public char charAt(int index) {
        String reversed = this.toString();
        return reversed.charAt(index);
    }

    public boolean isEmpty() {
        return this.length() == 0;
    }

    public CharSequence subSequence(int start, int end) {
        String reversed = this.toString();
        return reversed.subSequence(start, end);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(text);
        return sb.reverse().toString();
    }
}
// END
