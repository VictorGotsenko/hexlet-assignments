package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String text;

    public ReversedSequence(String t) {
        StringBuilder sb = new StringBuilder(t);
        this.text = sb.reverse().toString();
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public char charAt(int n) {
        return text.charAt(n);
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public CharSequence subSequence(int startIndex, int endIndex) {
        return text.subSequence(startIndex, endIndex);

    }

}
// END
