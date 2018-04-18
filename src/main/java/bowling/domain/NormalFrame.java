package bowling.domain;

public class NormalFrame {
    private FirstBowl first = new FirstBowl();
    private SecondBowl second = new SecondBowl();

    public Integer bowl(int pins) {
        if (!firstIsPlayed()) { //첫번째 투구
            return first.bowl(pins);
        }
        if (firstIsStrike() && !secondIsPlayed()) { //두번째 투구: 첫번째가 스트라이크
            return second.bowl(null, pins);
        }
        return second.bowl(first.calculatePinsLeft(), pins); //두번째 투구: 첫번째가 스트라이크 X
    }

    public boolean firstIsPlayed() {
        return first.isPlayed();
    }

    public boolean secondIsPlayed() {
        return second.isPlayed();
    }

    public boolean firstIsStrike() {
        return first.isStrike();
    }

    public boolean secondIsSpare() {
        return second.isSpare();
    }

    @Override
    public String toString() {
        return null;
    }
}