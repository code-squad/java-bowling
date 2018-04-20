package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.normal.NotPlayed;
import bowling.domain.frame.status.normal.Status;
import bowling.domain.util.Formatter;

public class NormalFrame extends Frame {
    private Frame nextFrame;
    private Status status;
    private Score score;

    public NormalFrame(int frameNumber) {
        this.nextFrame = createNextFrame(frameNumber);
        this.status = new NotPlayed();
    }

    private Frame createNextFrame(int frameNumber) {
        if (frameNumber == 9) {
            return new LastFrame();
        }
        return new NormalFrame(frameNumber + 1);
    }

    private boolean scoreIsInitialized() {
        return score != null;
    }

    private Score createScore() {
        if (score == null) {
            return status.createScore();
        }
        return this.score;
    }

    @Override
    public Frame bowl(int pins) {
        status = status.bowl(pins);
        if (status.isComplete() && !scoreIsInitialized()) {
            score = createScore();
            return nextFrame;
        }
        if (status.isComplete() && scoreIsInitialized()) {
            calculateScore();
        }
        return null;
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

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public String convertStatusToPrintable() {
        return Formatter.formatFrame(status.toString())
                + "|"
                + Formatter.formatFrame(nextFrame.convertStatusToPrintable());
    }

    @Override
    public String convertScoreToPrintable() {
        return Formatter.formatFrame(score.toString())
                + "|"
                + Formatter.formatFrame(nextFrame.convertScoreToPrintable());
    }
}