package domain.score;

import static domain.score.Pin.TEN;

public class FinalScore implements Score {

    private Pin first;

    private Pin second;

    private Pin bonus;

    public FinalScore(Pin first) {
        this.first = first;
        this.bonus = null;
    }

    @Override
    public boolean isFinish() {
        if (bonus != null) {
            return true;
        }
        if (second == null) {
            return false;
        }
        return !first.isStrike() && !second.isSpare(first);
    }

    @Override
    public void addResult(Pin pin) {
        if (second == null) {
            if (!first.isStrike()) {
                TEN.minus(first).minus(pin);
            }
            second = pin;
            return;
        }
        if (bonus == null) {
            bonus = pin;
            return;
        }
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        String secondString = second == null ? " " : second.toString();
        String bonusString = bonus == null ? " " : bonus.toString();
        return first.toString() + "|" + secondString + "|" + bonusString;
    }
}
