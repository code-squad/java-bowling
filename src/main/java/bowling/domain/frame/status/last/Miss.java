package bowling.domain.frame.status.last;

public class Miss implements Status {
    private final int pins;

    public Miss(int pins) {
        this.pins = pins;
    }

    public Status bowl(int pins) {
        if (this.pins + pins == 10) {
            return new Spare();
        }
        return new Miss(pins);
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(pins);
    }
}
