package domain.frame.result;

public class FrameResult {
    private String message;
    private int score;

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

    @Override
    public String toString() {
        return "FrameResult{" +
                "message='" + message + '\'' +
                ", score=" + score +
                '}';
    }
}
