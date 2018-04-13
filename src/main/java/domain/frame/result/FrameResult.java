package domain.frame.result;

public class FrameResult {
    private String message;
    private int score;
    private int totalScore = -1;

    public FrameResult(String frameMessage, int score) {
        this.message = frameMessage;
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }
}
