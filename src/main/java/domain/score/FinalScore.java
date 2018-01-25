package domain.score;

import java.util.Optional;

import static domain.score.Pin.TEN;

public class FinalScore extends Score {

    private Pin bonus;

    public FinalScore(Pin first) {
        super(first);
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
        return !isStrike() && !second.isSpare(first);
    }

    @Override
    public void addResult(Pin pin) {
        if (second == null) {
            if (!isStrike()) {
                TEN.minus(first).minus(pin);
            }
            second = pin;
            return;
        }
        if (bonus == null) {
            if (!second.isStrike() && !second.isSpare(first)) {
                TEN.minus(second).minus(pin);
            }
            bonus = pin;
            return;
        }
        throw new IllegalStateException();
    }

    @Override
    public Optional<Integer> getFrameScore() {
        return getSumOfScore();
    }

    @Override
    public Optional<Integer> getSumOfScore() {
        if (!isFinish()) {
            return Optional.empty();
        }
        int b = bonus == null ? 0 : bonus.toInt();
        return Optional.of(first.toInt() + second.toInt() + b);
    }

    @Override
    public String toString() {
        String secondString = second == null ? " " : second.toString();
        String bonusString = bonus == null ? " " : bonus.toString();
        return first.toString() + "|" + secondString + "|" + bonusString;
    }
}
