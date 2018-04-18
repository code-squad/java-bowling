package bowling.domain;

public class LastFrame implements Frame {
    private Status status;
    private Score score;

    public void bowl(int pins) {
        status = status.bowl(pins);
        score = status.createScore();
    }

    public int getScore(Frame nextFrame) {
        return score.getSum() + nextFrame.calculateAdditionalScore(status);
    }

    public int calculateAdditionalScore(Status status) {
        return score.getSum();
    }
}