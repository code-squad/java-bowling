package domain;

public class Spare extends State {
    private static final String PIPE = "|";
    private static final String SPARE = "/";

    public Spare() {
        super(true);
    }

    @Override
    public String printState(Pins first, Pins second) {
        return first.print(second);
    }
}
