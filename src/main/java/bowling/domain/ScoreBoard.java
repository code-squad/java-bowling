package bowling.domain;

public class ScoreBoard {
    private LabelFrames labelFrames;
    private Player player;

    public ScoreBoard(Player player) {
        this.labelFrames = new LabelFrames();
        this.player = player;
    }

    public void updateScores(int frameNumber, int pinsKnocked) {
        player.updateFrames(frameNumber, pinsKnocked);
    }

    public boolean isStrike(int frameNumber) {
        return player.isStrike(frameNumber);
    }

    public boolean isSpare(int frameNumber) {
        return player.isSpare(frameNumber);
    }

    @Override
    public String toString() {
        return labelFrames.toString()
                + "\n"
                + player.toString();
    }
}