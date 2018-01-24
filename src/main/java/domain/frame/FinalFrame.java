package domain.frame;

import domain.Player;
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
    public Optional<Frame> playNextFrame(Player player) {
        if (frameNo > 11) {
            return Optional.empty();
        }
        if (totalScore.isStrike()) {
            return Optional.of(playNext(player));
        }
        if (totalScore.isSpare()) {
            return Optional.of(playNextFirstScore(player));
        }
        return Optional.empty();
    }

    @Override
    Frame nextFrame(TotalScore totalScore) {
        return new FinalFrame(totalScore, getNextFrameNo());
    }
}
