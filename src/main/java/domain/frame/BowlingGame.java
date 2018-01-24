package domain.frame;

import com.google.common.base.Strings;
import domain.Player;
import domain.ScoreBoard;
import domain.score.Score;
import domain.score.TotalScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    private final List<Frame> frames;

    private final Player player;

    private final ScoreBoard scoreBoard;

    public BowlingGame(Player player, ScoreBoard scoreBoard) {
        this.player = player;
        this.frames = new ArrayList<>();
        this.scoreBoard = scoreBoard;
    }

    public int size() {
        return frames.size();
    }

    public void playBowling() {
        Score firstScore = player.play(1);
        Frame first = new NormalFrame(new TotalScore(firstScore), 1);
        frames.add(first);
        notifyFrameChanged();

        if (!firstScore.isStrike()) {
            first.addSecondScore(player.play(1));
            notifyFrameChanged();
        }

        playBowlingRecursive(first);
    }

    private void playBowlingRecursive(Frame frame) {
        frame.playNextFrame(this)
             .ifPresent(this::playBowlingRecursive);
    }

    Frame playNext(Frame frame) {
        Frame next = playNextFirstScore(frame);
        if (!next.totalScore.isStrike()) {
            Score secondScore = player.play(frame.getNextFrameNo());
            next.addSecondScore(secondScore);
            notifyFrameChanged();
        }
        return next;
    }

    Frame playNextFirstScore(Frame frame) {
        Score firstScore = player.play(frame.getNextFrameNo());
        Frame next = frame.nextFrame(new TotalScore(firstScore));
        frames.add(next);
        notifyFrameChanged();

        return next;
    }

    private void notifyFrameChanged() {
        this.scoreBoard.printGameResult(this);
    }

    private String framesToString() {
        if (frames.size() == 0) {
            return "";
        }
        return frames.stream()
                     .map(Frame::toString)
                     .collect(Collectors.joining("|")) + "|";
    }

    private String remainFrames() {
        int remain = 10 - frames.size();
        if (remain > 0) {
            return Strings.repeat("    |", remain);
        }
        return "";
    }

    @Override
    public String toString() {
        return "| " + player + "  |" + framesToString() + remainFrames();
    }
}
