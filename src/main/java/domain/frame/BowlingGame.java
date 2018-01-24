package domain.frame;

import com.google.common.base.Strings;
import domain.Player;
import domain.ScoreBoard;
import domain.score.Pin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        IntStream.rangeClosed(1, 10)
                 .forEach(this::playBowling);
    }

    private void playBowling(int frameNo) {
        Pin pin = player.play(frameNo);
        Frame frame = nextFrame(pin, frameNo);

        frames.add(frame);
        notifyFrameChanged();

        playBowlingUntilFinished(frame, frameNo);
    }

    private Frame nextFrame(Pin pin, int frameNo) {
        return frameNo == 10 ? new FinalFrame(pin) : new NormalFrame(pin);
    }

    private void playBowlingUntilFinished(Frame frame, int frameNo) {
        while (!frame.isFinish()) {
            frame.addResult(player.play(frameNo));
            notifyFrameChanged();
        }
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
