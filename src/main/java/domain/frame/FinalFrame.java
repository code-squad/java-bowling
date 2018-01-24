package domain.frame;

import domain.score.TotalScore;

import java.util.Optional;

public class FinalFrame extends Frame {

    FinalFrame(TotalScore totalScore, int frameNo) {
        super(totalScore, frameNo);
        if (frameNo < 10) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Frame> playNextFrame(BowlingGame game) {
        if (frameNo > 11) {
            return Optional.empty();
        }
        if (totalScore.isStrike()) {
            return Optional.of(game.playNext(this));
        }
        if (totalScore.isSpare()) {
            return Optional.of(game.playNextFirstScore(this));
        }
        return Optional.empty();
    }

    @Override
    Frame nextFrame(TotalScore totalScore) {
        return new FinalFrame(totalScore, getNextFrameNo());
    }
}
