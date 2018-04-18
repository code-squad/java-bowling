package bowling.domain;

public class LastFrame {
    private final FirstBowl first = new FirstBowl();
    private final SecondBowl second = new SecondBowl();
    private final BonusBowl bonus = new BonusBowl();

    public Integer bowl(int pins) {
        if (!firstIsPlayed()) { //첫번째 투구
            return first.bowl(pins);
        }
        if (firstIsStrike() && !secondIsPlayed()) { //두번째 투구: 첫번째가 스트라이크
            return second.bowl(null, pins);
        }
        if (!firstIsStrike() && !secondIsPlayed()) { //두번째 투구: 첫번째가 스트라이크 X
            return second.bowl(first.calculatePinsLeft(), pins);
        }
        return bonus.bowl(pins);
    }

    public boolean firstIsPlayed() {
        return first.isPlayed();
    }

    public boolean secondIsPlayed() {
        return second.isPlayed();
    }

    public boolean bonusIsPlayed() {
        return bonus.isPlayed();
    }

    public boolean firstIsStrike() {
        return first.isStrike();
    }

    public boolean secondIsStrike() {
        return second.isStrike();
    }

    public boolean secondIsSpare() {
        return second.isSpare();
    }

    @Override
    public String toString() {
        return null;
    }
}