package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.Status;

public class LastFrame extends Frame {
    private Frame nextFrame;
    private Status status;
    private Score score;

    private Score createScore() {
        if (score == null) {
            return status.createScore();
        }
        return this.score;
    }

    @Override
    public void bowl(int pins) {
        status = status.bowl(pins);
        if (status.isComplete()) {
            score = createScore();
        }
    }

    @Override
    public int calculateScore() { //TODO: Exception for frame number = 8
        status.updateScore(score);
        nextFrame.calculateAdditionalScore(score);
        return score.getScore();
    }

    @Override
    public int calculateAdditionalScore(Score prevScore) { //TODO: 만약 다음 프레임에서 다 해결 된다면?? 다다음까지 갈 필요가 없다.
        if (status.isStrike()) {
            status.updateScore(prevScore);
            return nextFrame.updateScoreFromPrevPrev(prevScore); //TODO: 만약 다음 프레임까지 가야한다면..
        }
        return status.updateScore(prevScore);
    }

    @Override
    int updateScoreFromPrevPrev(Score prevPrev) {
        return status.updateScore(prevPrev);
    }
}