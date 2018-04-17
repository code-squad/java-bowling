package state;

import domain.Pins;

public class NotFinish extends State {
    private static final String PIPE = "|";

    Pins first;

    public NotFinish(Pins first) {
        super(false);
    }

    @Override
    public String printState() {
        return first.print();
    }
}
