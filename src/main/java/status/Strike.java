package status;

public class Strike implements State {
    @Override
    public String displayText() {
        return "  X   |";
    }

    @Override
    public State bowl(int first) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public boolean isStrike() {
        return true;
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
