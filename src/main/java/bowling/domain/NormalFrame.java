package bowling.domain;

public class NormalFrame {
    private FirstBowl first;
    private SecondBowl second;

    public boolean firstIsPlayed() {
        return first != null;
    }

    public boolean secondIsPlayed() {
        return second != null;
    }

    public boolean isStrike() {
        return first.isStrike();
    }

    public boolean isSpare() {
        return second.isSpare();
    }


    @Override
    public String toString() {
        return null;
    }
}