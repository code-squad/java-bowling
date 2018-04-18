package state;

public class Spare extends State {
    private static final String PIPE = "|";
    private static final String SPARE = "/";
    private static final String GUTTER = "-";

    int first;
    int second;

    public Spare(int first, int second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        String first = String.valueOf(this.first);
        if (this.first == 0) {
            first = GUTTER;
        }
        return first + PIPE + SPARE;
    }

    public State throwing(int throwing) {
        if (throwing == 10) {
            return new Strike();
        }
        return new FirstBowl(throwing);
    }

    public static boolean isSpare(State state) {
        return state instanceof Spare;
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
