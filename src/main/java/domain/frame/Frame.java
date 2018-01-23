package domain.frame;

import domain.Player;
import domain.score.Score;
import domain.score.TotalScore;

import java.util.Optional;

public abstract class Frame {
    final TotalScore totalScore;
    final int frameNo;

    public void addSecondScore(Score score) {
        this.totalScore.addSecondScore(score);
    }

    public abstract Optional<Frame> playNextFrame(Player player);

    public abstract Frame nextFrame(TotalScore totalScore);

    Frame(TotalScore totalScore, int frameNo) {
        if (totalScore == null) {
            throw new IllegalArgumentException();
        }
        this.totalScore = totalScore;
        this.frameNo = frameNo;
    }

    Frame play(Player player) {
        Score firstScore = player.play(getNextFrameNo());
        Frame frame = nextFrame(new TotalScore(firstScore));
        player.addFrame(frame);

        if (!firstScore.isStrike()) {
            frame.addSecondScore(player.play(getNextFrameNo()));
            player.notifyFrameChanged();
        }
        return frame;
    }

    Frame playOnlyFirst(Player player) {
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
