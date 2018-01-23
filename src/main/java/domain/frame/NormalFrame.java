package domain.frame;

import domain.Player;
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
    public Optional<Frame> playNextFrame(Player player) {
        return Optional.of(play(player));
    }

    @Override
    public Frame nextFrame(TotalScore totalScore) {
        if (frameNo == 9) {
            return new FinalFrame(totalScore, getNextFrameNo());
        }
        return new NormalFrame(totalScore, getNextFrameNo());
    }
}
