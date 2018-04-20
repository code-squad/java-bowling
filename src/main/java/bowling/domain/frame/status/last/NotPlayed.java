package bowling.domain.frame.status.last;

public class NotPlayed implements Status {

    @Override
    public Status bowl(int pins) {
        if (pins == 10) {
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
        return false;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public String toString() {
        return " ";
    }
}