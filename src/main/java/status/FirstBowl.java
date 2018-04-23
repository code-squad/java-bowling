package status;

public class FirstBowl implements State {
    private int first;

    public FirstBowl(int first) {
        this.first = first;
    }

    @Override
    public String displayText() {
        return "  " + first;
    }

    @Override
    public State bowl(int second) {
        if (this.first + second == 10)
            return new Spare(first);
        return new Miss(first, second);
    }

    @Override
    public boolean isFinish() {
        return false;
    }
}
