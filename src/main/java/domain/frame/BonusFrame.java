package domain.frame;

import domain.Player;
import domain.score.TotalScore;

import java.util.Optional;

public class BonusFrame extends Frame {

    BonusFrame(TotalScore totalScore, int frameNo) {
        super(totalScore, frameNo);
        if (frameNo != 11 && frameNo != 12) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Frame> playNextFrame(Player player) {
        if (frameNo > 11) {
            return Optional.empty();
        }
        if (totalScore.isStrike()) {
            return Optional.of(play(player));
        }
        if (totalScore.isSpare()) {
            return Optional.of(playFirstScore(player));
        }
        return Optional.empty();
    }

    @Override
    public Frame nextFrame(TotalScore totalScore) {
        return new BonusFrame(totalScore, getNextFrameNo());
    }
}

