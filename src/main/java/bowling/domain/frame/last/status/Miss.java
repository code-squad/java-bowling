package bowling.domain.frame.last.status;

class Miss implements Status {
    private final int pins;

    Miss(int pins) {
        this.pins = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (this.pins + pins == ALL) {
            return new Spare(pins);
        }
        return new Miss(pins);
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
    public boolean isPlayed() {
        return true;
    }

    @Override
    public int getScore() {
        return pins;
    }

    @Override
    public String toString() {
        return String.valueOf(pins);
    }
}