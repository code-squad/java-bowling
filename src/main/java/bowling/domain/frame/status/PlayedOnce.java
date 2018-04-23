package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.pins.Pins;

class PlayedOnce extends Incomplete {
    private final Pins first;

    PlayedOnce(int pins) {
        this.first = Pins.ofFirstBowl(pins);
    }

    @Override
    public Status bowl(int pins) {
        if (first.getPins() + pins == ALL) {
            return new Spare(first.getPins(), pins);
        }
        return new Miss(first.getPins(), pins);
    }

    @Override
    public boolean isPlayed() {
        return true;
    }

    @Override
    public Score createScore() {
        return Score.ofPlayedOnce(first.getPins());
    }

    @Override
    public void updateScore(Score score) {
        if (score.twoMoreBowlsNeeded()) { //다음프레임이 전프레임 점수 계산할 때, 점수 두 개를 필요로 하는데 현 상태는 incomplete
            return;
        }
        score.bowl(first.getPins()); //점수 하나만 필요로 하면
    }

    @Override
    public String toString() {
        return first.toString();
    }
}