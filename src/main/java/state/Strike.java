package state;

public class Strike extends State implements Cloneable {
    private static final String STRIKE = "X";
    private static final int TEN_PINS = 10;

    public Strike() {
        super(true);
    }

    @Override
    public String printState() {
        return STRIKE;
    }

    public State throwing(int throwing) {
        if (throwing == TEN_PINS) {
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
