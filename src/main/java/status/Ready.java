package status;

public class Ready implements State {
    @Override
    public String displayText() {
        return null;
    }

    public State bowl(int first) {
        if (first == 10)
            return new Strike();
        return new FirstBowl(first);
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
        return false;
    }
}
