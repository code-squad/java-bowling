package domain;

public class Open extends State {

    public Open() {
        super(true);
    }

    @Override
    public String printState(Pins first, Pins second) {
        return first.print(second);
    }
}
