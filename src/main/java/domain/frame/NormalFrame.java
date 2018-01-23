package domain.frame;

import domain.Referee;
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
    public Optional<Frame> playNextFrame(Referee referee) {
        if (frameNo == 9) {
            FinalFrame finalFrame = new FinalFrame(referee.playFrame(getNextFrameNo()), getNextFrameNo());
            referee.reportFrameResult(finalFrame);
            return Optional.of(finalFrame);
        }
        NormalFrame normalFrame = new NormalFrame(referee.playFrame(getNextFrameNo()), getNextFrameNo());
        referee.reportFrameResult(normalFrame);
        return Optional.of(normalFrame);
    }
}
