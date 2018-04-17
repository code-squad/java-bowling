package state;

public class Strike extends State implements Cloneable {
    public Strike() {
        super(true);
    }

    @Override
    public String printState() {
        return "x";
    }

    public State throwing(int throwing) {
        if (throwing == 10) {
            return new Strike();
        }

        return new FirstBowl(throwing);
    }

    public static boolean isStrike(State state) {
        return state instanceof Strike;
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
