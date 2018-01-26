package domain.frame;

import domain.Player;
import domain.ScoreBoard;
import domain.score.Pin;

import java.util.stream.IntStream;

public class BowlingGame {
    private final Frames frames;

    private final Player player;

    private final ScoreBoard scoreBoard;

    public BowlingGame(Player player, ScoreBoard scoreBoard) {
        this.player = player;
        this.frames = new Frames();
        this.scoreBoard = scoreBoard;
    }

    public void playBowling() {
        scoreBoard.printGameResult(this);
        IntStream.rangeClosed(1, 10)
                 .forEach(this::playFrame);
    }

    public String getUpdatedScoreResult() {
        return frames.getUpdateScoreResult();
    }

    private void playFrame(int frameNo) {
        Pin pin = player.play(frameNo);
        Frame frame = nextFrame(pin, frameNo);

        frames.addFrame(frame);
        notifyFrameChanged();

        playFrameUntilFinished(frame, frameNo);
    }

    private void playFrameUntilFinished(Frame frame, int frameNo) {
        while (!frame.isFinish()) {
            frame.bowl(player.play(frameNo));
            notifyFrameChanged();
        }
    }

    private Frame nextFrame(Pin pin, int frameNo) {
        return frameNo == 10 ? new FinalFrame(pin) : new NormalFrame(pin);
    }

    private void notifyFrameChanged() {
        scoreBoard.printGameResult(this);
    }

    @Override
    public String toString() {
        return "| " + player + "  |" + frames.toString();
    }
}
