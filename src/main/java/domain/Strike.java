package domain;

public class Strike extends State {

    public Strike() {
        super(true);
    }

    @Override
    public String printState(Pins first, Pins second) {
        return first.print();
    }
}
