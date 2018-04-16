package domain;

public class Spare extends Status {
    private static final String PIPE = "|";
    private static final String SPARE = "/";

    private Pins first;
    private Pins second;

    public Spare(Pins first, Pins second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() + PIPE + SPARE;
    }
}
