package domain.frame;

import domain.Referee;
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
    public Optional<Frame> playNextFrame(Referee referee) {
        if (frameNo > 11) {
            return Optional.empty();
        }
        if (totalScore.isStrike()) {
            BonusFrame bonusFrame = new BonusFrame(referee.playFrame(getNextFrameNo()), getNextFrameNo());
            referee.reportFrameResult(bonusFrame);
            return Optional.of(bonusFrame);
        }
        if (totalScore.isNeedAdditionalScore()) {
            BonusFrame bonusFrame = new BonusFrame(referee.playOnlyFirst(getNextFrameNo()), getNextFrameNo());
            referee.reportFrameResult(bonusFrame);
            return Optional.of(bonusFrame);
        }
        return Optional.empty();
    }
}

