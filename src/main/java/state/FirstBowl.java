package state;

public class FirstBowl extends State {
    private static final String GUTTER = "-";
    private static final String PIPE = "|";
    private static final int TEN_PINS = 10;

    private int falledPins;

    public FirstBowl(int throwing) {
        super(false);
        falledPins = throwing;
    }

    public State throwing(int throwing) {
        if (falledPins + throwing == TEN_PINS) {
            return new Spare(falledPins, throwing);
        }
        return new Open(falledPins, throwing);
    }

    @Override
    public String printState() {
        String falledPins = String.valueOf(this.falledPins);
        if (this.falledPins == 0) {
            falledPins = GUTTER;
        }
        return falledPins;
    }

    public static boolean isFirstBowl(State state) {
        return state instanceof FirstBowl;
    }
}
