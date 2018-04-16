package domain;

public class Open extends State {
    private static final String PIPE = "|";

    private Pins first;
    private Pins second;

    public Open(Pins first, Pins second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() + PIPE + second.toString();
    }
}
