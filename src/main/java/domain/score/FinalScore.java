package domain.score;

import java.util.Optional;

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
    public Optional<Integer> getTotalScore() {
        if (!canCalculate()) {
            return Optional.empty();
        }
        int b = bonus == null ? 0 : bonus.toInt();
        return Optional.of(first.toInt() + second.toInt() + b);
    }

    @Override
    public boolean isStrike() {
        return first.isStrike();
    }

    @Override
    public Integer getFirstScore() {
        return first.toInt();
    }

    @Override
    public Optional<Integer> getSecondScore() {
        if (second == null) {
            return Optional.empty();
        }
        return Optional.of(second.toInt());
    }

    private boolean canCalculate() {
        return isFinish();
    }

    @Override
    public String toString() {
        String secondString = second == null ? " " : second.toString();
        String bonusString = bonus == null ? " " : bonus.toString();
        return first.toString() + "|" + secondString + "|" + bonusString;
    }
}
