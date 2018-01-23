package domain.frame;

import domain.Referee;
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
    public Optional<Frame> playNextFrame(Referee referee) {
        if (totalScore.isStrike()) {
            return Optional.of(playFrame(referee));
        }
        if (totalScore.isNeedAdditionalScore()) {
            return Optional.of(playOnlyFirst(referee));
        }
        return Optional.empty();
    }

    @Override
    public Frame nextFrame(TotalScore totalScore) {
        return new BonusFrame(totalScore, getNextFrameNo());
    }
}
