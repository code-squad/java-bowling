package bowling.domain.frame.status.last;

public class Strike implements Status {

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new Miss(pins);
    }

    public boolean isStrike() {
        return true;
    }

    public boolean isSpare() {
        return false;
    }

    @Override
    public String toString() {
        return "X";
    }
}
