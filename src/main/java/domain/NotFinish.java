package domain;

public class NotFinish extends State {
    private static final String PIPE = "|";

    public NotFinish() {
        super(false);
    }

    @Override
    public String printState(Pins first, Pins second) {
        return first.print();
    }
}
