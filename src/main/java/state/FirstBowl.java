package state;

public class FirstBowl extends State {
    private int falledPins;

    public FirstBowl(int throwing) {
        super(false);
        falledPins = throwing;
    }

    public State throwing(int throwing) {
        if (falledPins + throwing == 10) {
            return new Spare(falledPins, throwing);
        }

        return new Open(falledPins, throwing);
    }

    @Override
    public String printState() {
        return falledPins + "|";
    }

    public static boolean isFirstBowl(State state) {
        return state instanceof FirstBowl;
    }
}
