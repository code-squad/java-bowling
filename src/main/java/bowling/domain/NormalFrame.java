package bowling.domain;

import bowling.util.ScoreCalculator;

public class NormalFrame extends Frame {
    private Frame nextFrame;

    public NormalFrame(Frame nextFrame) {
        if(nextFrame == null)
            throw new IllegalArgumentException("Next frame can't be a null");

        this.nextFrame = nextFrame;
    }

    @Override
    public Integer getFrameScore() {
        if(score != null)
            return score;

        if(isStrike())
            return score = nextFrame.calculateStrike();

        if(isSpare())
            return score = nextFrame.calculateSpare();

        return score = ScoreCalculator.calculateFrame(firstTry, secondTry);
    }

    @Override
    public Integer calculateStrike() {
        if(isStrike())
            return ScoreCalculator.calculateDoubleStrike(nextFrame.calculateSpare());

        return ScoreCalculator.calculateStrike(firstTry, secondTry);
    }

    @Override
    public Integer calculateSpare() {
        return ScoreCalculator.calculateSpare(firstTry);
    }
}
