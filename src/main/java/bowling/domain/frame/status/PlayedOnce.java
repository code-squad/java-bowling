package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

class PlayedOnce extends Incomplete {
    private final int first;

    PlayedOnce(int pins) {
        this.first = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (first + pins == ALL) {
            return new Spare(first, pins);
        }
        return new Miss(first, pins);
    }

    @Override
    public boolean isPlayed() {
        return true;
    }

    @Override
    public Score createScore() {
        return Score.ofPlayedOnce(first);
    }

    @Override
    public void updateScore(Score score) {
        if (score.twoMoreBowlsNeeded()) { //다음프레임이 전프레임 점수 계산할 때, 점수 두 개를 필요로 하는데 현 상태는 incomplete
            return;
        }
        score.bowl(first); //점수 하나만 필요로 하면
    }

    @Override
    public String toString() {
        return String.valueOf(first);
    }
}