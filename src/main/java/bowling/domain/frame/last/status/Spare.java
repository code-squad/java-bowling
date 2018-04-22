package bowling.domain.frame.last.status;

public class Spare implements Status {
    private final int pins;

    public Spare(int pins) {
        this.pins = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (pins == ALL) {
            return new Strike();
        }
        return new Miss(pins);
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
    public boolean isPlayed() {
        return true;
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