package bowling.domain.frame.status.last;

public class Spare implements Status {
    private final int pins;
    private Status nextStatus;

    public Spare(int pins) {
        this.pins = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (pins == 10) {
            return nextStatus = new Strike();
        }
        return nextStatus = new Miss(pins);
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return true;
    }

    @Override
    public boolean isNotPlayed() {
        return false;
    }

    @Override
    public int getScore() {
        return pins;
    }

    @Override
    public String toString() {
        return "/";
    }
}