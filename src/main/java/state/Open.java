package state;

import domain.Pins;

public class Open extends State implements Cloneable{
    int first;
    int second;

    public Open(int first, int second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        return first + "|" + second;
    }

    @Override
    public State throwing(int throwing) {
        return this;
    }

    public static boolean isOpen(State state) {
        return state instanceof Open;
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
