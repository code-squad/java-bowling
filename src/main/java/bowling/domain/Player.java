package bowling.domain;

import java.util.List;

public class Player {
    private final Frames frames;
    private final String playerName;

    public Player(String playerName) {
        this.frames = new Frames();
        this.playerName = playerName;
    }

    public void updateFrames(int frameNumber, int pinsKnocked) {
        frames.updateFrame(frameNumber, pinsKnocked);
    }

    @Override
    public String toString() {
        return "|" + Formatter.formatFrame("  " + playerName) + frames.toString();
    }
}