package state;

import domain.Pins;

public class Spare extends State {
    private static final String PIPE = "|";
    private static final String SPARE = "/";


    Pins first;
//    Pins second;
    public Spare(Pins first) {
        super(true);
        this.first = first;
    }

    @Override
    public String printState() {
        return first.print() + PIPE + SPARE;
    }
}
