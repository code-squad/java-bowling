package bowling.domain.frame.status.last;

public class Strike implements Status {
    private static final int ALL = 10;
    private Status nextStatus;

    @Override
    public Status bowl(int pins) {
        if (pins == ALL) {
            return nextStatus = new Strike();
        }
        return nextStatus = new Miss(pins);
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
    public boolean isNotPlayed() {
        return false;
    }

    @Override
    public int getScore() {
        return ALL;
    }

    @Override
    public String toString() {
        return "X";
    }
}