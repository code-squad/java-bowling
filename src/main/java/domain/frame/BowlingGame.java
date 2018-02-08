package domain.frame;

import domain.Player;
import domain.ScoreBoard;
import domain.score.Ready;
import domain.score.State;

import java.util.Optional;

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

        State state = Ready.bowl(player.play());
        NormalFrame first = new NormalFrame(state);
        playBowlingUntilFinish(first);

        scoreBoard.printGameResult(this);
    }

    private void playBowlingUntilFinish(Frame now) {
        updateFrames(now);
        Optional<Frame> next = now.bowl(player.play());

        if (next.isPresent()) {
            playBowlingUntilFinish(next.get());
        } else {
            updateFrames(now);
        }
    }

    private void updateFrames(Frame frame) {
        frames.updateFrame(frame);
        scoreBoard.printGameResult(this);
    }

    @Override
    public String toString() {
        String frameScores = String.format("| %s  |%s|", player, frames);
        String sumOfScores = String.format("|      |%s|", frames.sumOfScores());

        return String.format("%s\n%s", frameScores, sumOfScores);
    }
}
