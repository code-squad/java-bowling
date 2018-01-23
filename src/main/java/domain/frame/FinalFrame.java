package domain.frame;

import domain.Player;
import domain.score.TotalScore;

import java.util.Optional;

public class FinalFrame extends Frame {

    FinalFrame(TotalScore totalScore, int frameNo) {
        super(totalScore, frameNo);
        if (frameNo != 10) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Frame> playNextFrame(Player player) {
        if (totalScore.isStrike()) {
            return Optional.of(play(player));
        }
        if (totalScore.isSpare()) {
            return Optional.of(playOnlyFirst(player));
        }
        return Optional.empty();
    }

    @Override
    public Frame nextFrame(TotalScore totalScore) {
        return new BonusFrame(totalScore, getNextFrameNo());
    }
}
