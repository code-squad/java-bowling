package domain.frame;

import domain.Player;
import domain.score.Score;
import domain.score.TotalScore;

import java.util.Optional;

public abstract class Frame {
    final TotalScore totalScore;
    final int frameNo;

    public abstract Optional<Frame> playNextFrame(Player player);

    public abstract Frame nextFrame(TotalScore totalScore);

    public void addSecondScore(Score score) {
        this.totalScore.addSecondScore(score);
    }

    Frame(TotalScore totalScore, int frameNo) {
        if (totalScore == null) {
            throw new IllegalArgumentException();
        }
        this.totalScore = totalScore;
        this.frameNo = frameNo;
    }

    Frame play(Player player) {
        Frame frame = playFirstScore(player);
        if (!frame.totalScore.isStrike()) {
            frame.addSecondScore(player.play(getNextFrameNo()));
            player.notifyFrameChanged();
        }
        return frame;
    }

    Frame playFirstScore(Player player) {
        Score firstScore = player.play(getNextFrameNo());
        Frame frame = nextFrame(new TotalScore(firstScore));
        player.addFrame(frame);

        return frame;
    }

    int getNextFrameNo() {
        return frameNo + 1;
    }

    @Override
    public String toString() {
        return totalScore.toString();
    }
}
