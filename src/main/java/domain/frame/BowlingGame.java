package domain.frame;

import domain.Player;
import domain.ScoreBoard;

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
        NormalFrame first = new NormalFrame(player.play());
        frames.updateFrame(first);
        playBowlingUntilFinish(first);

        scoreBoard.printGameResult(this);
    }

    private void playBowlingUntilFinish(Frame frame) {
        frame.bowl(player.play())
             .ifPresent(f -> {
                 frames.updateFrame(f);
                 notifyFrameChanged();
                 playBowlingUntilFinish(f);
             });
        frames.updateFrame(frame);
    }

    public String getUpdatedScoreResult() {
        return frames.getScoresToString();
    }

    private void notifyFrameChanged() {
        scoreBoard.printGameResult(this);
    }

    @Override
    public String toString() {
        return "| " + player + "  |" + frames.toString();
    }
}
