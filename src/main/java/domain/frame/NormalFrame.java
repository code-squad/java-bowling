package domain.frame;

import domain.score.TotalScore;

import java.util.Optional;

public class NormalFrame extends Frame {

    public NormalFrame(TotalScore totalScore, int frameNo) {
        super(totalScore, frameNo);
        if (frameNo < 0 || frameNo > 9) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Frame> playNextFrame(BowlingGame game) {
        return Optional.of(game.playNext(this));
    }

    @Override
    Frame nextFrame(TotalScore totalScore) {
        if (frameNo == 9) {
            return new FinalFrame(totalScore, getNextFrameNo());
        }
        return new NormalFrame(totalScore, getNextFrameNo());
    }
}
