package state;

import domain.Pins;

public class Strike extends State {
    Pins first;

    public Strike(Pins first) {
        super(true);
        this.first = first;
    }

    @Override
    public String printState() {
        return first.print();
    }
}
