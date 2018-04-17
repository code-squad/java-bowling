package state;

import domain.Pins;

public class Open extends State {

    Pins first;
    Pins second;

    public Open(Pins first, Pins second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        return first.print() + "|" + second.print();
    }
}
