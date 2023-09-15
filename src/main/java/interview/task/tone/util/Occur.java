package interview.task.tone.util;

public class Occur {
    public Character c;
    public Long l;

    public Occur(char c, long l) {
        this.c = c;
        this.l = l;
    }

    @Override
    public String toString() {
        return String.format("%s=%d", c, l);
    }
}