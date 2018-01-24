package domain.frame;

import domain.Player;
import domain.score.Score;
import domain.score.TotalScore;

import java.util.Optional;

public abstract class Frame {
    final TotalScore totalScore;
    final int frameNo;

    public void addSecondScore(Score score) {
        if (score == null) {
            throw new IllegalArgumentException();
        }
        this.totalScore.addSecondScore(score);
    }

    public abstract Optional<Frame> playNextFrame(Player player);

    abstract Frame nextFrame(TotalScore totalScore);

    Frame(TotalScore totalScore, int frameNo) {
        if (totalScore == null) {
            throw new IllegalArgumentException();
        }
        this.totalScore = totalScore;
        this.frameNo = frameNo;
    }

    Frame playNext(Player player) {
        Frame frame = playNextFirstScore(player);
        if (!frame.totalScore.isStrike()) {
            Score secondScore = player.play(getNextFrameNo());
            frame.addSecondScore(secondScore);
            player.notifyFrameChanged();
        }
        return frame;
    }

    Frame playNextFirstScore(Player player) {
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
        return String.format("%-4s", totalScore.toString());
    }
}
