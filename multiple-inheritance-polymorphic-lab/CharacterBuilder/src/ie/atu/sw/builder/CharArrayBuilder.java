package ie.atu.sw.builder;

import java.io.IOException;

public class CharArrayBuilder implements Appendable {
    private char[] sequence;
    private int index;

    public CharArrayBuilder() {
        this(8);
    }

    public CharArrayBuilder(int length) {
        this(new char[length]);
    }

    public CharArrayBuilder(char[] s) {
        this.sequence = s;
    }

    public char[] getSequence() {
        return sequence;
    }

    private void expand() {
        // Amortized expansion: increase array size by 1.5x
        char[] t = new char[(sequence.length * 3) / 2];
        for (int i = 0; i < sequence.length; i++) {
            t[i] = sequence[i];
        }
        sequence = t;
    }

    @Override
    public Appendable append(char c) throws IOException {
        if (index >= sequence.length - 1) {
            expand();
        }
        sequence[index] = c;
        index++;
        return this;
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        return append(csq, 0, csq.length());
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        for (int i = start; i < end; i++) {
            append(csq.charAt(i));
        }
        return this;
    }
}
