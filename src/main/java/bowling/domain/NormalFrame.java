package bowling.domain;

public class NormalFrame implements Frame {
    private FirstBowl first = new FirstBowl();
    private SecondBowl second = new SecondBowl();

    @Override
    public Integer bowl(int pins) {
        if (!firstIsPlayed()) { //첫번째 투구
            return first.bowl(pins);
        }
        if (firstIsStrike() && !secondIsPlayed()) { //두번째 투구: 첫번째가 스트라이크
            return second.bowl(null, pins);
        }
        return second.bowl(first.calculatePinsLeft(), pins); //두번째 투구: 첫번째가 스트라이크 X
    }

    @Override
    public boolean firstIsPlayed() {
        return first.isPlayed();
    }

    @Override
    public boolean secondIsPlayed() {
        return second.isPlayed();
    }

    @Override
    public boolean firstIsStrike() {
        return first.isStrike();
    }

    @Override
    public boolean secondIsSpare() {
        return second.isSpare();
    }

    @Override
    public String toString() {
        return null;
    }
}