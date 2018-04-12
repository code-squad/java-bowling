package bowling.domain;

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

    public boolean isStrike(int frameNumber){
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