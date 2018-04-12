package bowling.domain;

import bowling.domain.Utils.Formatter;
import bowling.domain.frame.Frames;

public class Player {
    private final Frames frames = new Frames();
    private final String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public boolean updateScores(int frameNumber, int pinsKnocked) {
        return frames.updateFrame(frameNumber, pinsKnocked);
    }

    public boolean isStrike(int frameNumber) {
        return frames.isStrike(frameNumber);
    }

    public boolean isSpare(int frameNumber) {
        return frames.isSpare(frameNumber);
    }

    @Override
    public String toString() {
        return "|" + Formatter.formatFrame("  " + playerName) + frames.toString();
    }
}