package bowling.domain.frame.status.last;

public class Spare implements Status {
    private final int pins;

    public Spare(int pins) {
        this.pins = pins;
    }

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new Miss(pins);
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return true;
    }

    public int getScore() {
        return pins;
    }

    @Override
    public String toString() {
        return "/";
    }
}
