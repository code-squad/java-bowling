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
            return Optional.of(new FinalFrame(referee.playNextFrame(), frameNo + 1));
        }
        return Optional.of(new NormalFrame(referee.playNextFrame(), frameNo + 1));
    }
}
