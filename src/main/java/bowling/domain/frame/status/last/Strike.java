package bowling.domain.frame.status.last;

public class Strike implements Status {

    @Override
    public Status bowl(int pins) {
        if (pins == ALL) {
            return new Strike();
        }
        return new Miss(pins);
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
    public boolean isPlayed() {
        return true;
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