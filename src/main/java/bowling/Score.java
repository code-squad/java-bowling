package bowling;

/**
 * @author sangsik.kim
 */
public class Score {
    private int frameNumber;
    private String scoreText;

    public Score(int frameNumber, String scoreText) {
        this.frameNumber = frameNumber;
        this.scoreText = scoreText;
    }

    public int getFrameNumber() {
        return this.frameNumber;
    }

    public String toText() {
        return this.scoreText;
    }
}
