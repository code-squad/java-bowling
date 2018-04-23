package bowling.domain.frame.last;

import bowling.domain.frame.Frame;
import bowling.domain.frame.last.score.Score;
import bowling.domain.frame.last.status.Statuses;
import bowling.domain.util.Formatter;

public class LastFrame implements Frame {
    private final Statuses status;
    private Score score;

    public LastFrame() {
        this.status = new Statuses();
    }

    @Override
    public Frame bowl(int pins) {
        status.bowl(pins);
        return null;
    }

    @Override
    public String calculateScore(int accumulative) { //TODO: Exception for frame number = 8
        score = status.createScore();
        score.accumulateScore(accumulative);
        return score.toString() + "|";
    }

    @Override
    public boolean calculateAdditionalScore(bowling.domain.frame.normal.score.Score prevScore) {
        return status.updateScoresFromPreviousFrames(prevScore);
    }

    @Override
    public boolean updateScoreFromPrevPrev(bowling.domain.frame.normal.score.Score prevPrev) {
        return status.updateScoresFromPreviousFrames(prevPrev);
    }

    @Override
    public boolean isLast() {
        return status.isComplete();
    }

    @Override
    public String convertStatusToPrintable() {
        return Formatter.formatFrame(status.toString()) + "|";
    }
//
//    @Override
//    public String convertScoreToPrintable() {
//        return Formatter.formatFrame(score.toString()) + "|";
//    }
}