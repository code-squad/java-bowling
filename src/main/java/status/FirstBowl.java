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

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public boolean isMiss() {
        return false;
    }

    @Override
    public boolean isFirstBowl() {
        return true;
    }
}
